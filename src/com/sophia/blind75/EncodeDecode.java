package com.sophia.blind75;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {


    //Encodes a list of strings to a single string
    public String encode(List<String> strs){
        //length + "/" +strs
        //encode a list of string to a single string
        if(strs == null || strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }


    public List<String> decode(String s ){
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        int index = 0;
        while(index <s.length()){
            //find the "/" position
            //s = "1/2a/ab3/abc"
            //from index to find "/" index -> sep = 1
            int sep = s.indexOf("/",index);
            //1 = len
            int len = Integer.valueOf(s.substring(index,sep));
            String curr = s.substring(sep + 1, sep +1 +len);
            res.add(curr);
            //resign index ,keep loop the string
            index = sep +1 + len;
        }
        return res;
    }
}
