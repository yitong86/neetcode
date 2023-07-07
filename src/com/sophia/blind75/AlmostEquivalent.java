package com.sophia.blind75;

public class AlmostEquivalent {
    //class Solution {
        public boolean checkAlmostEquivalent(String word1, String word2) {
            int n = word1.length();
            int[] count = new int[26];

            for(int i = 0; i < n; i++){
                char ch1  = word1.charAt(i);
                char ch2  = word2.charAt(i);
                count[ch1 - 'a']++;
                count[ch2 - 'a']--;
            }

            for(int i = 0; i < count.length; i++){
                if((int)Math.abs(count[i]) > 3){
                    return false;
                }
            }

            return true;
        }
    }

