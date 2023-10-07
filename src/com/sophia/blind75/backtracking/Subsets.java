package com.sophia.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums==null || nums.length==0) return result;

        subsets(nums,new ArrayList<Integer>(), 0);
        return result;
    }

    private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // main logic
        // case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, temp, index+1); // move ahead
        temp.remove(temp.size()-1);

        // case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
        subsets(nums, temp, index+1); // move ahead
    }
}
//class Solution {
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Set<List<Integer>> res = new HashSet<>();
//        List<Integer> ds = new ArrayList<>();
//        Arrays.sort(nums); // Sort the input array
//        fun(nums, 0, ds, res);
//
//        for (List<Integer> subset : res) {
//            ans.add(subset);
//        }
//
//        return ans;
//    }
//
//    private void fun(int[] nums, int index, List<Integer> ds, Set<List<Integer>> res) {
//        if (index == nums.length) {
//            res.add(new ArrayList<>(ds));
//            return;
//        }
//
//        ds.add(nums[index]);
//        fun(nums, index + 1, ds, res);
//        ds.remove(ds.size() - 1);
//        fun(nums, index + 1, ds, res);
//    }
//}