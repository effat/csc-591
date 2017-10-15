//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class CoinChange{

	public static int NumberofCoins(int[] denomination,int value){
		 //Write your code here to find out minimum number of coins required to provide the change for given value.
		 //This method will have a denomination array and an int which specifies the value as inputs(Please see testcase file)
		 //This method should return the number of coins
        
		int[] dp = new int [value+1];
        dp[0]=0; // do not need any coin to get 0 amount
        for( i=1;i<=value; i++)
            dp[i]= Integer.MAX_VALUE;
     
        for( i=0; i<=value; i++){
            for(int coin: denomination){
                if(i+coin <=value){
                    if(dp[i]==Integer.MAX_VALUE){
                        dp[i+coin] = dp[i+coin];
                    }else{
                        dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
                    }
                }
            }
        } //end for amount
		
		return dp[value];
	}
}
