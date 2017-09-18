
###read file
file_name<-"AssignmentData.csv"

###read .csv files
std_KT<-read.table(file_name, sep=",",header=T,check.names = FALSE)

##total rows
tot_rows<-nrow(std_KT)

##create a new data frame for output: contains crrect prectdiction of each step: Cis, Bayesian prob. of learning a KC based on single KC model: p(Ln), and 
#multi-KC model. This data frame has same number of rows as the input file 


##create data frame
allStdBKTsteps<-data.frame(std_IDs=character(), stepID = integer(), KC_1_Ci = double(), KC_27_Ci = double(), KC_24_Ci = double(), KC_14_Ci=double(), KC_22_Ci = double(),
                           KC_20_Ci = double(), KC_21_Ci = double(),BayesKC_1 = double(), BayesKC_27 = double(), BayesKC_24 =double(), BayesKC_14 =double(),BayesKC_22 = double(), 
                           BayesKC_20 = double(), BayesKC_21 = double(), multiKC =double(), actualPer = integer(), stringsAsFactors=FALSE)



###create data frame ME for single and multi-KC for each student and each KC

ME_df<-data.frame(student_ID=character(),
                  MEsingle_KC_1=double(),  MEsingle_KC_27=double(), MEsingle_KC_24=double(), MEsingle_KC_14=double(), 
                  MEsingle_KC_22=double(),  MEsingle_KC_20=double(), MEsingle_KC_21=double(), MEmulti_KC_1=double(),  MEmulti_KC_27=double(),
                  MEmulti_KC_24=double(),  MEmulti_KC_14=double(),  MEmulti_KC_22=double(),  MEmulti_KC_20=double(), MEmulti_KC_21=double(),
                  stringsAsFactors=FALSE)


###calcKC function

calcKC<-function(perStdKC){
  
  ###KC indices in perStdKC table
  KC_total<-c(4:10)
  
  ###total steps for this std
  totSteps<-nrow(perStdKC)
  
  pL0<-0.5
  pT<-0.1
  pG<-0.1
  pS<-0.1
  
  ###sort perStdKC in ascending order of stepID, col index of stepID is 2
  perStdKC<-perStdKC[order(perStdKC[,2]),]
  
  
  ###create a new data frame
  stepID<-perStdKC[,2]
  KC_1<-rep(0,totSteps)
  KC_27<-rep(0,totSteps)
  KC_24<-rep(0,totSteps)
  KC_14<-rep(0,totSteps)
  KC_22<-rep(0,totSteps)
  KC_20<-rep(0,totSteps)
  KC_21<-rep(0,totSteps)
  BayesKC_1<-rep(0,totSteps)
  BayesKC_27<-rep(0,totSteps)
  BayesKC_24<-rep(0,totSteps)
  BayesKC_14<-rep(0,totSteps)
  BayesKC_22<-rep(0,totSteps)
  BayesKC_20<-rep(0,totSteps)
  BayesKC_21<-rep(0,totSteps)
  multiKC<-rep(0,totSteps)
  actualPer<-perStdKC[,3]
  
  #  cat("check len ", length(stepID), "  ",length(actualPer), " ", length(KC_24), "\n")
  
  perStdBKT<-data.frame(stepID, KC_1, KC_27, KC_24, KC_14, KC_22, KC_20, KC_21,
                        BayesKC_1, BayesKC_27, BayesKC_24, BayesKC_14,
                        BayesKC_22, BayesKC_20,BayesKC_21,
                        multiKC, actualPer)
  
  
  #cat("done \n")
  ###new table KC indices
  newKCindices_local<-c(2:8)
  
  ###BayesKC prob indices for Bayes formula
  BayesKC_indices_local<-c(9:15)
  
  
  for(i in 1:length( KC_total)){
    
    curr_KC<- KC_total[i]
    curr_KC_row_indices<-which(perStdKC[, curr_KC]==1)
    
    ###extract rows which curr KC==1
    curr_KC_rows<-perStdKC[curr_KC_row_indices,]
    
    ####these are the total trials for current KC for this student
    trials<-nrow(curr_KC_rows)
    
    pL_n_1<-pL0
    pLn<-0
    
     ###curr KC index in new df 
    newDFindex<-newKCindices_local[i]
    #### prob KC index in df
    BayesKCindex<-BayesKC_indices_local[i]
    
 
    for(n in 1:trials){
      
      ###get row index containing this stepID in perStdBKT table
      row_index<-which(perStdBKT[,1]==curr_KC_rows[n, 2])
      
      ### check if nth trial is a suceess
      if(curr_KC_rows[n, 3]==1)
      {
        numerator<-pL_n_1*(1-pS)
        denom<-numerator+(1-pL_n_1)*pG
        pL_n_1<-numerator/denom
        
      }##end if trial_n==1
      else
      {
        numerator<-pL_n_1*pS
        denom<-numerator+(1-pL_n_1)*(1-pG)
        pL_n_1<-numerator/denom
        
      }
      
      pLn<-pL_n_1+ (1-pL_n_1)*pT
      
      
      ###current pLn will become pLn-1 in next step
      pL_n_1<-pLn
      
      ### correct performance prediction at this step using this single BKT model
      Cis<-pLn*(1-pS)+(1-pLn)*pG
      
      ###insert value in new df, this is predicted score by single KC model for this step
      ###row_index is index of stepID, and newDFindex is index of this KC model
      perStdBKT[row_index,newDFindex]<-Cis
      
      ###insert Bayes result
      perStdBKT[row_index,BayesKCindex]<-pLn
      
      ###calc for ME for this KC step
      
      
    }###end for trials
    
    
  }###end for KC_total of all KC calculations
  
 
  
  ####clacl multi-KC from dataframe by averaging all predicted prob. of relevant KC's
  for(i in 1:totSteps){
    
    count<-0
    sum<-0
    ###calc all corrected KC pred for this step
    for(j in 1:length(newKCindices_local)){
      
      kc_index<-newKCindices_local[j]
      sum<-sum+perStdBKT[i, kc_index]
      
      if(perStdBKT[i, kc_index]>0)
        count<-count+1
    }
    
   if(count>1)
    sum<-sum/count
    
    ###insert multi-KC value
    perStdBKT[i, 16]<-sum
    
  }###end for calc totSteps
  
  
  
  ME_perKC<-rep(0, length(newKCindices))
  ME_multiKC<-rep(0, length(newKCindices))#mean(multiKC_predicts-actualScores)
  
  actualScores<-perStdBKT[, 17]
  
  ## calc ME
  for(j in 1:length(newKCindices_local)){
    
    kc_index<-newKCindices_local[j]
    KC_row_indices<-which(perStdBKT[, kc_index]>0)
    
    predictedScores<-perStdBKT[KC_row_indices, kc_index]
    muliKCpredicted<-perStdBKT[KC_row_indices, 16]
    actual_scores<-actualScores[KC_row_indices]
    
    me<-mean(predictedScores-actual_scores)
    me_multi<-mean(muliKCpredicted-actual_scores)
    
    ME_perKC[j]<-me
    ME_multiKC[j]<-me_multi
  }

  
 
    return (list(res=perStdBKT, ME_single = ME_perKC, ME_multi= ME_multiKC))
}


