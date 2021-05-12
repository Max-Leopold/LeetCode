package main.problems.java;

public class Nr211 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    static class Trie {

        private final TrieNode start = new TrieNode();

        public void addWord(String word) {
            char[] wordArray = word.toCharArray();
            TrieNode last = start;
            for (int i = 0; i < wordArray.length; i++) {
                if (last.hasChildren(wordArray[i])) {
                    last = last.getChildren()[wordArray[i] - 'a'];
                } else {
                    last = last.addChildren(wordArray[i]);
                }
            }
            last.isEnd = true;
        }

        public boolean hasWord(String word) {
            char[] wordArray = (word).toCharArray();
            return searchRecursively(wordArray, 0, start);
        }

        private boolean searchRecursively(char[] word, int currentPosition, TrieNode currentNode) {
            if (currentNode == null) {
                return false;
            }
            if (currentPosition == word.length) {
                return currentNode.isEnd;
            }
            char c = word[currentPosition];
            if (c == '.') {
                for (TrieNode children : currentNode.getChildren()) {
                    if (children != null) {
                        if (searchRecursively(word, currentPosition + 1, children)) {
                            return true;
                        }
                    }
                }
            } else {
                return searchRecursively(
                        word,
                        currentPosition + 1,
                        currentNode.getChildren()[c - 'a']
                );
            }
            return false;
        }

        private class TrieNode {
            private final TrieNode[] children;
            boolean isEnd;

            public TrieNode() {
                this.children = new TrieNode[26];
            }

            public boolean hasChildren(Character c) {
                if (c == '.') {
                    return true;
                } else if (children[c - 'a'] != null) {
                    return true;
                } else {
                    return false;
                }
            }

            public TrieNode[] getChildren() {
                return children;
            }

            public TrieNode addChildren(Character c) {
                children[c - 'a'] = new TrieNode();
                return getChildren()[c - 'a'];
            }
        }
    }

    static class WordDictionary {

        private final Trie trie;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            trie = new Trie();
        }

        public void addWord(String word) {
            trie.addWord(word);
        }

        public boolean search(String word) {
            return trie.hasWord(word);
        }
    }
}
