package com.sophia.blind75.binarySearch;

public class FindMiniRotatedSortedArr {
    public int findMin(int[] nums) {

        ///if you see sorted array,pl think of binary search
        //nothing in array
        if(nums.length == 0) return -1;
        //one thing in array
        if(nums.length ==1) return nums[0];

    //binary search
        int left = 0;
        int right = nums.length-1;

        while(left <right){
            int midpoint = left + (right -left)/2;
///find the break [3,4,,6,1,2]
            if(midpoint > 0 && nums[midpoint] <nums[midpoint -1]){
                return nums[midpoint];
                //sorted on the left side and not sored on the right side
                //not right
            }else if(nums[left] <= nums[midpoint] && nums[midpoint]> nums[right]){
                left = midpoint +1;
                //left side cut out
            }else{
                //left isn't sorted
                right = midpoint -1;
            }
        }
        return nums[left];
    }

}
