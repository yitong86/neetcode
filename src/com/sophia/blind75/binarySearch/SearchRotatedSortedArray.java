package com.sophia.blind75.binarySearch;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;

        while(left <= right){
            int mid= left + (right - left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //left side sorted
            else if(nums[left]<=nums[mid]){
                if(nums[mid]>target && nums[left]<=target){
                    right=mid-1;
                }
                //right sorted
                else{
                    left=mid+1;
                }
            }
            else if(nums[left]>nums[mid]){
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

}
