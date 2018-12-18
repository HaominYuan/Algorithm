package leetcode;


import java.util.HashMap;
import java.util.Map;


class ImplementTrie_PrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    static class Trie {


        class TrieNode {
            Map<Character, TrieNode> map;
            boolean isWord;

            TrieNode() {
                map = new HashMap<>();
            }
        }

        private TrieNode root;


        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode newNode;
                if ((newNode = temp.map.get(word.charAt(i))) == null) {
                    newNode = new TrieNode();
                    temp.map.put(word.charAt(i), newNode);
                }
                temp = newNode;
                if (i == word.length() - 1) {
                    temp.isWord = true;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode next;
                if ((next = temp.map.get(word.charAt(i))) == null) {
                    return false;
                }
                temp = next;
            }
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode next;
                if ((next = temp.map.get(prefix.charAt(i))) == null) {
                    return false;
                }
                temp = next;
            }
            return temp.isWord;
        }
    }

}