import java.util.*;

// Trie class
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert word into Trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // Find all words with given prefix
    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;

        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!current.children.containsKey(c)) {
                return results; // No matching prefix
            }
            current = current.children.get(c);
        }
        findAllWords(current, new StringBuilder(prefix), results);
        return results;
    }

    private void findAllWords(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix.toString());
        }

        for (char c : node.children.keySet()) {
            prefix.append(c);
            findAllWords(node.children.get(c), prefix, results);
            prefix.deleteCharAt(prefix.length() - 1); // backtrack
        }
    }

    // Fuzzy matching (Levenshtein Distance)
    public List<String> fuzzyAutocomplete(String prefix, List<String> allCountries) {
        List<String> fuzzyMatches = new ArrayList<>();
        for (String country : allCountries) {
            if (levenshteinDistance(prefix.toLowerCase(), country.toLowerCase()) <= 2) {
                fuzzyMatches.add(country);  // Adding country if distance <= 2 (tolerating 2 mistakes)
            }
        }
        return fuzzyMatches;
    }

    // Calculate Levenshtein distance
    public int levenshteinDistance(String str1, String str2) {
        int lenStr1 = str1.length();
        int lenStr2 = str2.length();
        int[][] dp = new int[lenStr1 + 1][lenStr2 + 1];

        for (int i = 0; i <= lenStr1; i++) {
            for (int j = 0; j <= lenStr2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + cost);
                }
            }
        }
        return dp[lenStr1][lenStr2];
    }
}