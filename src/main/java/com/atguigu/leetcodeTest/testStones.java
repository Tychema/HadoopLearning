package com.atguigu.leetcodeTest;

public class testStones{
    public static void main(String[] args) {
        int[] stones= {2,7,4,1,8,1};
        int i=lastStoneWeightII(stones);
        System.out.println(i);
    }
    public static int lastStoneWeightII(int[] stones) {
        int len=stones.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum=sum+stones[i];
        }
        boolean dp[] = new boolean[sum+1];
        dp[stones[0]]=true;
        for(int i=1;i<len;i++){
            for(int j=sum;j>=0;j--){
                if(j+stones[i]<=sum){
                    boolean subState=dp[Math.abs(j-stones[i])];
                    boolean addState=dp[j+stones[i]];
                    dp[j]=(subState) || (addState);
                }
                else{
                    dp[j]=dp[Math.abs(j-stones[i])];
                }
            }
        }
        for(int i=0;i<sum;i++){
            if(dp[i])
                return i;
        }
        return sum;
    }
//        public static int lastStoneWeightII(int[] stones) {
//            int len=stones.length;
//            int sum=0;
//            for(int i=0;i<len;i++){
//                sum=sum+stones[i];
//            }
//            boolean dp[][] = new boolean[len][sum+1];
//            dp[0][stones[0]]=true;
//            int lineNum=sum;
//            int lastLineMaxNum=stones[0];
//            for(int i=1;i<len;i++){
//                lastLineMaxNum=lastLineMaxNum+stones[i];
//                for(int j=0;j<=lastLineMaxNum;j++){
//                    if(j+stones[i]<=sum)
//                        dp[i][j]=(dp[i-1][Math.abs(j-stones[i])]) || (dp[i-1][j+stones[i]]);
//                    else
//                        dp[i][j]=dp[i-1][Math.abs(j-stones[i])];
//                }
//
//            }
//            for(int i=0;i<sum;i++){
//                if(dp[len-1][i])
//                    return i;
//            }
//            return sum;
//        }
}
