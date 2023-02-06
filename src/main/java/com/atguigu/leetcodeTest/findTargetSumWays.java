package com.atguigu.leetcodeTest;

public class findTargetSumWays {
    public static void main(String[] args) {
        int[] nums= {0,0,0,0,0,0,0,0,1};
        int i=findTargetSumWays(nums,1);
        System.out.println(i);
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int len=nums.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum=sum+nums[i];
        }
        if(target>sum){
            return 0;
        }
        int dp[][] = new int[len][sum+1];
        dp[0][nums[0]]=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<sum+1;j++){
                if(j+nums[i]<=sum)
                    dp[i][j]=(dp[i-1][Math.abs(j-nums[i])]) + (dp[i-1][j+nums[i]]);//问题：dp的改动前后的值都要用到，后面的值会被覆盖掉导致需要的值是改过的值
                else
                    dp[i][j]=dp[i-1][Math.abs(j-nums[i])];
            }
        }
        return dp[len-1][Math.abs(target)];
    }
}
