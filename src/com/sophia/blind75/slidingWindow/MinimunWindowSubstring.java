package com.sophia.blind75.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimunWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        int left = 0;
        int right = s.length()-1;
        int min = s.length();
        boolean found = false;

        while(j<s.length()){
            char endChar = s.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar, map.get(endChar)-1);
                if(map.get(endChar) == 0) count -=1;
            }
            if(count>0) continue;
            while (count ==0){
                char startChar = s.charAt(i++);
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(endChar)+1);
                    if(map.get(startChar) == 0) count +=1;
                }
            }

            if((j-i)<min){
                left = i;
                right = j;
                min = j-i;
                found = true;
            }
        }
        return !found ? "" :s.substring(left-1,right);//[left-1,right-1]
    }
}
//https://www.youtube.com/watch?v=U1q16AFcjKs&t=16s