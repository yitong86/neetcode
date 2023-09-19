package com.sophia.blind75.tries;

import java.util.ArrayList;
import java.util.List;

//public class WordSearch {
//}
class TrieNode {
    char val;
    TrieNode[] children;
    String word;

    public TrieNode(char val) {
        this.val = val;
        children = new TrieNode[26];
        word = null;
        //if a word is completed at this level of TrieNode, we save it at this TrieNode
        //otherwise this TrieNode.word is null
    }
}

class WordSearch {

    TrieNode root = new TrieNode(' ');

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0) return ans;

        buildTrie(root, words);   //store all the words in a TrieNode Tree built based on root

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                //if the character we are at appears in root.children
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, ans);
                }
            }
        }
        return ans;
    }

    public void buildTrie (TrieNode root, String[] words) {
        if (words.length == 0) return;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
    }

    public void dfs(char[][] board, int i, int j, TrieNode curr, List<String> ans) {
        if (curr.word != null) {
            ans.add(curr.word);
            curr.word = null;   //to avoid duplicate search
            //return;
            //made a mistake here!! - we can't return here when found word 'car', need to go down a level keep searching for 'card'
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*' || curr.children[board[i][j] - 'a'] == null) {
            return;
        }

        char c = board[i][j];
        board[i][j] = '*';
        curr = curr.children[c - 'a'];  //go to next level to search

        dfs(board, i + 1, j, curr, ans);
        dfs(board, i - 1, j, curr, ans);
        dfs(board, i, j + 1, curr, ans);
        dfs(board, i, j - 1, curr, ans);

        board[i][j] = c;
    }
}