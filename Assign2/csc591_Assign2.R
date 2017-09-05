library(ggplot2)

working_dir<-"C:\\Drive E\\Fall 2017\\CSC 591\\HW2"
#setwd(working_dir)

#########
file_name<-"data1.csv"

###read .csv files
std_log<-read.table(file_name, sep=",",header=T,check.names = FALSE)

##find rows with missing std_id
missing_ids<-which(std_log$`Student-ID`=="missing")
refined_log<-std_log[-missing_ids,]

##get all distinct student-IDs  from subset_std_step (subset_std_prob)
std_IDs<-as.character(unique(refined_log$`Student-ID`))

### create an empty data frame to fill up std_ID, total actions, total duration (min), and per min actions
b22<-data.frame(student_ID=character(),
                total_actions=integer(), 
                total_duration=double(), 
                actions_per_min=double(),
                stringsAsFactors=FALSE)


for(i in 1:length(std_IDs)){
  
  ### get a std name, and get row indices of all sessions of that std
  curr_std<-std_IDs[i]
  get_session_indecies<-which(refined_log$`Student-ID`==curr_std)
  
  ###Extract rows
  get_session_rows<-refined_log[get_session_indecies,]
  
  ###get total time for all sessions of curr std
  time_spent<-get_session_rows$`Total Time(mins)`
  total_session_time<-sum(time_spent)
  
  ##get total actions of all sessions
  get_DDEs<-get_session_rows$`No of DDEs`
  get_DDE_Post<-get_session_rows$`No of DDE-Post`
  
  ##sum up all actions
  total_actions<-sum(get_DDEs)+sum(get_DDE_Post)
  ##subtract  DDE-POST (set-session-id "<session_id>")
 # and	DDE (read-student-info "<std_ID>" 1)
  actions_modified<-total_actions-2
  
  ### actions/minute, take ceiling values
  action_per_min<-0
  
  if(total_session_time>0)
     action_per_min<-ceiling(actions_modified/total_session_time)
  
  ### insert data item
  b22[i,1]<-curr_std
  b22[i,2]<-actions_modified
  b22[i,3]<-total_session_time
  b22[i, 4]<-action_per_min
  
}


####histograms
duration<-b22[,3]
hist(duration,main="Histogram of Total Time")

actions<-b22[,4]
hist(actions,main="Histogram of Per Min Actions")

### plot total time per std


#p<-ggplot(b22, aes(x=seq(from = 1, to = nrow(b22), by = 1), y=b22[,4], color="total time")) + geom_point(size=3)


#p<-p+ ylab("Total Spent Time (min)") 
#p<-p+xlab("Individual Students")
#p<-p+scale_fill_discrete(name="Experimental\nCondition")

p<-ggplot(b22, aes(x=seq(from = 1, to = nrow(b22), by = 1), y=b22[,3])) + geom_point(size=3, aes(colour="total time"))+
  labs(
    x="Student Count",
    y="Total Spent Time (min)",
    colour="Total Time Per Std"
  )

print(p)


p1<-ggplot(b22, aes(x=seq(from = 1, to = nrow(b22), by = 1), y=b22[,4])) + geom_point(size=3, aes(colour="action per min"))+
  labs(
    x="Student Count",
    y="Actions Per Min",
    colour="Actions Per Min of Each Std"
  )


print(p1)

#### plot w/o outliers, total time/std

outliers<-boxplot.stats(b22[,3])$out
to_remove<-c()

# cat("out ", outliers, "\n")
outlier_rows<-c()
j<-1
while( j<=length(outliers)){
  outlier_rows<-c(outlier_rows, which(b22[,3]==outliers[j]))
  j<-j+1
}

to_remove<-c(to_remove, outlier_rows)

b22_clean_total_time<-b22

if(length(to_remove)>0)
  b22_clean_total_time<-b22[-to_remove,]

p_w_o_outlier<-ggplot(b22_clean_total_time, aes(x=seq(from = 1, to = nrow(b22_clean_total_time), by = 1), y=b22_clean_total_time[,3])) + geom_point(size=3, aes(colour="total time"))+
  labs(
    x="Student Count w/o Outliers",
    y="Total Spent Time (min) w/o Outliers",
    colour="Total Time Per Std"
  )

print(p_w_o_outlier)


####plot w/o outliers, action/min per std
outliers<-boxplot.stats(b22[,4])$out
to_remove_again<-c()

# cat("out ", outliers, "\n")
outlier_rows<-c()
j<-1
while( j<=length(outliers)){
  outlier_rows<-c(outlier_rows, which(b22[,4]==outliers[j]))
  j<-j+1
}

to_remove_again<-c(to_remove_again, outlier_rows)

b22_clean_action_per_min<-b22

if(length(to_remove_again)>0)
  b22_clean_action_per_min<-b22[-to_remove_again,]

p1_w_o_outlier<-ggplot(b22_clean_action_per_min, aes(x=seq(from = 1, to = nrow(b22_clean_action_per_min), by = 1), y=b22_clean_action_per_min[,4])) + geom_point(size=3, aes(colour="action per min"))+
  labs(
    x="Student Count w/o Outliers",
    y="Action Per Min w/o Outliers",
    colour="Actions Per Min of Each Std"
  )

print(p1_w_o_outlier)


