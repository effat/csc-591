import os
import pandas as pd
#os.chdir('C:\\Drive E\\Fall 2017\\CSC 591\\HW2\\Spring2005-usna-anon.dat')     # change working directory to path
log = open('Log.dat','r')   # open the file in this path
Log=log.readlines()
log.close() 

def get_mins(time_str):   # function to convert the time format into minutes
    c=time_str.split(':')
    if len(c)==1:
        time=int(c[0])/60
    elif len(c)==2:
        time = int(c[0])+int(c[1])/60
    elif len(c)==3:
        time= int(c[0])*60+int(c[1])+int(c[2])/60
    return time

def DDE_count(list):        # function to get the count of DDEs used in each log
    count = len([s for s in list if "DDE " in s])
    return count

def DDE_postcount(list):      # function to get the count of DDE-POST used in each log
    count = len([s for s in list if "DDE-POST" in s])
    return count
    
def findids(list):         # function to find the student id and session id from each
    matching = [s for s in list if "DDE (read-student-info" in s]
    if len(matching)==0:
        stid='missing'
    else:
        stid=matching[0].split()[3]
    matching1 = [s for s in list if "DDE-POST (set-session-id" in s]
    if len(matching1)==0:
        sessid='missing'
    else:
        sessid=matching1[0].split()[3]
    return stid,sessid

# cleaning data    
Newlog=[]
# removing empty lines or irrelevant lines without the timing informatioin    
for i in range(len(Log)):
    if Log[i]!='\n':        
        if Log[i][1]==":" or Log[i][2]==":":
            Newlog.append(Log[i])
Stlog=[]
index=[]
# converting the log file into each session logs
for i in range(len(Newlog)):
    if Newlog[i][:4]=='0:00':
        index.append(i)
newindex=[index[0]]
for j in range(1,len(index)):
    if index[j]-index[j-1]>1:
        newindex.append(index[j])
for j in range(len(newindex)-1):
    templog=Newlog[newindex[j]:newindex[j+1]]
    Stlog.append(templog)    # this gives a list of lists where each sublist is a log of for the session

totaltime=[]
DDEcount=[]
DDEpostcount=[]
stidlist=[]
sessidlist=[]
for log in Stlog:
    time=get_mins(log[-1].split()[0])   # find the time for each log
    totaltime.append(time)
    DDEcount.append(DDE_count(log))   # find the no of DDEs for each log
    DDEpostcount.append(DDE_postcount(log))
    stid,sessid=findids(log)     # find the sessoin id and student id from each log
    stidlist.append(stid)
    sessidlist.append(sessid)
data = pd.DataFrame({'Studnet-ID': stidlist,'Session-ID': sessidlist,'Total Time(mins)': totaltime,'No of DDEs': DDEcount,'No of DDE-Post': DDEpostcount
    })    # creating a data table 
data.to_csv('data1.csv', index=False) # converting the data table to csv file

