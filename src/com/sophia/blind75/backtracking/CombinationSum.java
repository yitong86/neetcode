package com.sophia.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getList(0, candidates, target, result, new ArrayList<Integer>());

        return result;
    }

    public void getList(int i, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> list)
    {
        if(target == 0)
        {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(i == candidates.length)
            return;


        int sub = target - candidates[i];
        if(sub >= 0)
        {
            list.add(candidates[i]);
            getList(i, candidates, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
        getList(i+1, candidates, target, result, list);


    }
}