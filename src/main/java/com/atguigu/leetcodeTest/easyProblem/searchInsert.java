package com.atguigu.leetcodeTest.easyProblem;

public class searchInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6,7};
        int i=searchInsert1(nums,3);
        System.out.println(i);
    }
    public static int searchInsert1(int[] nums, int target) {
        if(target<=nums[0]){
            return 0;
        }
        int low=0,high=nums.length,mid=(low+high)/2;
        while(low<high){
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
            mid=(low+high)/2;
        }
        if(target<nums[mid]){
            return mid;
        }else{
            return mid+1;
        }
    }
}