##############################################################################################################
##get all distinct student-IDs  from subset_std_step (subset_std_prob)
std_IDs<-as.character(unique(std_KT[, 1]))

###next position to insert element in allStdBKTSteps, initially 0
nextPos<-0


#### call function calcKC for each std
for(i in 1:length(std_IDs)){
  
  ### get a std name, and get row indices of all sessions of that std
  ##gsub(pattern, replacement, x, ignore.case = FALSE, perl = FALSE,
  ### fixed = FALSE, useBytes = FALSE)
  curr_std<-gsub(" ","",std_IDs[i],fixed = TRUE)
  get_KC_indecies<-which(gsub(" ","",std_KT[, 1],fixed = TRUE)==curr_std)
  

  ###Extract rows
  get_KC_rows<-std_KT[get_KC_indecies,]
  totSteps<-nrow(get_KC_rows)
  
  ###calc per std all KCs
  resultKC<-calcKC(get_KC_rows)
  resTable<-resultKC$res
  
  ###insert data in allStdBKTsteps table
 
  for(j in 1:totSteps){
    row_ind<-nextPos+j
    
    allStdBKTsteps[row_ind, 1]<-curr_std
    allStdBKTsteps[row_ind, 2:18]<- resTable[j, 1:17]
    
  }##end for inserting in allStdBKTSteps
  
  ###increment nextPos
  nextPos<-nextPos+totSteps
 # cat("testing ...", nextPos, "\n")
  
  ##insert ME values
  ME_df[i, 1]<-curr_std
  ME_df[i, 2:8]<- resultKC$ME_single
  ME_df[i, 9:15]<- resultKC$ME_multi
  
  cat("done ", curr_std, "\n")
  
}

all_std_stats<-as.data.frame(allStdBKTsteps)
csvFile1_name<-"all_std_stats.csv"
csvFile1<-paste(csvFile1_name, sep="")
write.csv(all_std_stats, csvFile1)
