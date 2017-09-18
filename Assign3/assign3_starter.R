library(ggplot2)


working_dir<-"C:\\Drive E\\Fall 2017\\CSC 591\\HW3"
#setwd(working_dir)

#### source another file
source("assign3_descrp.R")

bar_data<-data.frame(std_count=character(), differKC1 = double(), differKC27 = double() , differKC24 = double(), 
                     differKC14 = double(), differKC22 = double(), differKC20 = double(), differKC21 = double(),stringsAsFactors=FALSE)

##insert in bar_dat table difference
for(i in 1:length(std_IDs)){
  
  ##shorten std ID, i.e. stu1 is now s1
  ### sbtract each multi-C from corresponding single KC ME
  bar_data[i, 1]<-gsub("tu","",std_IDs[i],fixed = TRUE)
  bar_data[i, 2]<-(ME_df[i,2+7]-ME_df[i, 2])
  bar_data[i, 3]<-(ME_df[i, 3+7]-ME_df[i, 3])
  bar_data[i, 4]<-(ME_df[i,4+7]-ME_df[i, 4])
  bar_data[i, 5]<-(ME_df[i,5+7]-ME_df[i, 5])
  bar_data[i, 6]<-(ME_df[i, 6+7]-ME_df[i, 6])
  bar_data[i, 7]<-(ME_df[i,7+7]-ME_df[i, 7])
  bar_data[i, 8]<-(ME_df[i,8+7]-ME_df[i, 8])

  
}

###sum by columns, i.e. sum of  (ME_multiKC-ME_singleKC) for all KC
bb<-apply(bar_data[c(1:length(std_IDs)),-1],2, function(x) sum(x))

##print result
cat("printing sum of  (ME_multiKC-ME_singleKC) for all KC\n")
print(bb)

###plot

titles<-c("KC1", "KC27", "KC24", "KC14", "KC22", "KC20", "KC21" )

for(i in 2:ncol(bar_data)){
  
  curr_col<-bar_data[,i]
  ###get only those rowswhich differs in single and multiKC
  row_in<-which(bar_data[, i]!=0)
  
  row_count<-length(row_in)
  
  ###continue to next KC if row_count is 0
  if(row_count==0)
    next
  
  ##extract rows
  tempbar_dat<-bar_data[row_in,]
  
  ##extract column values
  ##tempy<-tempbar_dat[,i]

 ##   q<-ggplot(tempbar_dat, aes(x=seq(from = 1, to = nrow(tempbar_dat), by = 1), y= tempy)) + 
     q<-ggplot(bar_data, aes(x=seq(from = 1, to = nrow(bar_data), by = 1), y= bar_data[,i])) + 
      geom_point(size=3, aes(colour=titles[i-1]))+
      labs(
        x="Student Count",
        y="ME_muli-KC - ME_single-KC",
        colour=paste(titles[i-1])
      )
    
      #geom_bar(stat="identity", width=0.3, fill="steelblue")
    
    print(q)
    
 
 
}##end plotting


### multi-KC better than singleKC
multi_better<-which(bar_data[,c(2:7)]<0)
cat(" multi-KC is better than single KC for ", length(multi_better), "students\n")

single_better<-which(bar_data[,c(2:7)]>0)
cat(" single-KC is better than multi KC for ", length(single_better), "students\n")
