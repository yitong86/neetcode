package com.sophia.blind75;

import java.util.HashMap;
import java.util.HashSet;

public class ValidAnagram {

    // class Solution {
    public boolean isAnagram(String s, String t) {

                if(s.length() != t.length()) return false;


                int[] char_count = new int[26];
                for(int i = 0;i<s.length();i++){
                    char_count[s.charAt(i) - 'a']++;
                    char_count[t.charAt(i)- 'a']--;
                }
                for(int count : char_count){
                    if(count != 0){
                        return false;
                    }
                }
                return true;
            }
        }

        //What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
// if(s.length() != t.length()) return false;
//        Map<Character,Integer> map = new HashMap<Character, Integer>();
//        for(int i = 0;i<s.length();i++){
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) +1);
//            map.put(t.chaAt(i),map.getOrDefault(t.charAt(i),0) -1);
//            for(char c: map.keySet()){
//                if(map.get(c) != 0){
//                    return false;
//        }
//        }
//            return true;
//        } }