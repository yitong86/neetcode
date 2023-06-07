package com.sophia.blind75;

public class FindMinimumInRotatedSortedArray {
  //  class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 0) return -1;
            if(nums.length ==1) return nums[0];


            int left = 0;
            int right = nums.length-1;

            while(left < right){
                int midpoint = left + (right -left)/2;
                if(midpoint > 0 && nums[midpoint] < nums[midpoint -1]){
                    //[9,8,0,2,3]
                    //0<8
                    return nums[midpoint];
                }else if(nums[left] <= nums[midpoint] && nums[midpoint]> nums[right]){
                    //search right
                    //3<5
                    //[3,4,5,1,2]
                    left = midpoint +1;
                }else{
                    //serach left
                    right = midpoint -1;
                }
            }
            return nums[left];
        }

}
