package com.sophia.blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    //class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        //freq map
        //1 3
        //2 2
        //3 1
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);

        }
        //loop thougth hashmap create bucket
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
            int[] res = new int[k];
            int counter = 0;
            for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
                if (bucket[i] != null) {
                    for (Integer integer : bucket[i]) {
                        res[counter++] = integer;
                    }
                }
            }


            return res;
        }
    }

