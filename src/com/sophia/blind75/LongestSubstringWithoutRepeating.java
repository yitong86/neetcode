package com.sophia.blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> visitedCharacters = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if (visitedCharacters.containsKey(currentCharacter) && visitedCharacters.get(currentCharacter) >= left) {

            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacters.put(currentCharacter, right);
        }
        return maxLength;
    }
}