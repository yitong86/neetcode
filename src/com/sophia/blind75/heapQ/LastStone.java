package com.sophia.blind75.heapQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LastStone {

//class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<stones.length; i++) {
            list.add(stones[i]);
        }
        while(list.size() > 1) {
            int val1 = list.get(list.size()-1);
            int val2 = list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-1);

            if(val1>val2 || val2>val1) {
                list.add(Math.abs(val1-val2));
            }
            Collections.sort(list);
        }
        if(list.size()==1) {
            return list.get(0);
        }
        else {
            return 0;
        }
    }
}
//another method using priorityQueue
//class Solution {
//    public int lastStoneWeight(int[] stones) {
//
//        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
//        for(int i = 0; i < stones.length; i++) q.offer(stones[i]);
//        while(q.size() > 1) {
//            int a = q.poll();
//            int b = q.poll();
//            q.offer(a-b);
//        }
//        if(q.isEmpty()) return 0;
//        else return q.poll();
//    }
//}
