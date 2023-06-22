package com.sophia.blind75;

import java.util.*;

public class ProductArrayExceptSelf {
    public int[] productexceptself(int[] nums) {
        //Input: nums = [1,2,3,4]
        //[2*3*3,1*3*4,...]
        //[24,12,8,6]
        //Output: [24,12,8,6]
        //array to store all left multiplication
        int[] left_products = new int[nums.length];
        ////array to store all right multiplication
        int[] right_products = new int[nums.length];

        left_products[0] = 1;
        //first do not have any element on left
        for(int i = 1;i < nums.length;i++){
            left_products[i] = left_products[i-1] * nums[i-1];
            //left_products[2] = left_products[2-1] * nums[2-1]
            //                  ==3 * 4 =12

        }
        right_products[nums.length-1] = 1;
        for(int i = nums.length-2;i>=0 ;i--){
            right_products[i] = right_products[i+1] * nums[i+1] ;

        }

        int[] output_arr = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            output_arr[i] = left_products[i] * right_products[i];

        }
        return output_arr;
    }
}