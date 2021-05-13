package main.problems.java;

public class Nr208 {

    class Trie {

        private final TrieNode start = new TrieNode();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
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

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode last = walkTrie(word);
            return last != null && last.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return walkTrie(prefix) != null;
        }

        private TrieNode walkTrie(String word) {
            TrieNode last = start;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (last.children[c - 'a'] == null) {
                    return null;
                }
                last = last.children[c - 'a'];
            }
            return last;
        }

        private class TrieNode {
            public final TrieNode[] children = new TrieNode[26];
            public boolean isEnd;
        }
    }
}
