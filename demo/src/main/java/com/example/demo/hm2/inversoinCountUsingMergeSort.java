package com.example.demo.hm2;

public class inversoinCountUsingMergeSort {

	public static void main(String[] args) {
		int[] inversionArray = new int[] {11, 1};
		int len = inversionArray.length;
		int[] temp = new int[len];
		int count = mergeSort(inversionArray, temp, 0, len-1);
		System.out.println(count);
	}
	
	static int mergeSort(int inversionArray[],int temp[], int left, int right)
	{
	    int mid,inv_count = 0;
	    if(right > left)
	    {
	        mid = (left + right)/2;

	        inv_count += mergeSort(inversionArray,temp,left,mid);
	        inv_count += mergeSort(inversionArray,temp,mid+1,right);

	        inv_count += merge(inversionArray,temp,left,mid+1,right);
	    }
	    return inv_count;
	}
	
	static int merge(int inversionArray[], int temp[], int left, int mid, int right) {
	
	    int i = left, j = mid, k = left;
	    
	    int inversionCount=0;
	    
	    while((i <= mid-1) && (j <= right)){
	        if(inversionArray[i] <= inversionArray[j]){
	            temp[k++] = inversionArray[i++];
	        }
	        else
	        {
	            temp[k++] = inversionArray[j++];
	            inversionCount = inversionCount + (mid - i);
	        }
	    }

	    while(i <= mid - 1)
	        temp[k++] = inversionArray[i++];

	    while(j <= right)
	        temp[k++] = inversionArray[j++];

	    for(i = left ; i <= right ; i++)
	        inversionArray[i] = temp[i];
	    
	    return inversionCount;
	}
	
}
