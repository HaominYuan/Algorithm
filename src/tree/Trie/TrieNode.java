package tree.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> map;
    public TrieNode() {
        map = new HashMap<>();
    }
}


