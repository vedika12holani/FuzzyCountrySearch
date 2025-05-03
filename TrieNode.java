import java.util.*;

// TrieNode class
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
    }
}