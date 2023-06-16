package com.sophia.blind75;

import java.util.*;

public class GroupAnagrams {

    //class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();
            Map<String,List<String>> map = new HashMap<>();
// strs = ["eat","tea","tan","ate","nat","bat"]
            for(String str :strs){
                //"eat"
                //['e','a','t']
                char[] temArray = str.toCharArray();
                //['a','e','t']
                Arrays.sort(temArray);
                String sortString = new String(temArray);
                //"aet"

                if(map.containsKey(sortString)){
                    map.get(sortString).add(str);
                    //get the key then add value
                }else{
                    List<String> temList = new ArrayList<>();
                    //  result.add(temList);
                    temList.add(str);
                    //["eat","tea",...]
                    map.put(sortString,temList);
                }
            }

            for(Map.Entry<String,List<String>> entry: map.entrySet()){
                result.add(entry.getValue());
            }

            return result;
        }
    }


// 1 loop through each string in the input
// 2 sort the string
// 3 insert into the hashmap
// 4 iterate through the hashmap and put each value in our result array
// 5 return result array
//   // class Solution {
//        public List<List<String>> groupAnagrams(String[] strs) {
//            if(strs == null || strs.length == 0)
//                return new ArrayList<>();
//
//            Map<String,List<String>> frequencyStringsMap = new HashMap<>();
//            //arr[] {"aab","bba,"baa,"abbccc"}
//            for(String str : strs){
//                //a2b1
//                String frequencyString = getFrequencyString(str);
//
//                if(frequencyStringsMap.containsKey(frequencyString)){
//                    frequencyStringsMap.get(frequencyString).add(str);
//              //a2b1 aab
//                }
//                else{
//                    List<String> strList = new ArrayList<>();
//                    strList.add(str);
//                    frequencyStringsMap.put(frequencyString,strList);
//                }
//            }
//            return new ArrayList<>(frequencyStringsMap.values());
//        }
//// getFrequencyString
//        public String getFrequencyString(String str){
//            //frequency buckets
//            int[] freq = new int[26];
//            //iterate over each character
//            for(char c :str.toCharArray()){
//                freq[c-'a']++;
//            }
//            //start creating the frequency string
//            //str = "aabcb"
//            StringBuilder frequencyString = new StringBuilder("");
//            char c = 'a';
//            for(int i :freq){
//                frequencyString.append(c);
//                frequencyString.append(i);
//                c++;
//            }
//            return frequencyString.toString();
//        }


