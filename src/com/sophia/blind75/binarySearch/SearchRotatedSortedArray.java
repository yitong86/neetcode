package com.sophia.blind75.binarySearch;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;
//[4,5,6,7,8,0,1,2]
        while(left <= right){
            //mid => index =3 element=>7
            int mid= left + (right - left)/2;
            //look for the pivot element
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
            //[7,8,0,1,2,3,4,5,6]
            //index 4 element 2 = mid
           // else if(nums[left]>nums[mid]){
                //7>2 go right side target = 5
             else{
                 //if left side is not sorted, right side must be sorted
                if(nums[mid]<target && nums[right]>=target){
                    left=mid+1;
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