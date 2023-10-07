package com.sophia.blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //sort so that we dont contain duplicate subsets
        //like    [1]
        //  [1]         [1,2]
        //[1]  [1,2]  [1,2]  [1,2,2]
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        findSubsets(0 ,nums, new ArrayList<>(), finalList);
        return finalList;
    }

    public void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> finalList){
        finalList.add(new ArrayList<>(ds));
        for(int i=index;i< nums.length;i++){
            //i!= index to avoid nums[-1] for i=0
            if(i!= index && nums[i] == nums[i-1])
                continue;
            ds.add(nums[i]);
            findSubsets(i+1,nums, ds, finalList);
            ds.remove(ds.size() - 1);
        }
    }
}
