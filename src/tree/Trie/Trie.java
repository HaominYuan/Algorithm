package tree.Trie;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {
            if (!temp.map.containsKey(chars[i])) {
                temp.map.put(chars[i], new TrieNode());
            }
            temp = temp.map.get(chars[i]);
            if (i == chars.length - 1) {
                temp.isWord = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            TrieNode next = temp.map.get(word.charAt(i));
            if (null == next) {
                return false;
            }
            temp = next;
        }
        return temp.isWord;
    }


    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = temp.map.get(prefix.charAt(i));
            if (next == null) {
                return false;
            }
            temp = next;
        }
        return true;
    }


}
