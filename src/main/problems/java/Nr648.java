package main.problems.java;

import java.util.List;

public class Nr648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(trie.getShortestRoot(word));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    class Trie {

        private final TrieNode start = new TrieNode();

        public void insert(String word) {
            TrieNode last = start;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (last.children[c - 'a'] != null) {
                    last = last.children[c - 'a'];
                } else {
                    TrieNode newTrienode = new TrieNode();
                    last.children[c - 'a'] = newTrienode;
                    last = newTrienode;
                }
            }
            last.isEnd = true;
        }

        public String getShortestRoot(String word) {
            TrieNode last = start;
            for (int i = 0; i < word.length(); i++) {
                if (last.isEnd) {
                    return word.substring(0, i);
                } else {
                    if (last.children[word.charAt(i) - 'a'] != null) {
                        last = last.children[word.charAt(i) - 'a'];
                    } else {
                        return word;
                    }
                }
            }
            return word;
        }

        private class TrieNode {
            public final TrieNode[] children = new TrieNode[26];
            public boolean isEnd;
        }
    }
}
