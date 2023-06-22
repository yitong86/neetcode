package com.sophia.blind75;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {


    //Encodes a list of strings to a single string
    public String encode(List<String> strs){
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length() + "/" +str);
        }
        return sb.toString();
    }


    public List<String> decode(String s ){
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index <s.length()){
            int sep = s.indexOf("/",index);
            int len = Integer.valueOf(s.substring(index,sep));
            String curr = s.substring(sep + 1, sep +1 +len);
            res.add(curr);
            index = sep +1 + len;
        }
        return res;
    }
}
