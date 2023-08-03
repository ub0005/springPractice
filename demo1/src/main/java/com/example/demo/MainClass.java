package com.example.demo;

public class MainClass {

	public static void main(String[] args) {
		int[] nums = {-1,-1,-1,-1,-1,0};
		//int[] nums = {2,1,-1};
		System.out.println(findPivot(nums)); 
		
	}
	
	public static int findPivot(int[] nums) {
		int i=0;
        int j=nums.length-1;
        int leftSum=nums[i];
        int rightSum=nums[j];
        while (i!=j) {
            if(leftSum > rightSum) {
                j--;
                if (i !=j)
                	rightSum += nums[j];
            } else {
                i++;
                if (i != j)
                	leftSum += nums[i];
            }
        }
        if (rightSum == leftSum) {
            return i;
        } else {
            return -1;
        }
	}
	
}
