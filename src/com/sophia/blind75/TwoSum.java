package com.sophia.blind75;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> complements = new HashMap<>();
            //nums=[2,7,11,15]
            for (int i = 0;i< nums.length;i++){
                int complement = target - nums[i];//9-2 =7= complement
                if(complements.containsKey(complement)){
                    return new int[]{complements.get(complement),i};
                }
                //{(2,0),(7,1),(11,2),(15,3)}
                complements.put(nums[i],i);
            }
            return nums;
      //  }
    }
}
//for (int i = 0;i<nums.length;i++){
//    for(int j = 0;j<nums.length;j++){
//        if(nums[i] + nums[j] == target){
//            return new int[]{i,j}
//        }
//        }
//        }