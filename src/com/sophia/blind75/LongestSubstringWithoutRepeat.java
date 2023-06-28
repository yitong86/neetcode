package com.sophia.blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//sliding window
//https://www.youtube.com/watch?v=EF_6AOeHuBI&t=616s

public class LongestSubstringWithoutRepeat {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        //{A,A,B,A,B,B,A}
        int left = 0, right = 0, n = arr.length;

        //Define table
        //AABABBA
        //{A:3,B:1}
        Map<Character, Integer> hm = new HashMap<>();

        //define maxLen and mostFreq
        int maxLen = 0, mostFreq = 0;

        //find longest repeating character replacement
        while(right < n){
            //Expand the window
            //AABABBA
            //{A:3,B:1}
            //update freq      //value freq    //key
            hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, hm.get(arr[right]));//check mostfreq or current character


            //Shrink the window if we need to replace more than k char
           //NUMOFCharaerReplacement >k
            //windowLenghth - count[freq] <=k  how many place we need to replace
            if((right - left + 1) - mostFreq > k){
                hm.put(arr[left], hm.get(arr[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}