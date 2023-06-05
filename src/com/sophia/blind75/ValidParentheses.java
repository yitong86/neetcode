package com.sophia.blind75;

import java.util.Stack;

public class ValidParentheses {
   // class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for(Character c : s.toCharArray()){
                if(c == '('){
                    stack.push(')');
                }else if(c =='{'){
                    stack.push('}');
                }else if( c == '['){
                    stack.push(']');
                }else if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
            return stack.isEmpty();
        }
   // }
}
//if(s.length() % 2 !=0) return false;
//stack<Character> stack = new Stack;
//for(Char c :a.toCharArray()){
//    if(c == "(" || c =="{" || c=="["){
//        stack.push(c);
//        }else if (c ==")" && !stack.isEmpty()&& stack.peek()=="("){
//        stack.pop();
//        }else if (c =="}" && !stack.isEmpty()&& stack.peek()=="{"){
//            stack.pop();
//        }else if (c =="]" && !stack.isEmpty()&& stack.peek()=="["){
//            stack.pop();
//        }
//        }
//return stack.isEmpty();
//        }
//        }