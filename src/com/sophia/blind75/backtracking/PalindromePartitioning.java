package com.sophia.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
   // class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            partition(s.toCharArray(),res,0,new ArrayList<String>());
            return res;
        }

        private void partition(char[] s,List<List<String>> res,int idx,ArrayList<String> list){
            if(idx==s.length)
                res.add(new ArrayList<String>(list));

            for(int i=idx;i<s.length;i++){
                if(isPalindrome(s,idx,i)){
                    //syntax - String.valueOf(char[] arr,int offset,int count)
                    list.add(String.valueOf(s,idx,i-idx+1));
                    partition(s,res,i+1,list);
                    list.remove(list.size()-1);
                }
            }
        }


        //checking for palindrome
        private boolean isPalindrome(char[] s,int i,int j){
            while(i<j){
                if(s[i++]!=s[j--])
                    return false;
            }
            return true;
        }
    }
