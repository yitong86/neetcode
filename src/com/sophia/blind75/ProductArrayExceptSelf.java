package com.sophia.blind75;

import java.util.*;

public class ProductArrayExceptSelf {
    public int[] productexceptself(int[] nums) {
        //Input: nums = [1,2,3,4]
        //Output: [24,12,8,6]
        int N = nums.length;
        int[] left_products = new int[N];
        int[] right_products = new int[N];
        int[] output_arr = new int[N];

        left_products[0] = 1;
        right_products[N-1] = 1;
        for(int i = 1;i<N;i++){
            left_products[i] = nums[i-1]  * left_products[i-1];

        }
        for(int i = N-2;i>=0 ;i--){
            right_products[i] = nums[i+1] * right_products[i+1];

        }
        for(int i = 0;i<N;i++){
            output_arr[i] = left_products[i] * right_products[i];

        }
        return output_arr;
    }
}