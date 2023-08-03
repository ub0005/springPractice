package com.example.demo.leetocode;

public class moveZeros {

	public static void main(String[] args) {
			int[] nums = {0,0,1};
			int len = nums.length - 1;
			int i = 0;
			while (i < len) {
				if (nums[i] == 0) {
					int l=i;
					if (nums[i + 1] != 0) {
						l=i;
						i++;
					}
					for (int k = l; k < len; k++) {
						nums[k] = nums[k + 1];
					}
					
					nums[len] = 0;
					len--;
				} else {
					i++;
				}
				
			}
	}

}
