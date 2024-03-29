package com.sophia.blind75.heapQ;

import java.util.PriorityQueue;
import java.util.Queue;

public class KcloestPointsToOrgin {

    public int[][] kClosest(int[][] points, int k) {
        //define a max heap

    Queue<int[]> maxHeap = new PriorityQueue<>((a, b)-> dist(b) - dist(a));

        //add each points onto the heap
        for(int[] point : points){
                maxHeap.add(point);
                if(maxHeap.size() > k){
                maxHeap.poll();
                }
                }
                //add each points from heap onto an array
                int[][] res = new int[k][2];
                int i = 0;
                while(maxHeap.isEmpty() == false){
                res[i++] = maxHeap.poll();
                }
                //return array
                return res;
                }
private int dist(int[] points){
        int x = points[0];
        int y = points[1];
        return x * x + y * y;
        }

        }