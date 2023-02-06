package com.atguigu.leetcodeTest;

public class change {
    public static void main(String[] args) {
        int[] nums= {1,2,5};
        int i=change(5,nums);
        System.out.println(i);
    }
    public static int change(int amount, int[] coins) {
        int len=coins.length;
        int dp[][]=new int[len][amount+1];
        dp[0][0]=1;
        for(int i=coins[0];i<amount+1;i=i+coins[0]){
            dp[0][i]=1;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<amount+1;j++){
                if((j-coins[i])>=0)
                    dp[i][j]=dp[i][j-coins[i]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[len-1][amount];
    }
}
