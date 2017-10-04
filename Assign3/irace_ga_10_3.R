library(GA)
library(irace)

##### calculates toy fitness
###Each row in input file has 4 columns, each column is an attribute of iris flower.
###The construction of a rule is: lower_bound<= attribute_value <= upper bound
### iris has 4 real value attributes. The chromosome length is 4*2= 8, i. e. 2 values associated with each attr, one for lower and
## one for upper bound. The bounds are generated with help of a GA. If any attr satisfies the bounds, it passes the condition.
### A rule is valid if at least 2 attributes pass the condition.


###input file for GA
#input_file<-"C:\\Users\\Effat\\Documents\\RFiles\\iris2.csv"
input_file<-"iris2.csv"

a<-read.table(input_file,sep=",",header=T)# 
a<-subset(a, select = -c(class) )



### you can view the output of ga by commenting out the two lines below 

#GA<-ga(type="real-valued",fitness=calcFit, min=rep(1,8), max=rep(3, 8),  pcrossover =0.8, pmutation = 0.5,
#       popSize=50, maxiter=100)
#summary(GA)

###generate instance
my_instance<-as.data.frame(a)

###param
params<-'
pcross "" r (0.3, 0.9)
pmut "" r  (0.1, 0.7)
'

parameters<-readParameters(text = params)


###targe runner

target.runner<-function(experiment, scenario){
  
  instance <- experiment$instance ## it is fixed
  configuration <- experiment$configuration
  seed          <- experiment$seed
  
  fn<-function(x){
    
    a1<-instance
    denom<-nrow(a1)
    count<-0
    
    for(i in 1:nrow(a1)){
      # print(paste0(x))
      
      res<-rep(FALSE, 4)
      
      att<-1
      geneCnt<-1## count for genes in a chromosome
      
      while(att<=4){
        
        if((x[geneCnt] <= a1[i,att]) && (a1[i,att]<= x[geneCnt+1]) )
          res[att]<-TRUE
        
        att<-att+1
        geneCnt<-geneCnt+2# this must b incresed by 2, 2 genes for each att
      }
      
      
      condMatched<-which(res==TRUE)
      
      if(length(condMatched)> 1) ### toy fitness, returns true if any 2 cond matches
        count<-count+1
      
    }
    
    conf<-(count/denom)*(1)
    
    return(conf)
  }###end fn
  
  
  ###res for optim irace
  res<-ga(type="real-valued",fitness=fn, min=rep(1,8), max=rep(3, 8),  pcrossover =as.numeric(configuration[["pcross"]]), 
          pmutation = as.numeric(configuration[["pmut"]]), seed=seed ,popSize=50, maxiter=20)
  
  #cat("done \n")
  return(list(cost= res@fitnessValue*(-1)))
}


df_array<-vector("list",6)

my_1<-my_instance
my_2<-my_instance
my_3<-my_instance
my_4<-my_instance
my_5<-my_instance
  
df_array[[1]]<-my_instance
df_array[[2]]<-my_1
df_array[[3]]<-my_2
df_array[[4]]<-my_3
df_array[[5]]<-my_4
df_array[[6]]<-my_5


#df_array[[2]]<-my_instance

###define scenario
scenario<-list(targetRunner = target.runner,
               instances = df_array,
               parallel =2,
               maxExperiments = 80,
               logFile = "")

## We check that the scenario is valid. This will also try to execute
## target.runner.
#checkIraceScenario(scenario, parameters = parameters)

#res<-irace(scenario=list(maxExperiments =150, targetRunner=ga_helper, instances=a), 
#           parameters = readParameters(file = "irace_param.txt")  )

tuned.confs <- irace(scenario = scenario, parameters = parameters)