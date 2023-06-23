package com.sophia.blind75;

import java.util.Locale;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String res = "";
        //loop though character in a string
        for(Character c :s.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c)){
                res +=c;
            }
        }
        res = res.toLowerCase();
        //index two pointer
        int left = 0;
        int right = res.length()-1;
        while(left <= right){
            if(res.charAt(left) != res.charAt(right)){
                return false;
            }
            left +=1;
            right -=1;
        }

        return true;

    }
}
