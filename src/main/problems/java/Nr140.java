package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nr140 {

    public static void main(String[] args) {
        Nr140 nr140 = new Nr140();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(Arrays.toString(nr140.wordBreak("catsanddog", wordDict).toArray()));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.addWord(word);
        }
        return trie.wordBreak(s);
    }

    private class Trie {

        private final TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                currentNode = currentNode.addChild(c);
            }
            currentNode.getChildren()[26] = root;
        }

        public List<String> wordBreak(String s) {
            return wordBreak(s, 0, root, new StringBuilder(), 0, new ArrayList<>());
        }

        private List<String> wordBreak(
                String s,
                int index,
                TrieNode currentNode,
                StringBuilder currentString,
                int currentStringLength,
                List<String> sentences
        ) {
            if (index == s.length()) {
                if (currentNode.getChildren()[26] != null) {
                    sentences.add(currentString.toString());
                }
                return sentences;
            }
            char c = s.charAt(index);
            if (currentNode.getChildren()[c - 'a'] != null) {
                currentString.append(c);
                wordBreak(
                        s,
                        index + 1,
                        currentNode.getChildren()[c - 'a'],
                        currentString,
                        currentStringLength + 1,
                        sentences
                );
                currentString.setLength(currentStringLength);
            }
            if (currentNode.getChildren()[26] != null) {
                currentString.append(" ");
                wordBreak(
                        s,
                        index,
                        root,
                        currentString,
                        currentStringLength + 1,
                        sentences
                );
                currentString.setLength(currentStringLength);
            }
            return sentences;
        }

        private class TrieNode {
            private final TrieNode[] children = new TrieNode[27];

            public TrieNode addChild(char c) {
                if (children[c - 'a'] == null) {
                    children[c - 'a'] = new TrieNode();
                }
                return children[c - 'a'];
            }

            public TrieNode[] getChildren() {
                return children;
            }
        }
    }
}
