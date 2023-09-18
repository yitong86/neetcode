package com.sophia.blind75.tries;

public class AddSearchWord {
    /** Initialize your data structure here. */
    // 内部类不能是public
    private class TrieNode{
        public TrieNode[] children;
        public boolean isWord;
        public String word;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    private TrieNode root;

    public AddSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            // 孩子是否被初始化
            if(node.children[index] == null){
                // 初始化孩子
                node.children[index] = new TrieNode();
            }
            // 移动到孩子节点，继续下一层操作
            node = node.children[index];
        }

        node.isWord = true;
        node.word = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index){
        if(node == null) return false;
        // 或者写node.word.equals(word)
        if(index == word.length()) return node.isWord;
        // 这种情况是.
        // 只要下边有不是null的节点就可以继续下一层的操作了
        if(word.charAt(index) == '.') {
            for(TrieNode temp : node.children){
                if(find(word, temp, index + 1)) {
                    return true;
                }
            }
            // 这种情况是字母
        } else {
            int tempIndex = word.charAt(index) - 'a';
            TrieNode temp = node.children[tempIndex];

            return find(word, temp, index + 1);
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
