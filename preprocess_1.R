library(zoo)

working_dir<-"\\afs\\unity.ncsu.edu\\users\\e\\efarhan\\csc-591"

### .txt files downloaded from Datashop

file1<-"student_problem.txt"
file2<-"student_step.txt"

### concatenate path location to filename
input_stdProb<-paste(working_dir,"\\",file1, sep="")
input_stdStep<-paste(working_dir,"\\", file2,sep="")


### read files
std_prb<-read.table(file1,sep="\t",header=T, check.names = FALSE, na.strings=c(""," ",".","NA"))
std_step<-read.table(file2,sep="\t",header=T, check.names = FALSE, na.strings=c(""," ",".","NA"))


##polynomial interpolating missing values in std_prb file
### if all values of a column are NA, then replace it by zeroes

for (Var in names(std_prb)) {
  missing <- sum(is.na(std_prb[,Var]))
  
  if (missing > 0) {
    
    if(missing==nrow(std_prb)){
      std_prb[, Var]<-rep(0,nrow(std_prb))
      cat(" all NA \n")
      }
    
    else{
      interploated<-na.spline(std_prb[, Var])
      std_prb[, Var]<-interploated
      cat(" yey", Var, "\n")
    }
    
  }##end for missing >0
}




##polynomial interpolating missing values in std_step file
### if all values of a column are NA, then replace it by zeroes

for (Var in names(std_step)) {
  missing <- sum(is.na(std_step[,Var]))
  
  if (missing > 0) {
    
    if(missing==nrow(std_step))
      std_step[, Var]<-rep(0,nrow(std_step))
    
    else{
      interploated<-na.spline(std_step[, Var])
      std_step[, Var]<-interploated
      cat(" yey", Var, "\n")
    }
    
  }##end for missing >0
}




###write files as csv
std_prb_clean<-as.data.frame(std_prb)
csvFile1_name<-"student_prb_clean.csv"
csvFile1<-paste(working_dir,"\\",csvFile1_name, sep="")
write.csv(std_prb_clean, csvFile1)


std_step_clean<-as.data.frame(std_step)
csvFile2_name<-"student_step_clean.csv"
csvFile2<-paste(working_dir,"\\",csvFile2_name, sep="")
write.csv(std_step_clean, csvFile2)
