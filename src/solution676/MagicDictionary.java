package solution676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 676. Implement Magic Dictionary
// https://leetcode.com/problems/implement-magic-dictionary/description/
class MagicDictionary {

    private class Trie {
        private class Node {
            private Map<Character, Integer> next;
            boolean end;

            public Node(boolean end) {
                this.end = end;
                this.next = new HashMap<>();
            }

            public Node() {
                this(false);
            }
        }

        private List<Node> trie = new ArrayList<>();

        public Trie() {
            trie.clear();
            trie.add(new Node());
        }

        public void insert(String word) {
            insert(0, word, 0);
        }

        private void insert(int treeID, String word, int index) {
            if (index == word.length()) {
                trie.get(treeID).end = true;
                return;
            }
            if (!trie.get(treeID).next.containsKey(word.charAt(index))) {
                trie.get(treeID).next.put(word.charAt(index), trie.size());
                trie.add(new Node());
            }
            insert(trie.get(treeID).next.get(word.charAt(index)), word, index + 1);
        }

        public boolean search(String word) {
            return search(0, word, 0, 1);
        }

        private boolean search(int treeID, String word, int index, int left) {
            if (index == word.length()) {
                return trie.get(treeID).end && left == 0;
            }
            for (Map.Entry<Character, Integer> entry : trie.get(treeID).next.entrySet()) {
                if (entry.getKey() == word.charAt(index)) {
                    if (search(entry.getValue(), word, index + 1, left)) {
                        return true;
                    }
                } else if (left > 0) {
                    if (search(entry.getValue(), word, index + 1, left - 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trie = new Trie();
    }

    /**
     * Build a dictionary through a trie of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            trie.insert(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return trie.search(word);
    }

    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        String[] words = {"hello", "leetcode"};
        md.buildDict(words);
        System.out.println(md.search("hello"));//false
        System.out.println(md.search("hell"));//false
        System.out.println(md.search("hella"));//true
        System.out.println(md.search("leetcoded"));//false
        System.out.println(md.search("eeetcode"));//true
        System.out.println(md.search("leetcede"));//true
    }
}

/**
 * Your solution676.MagicDictionary object will be instantiated and called as such:
 * solution676.MagicDictionary obj = new solution676.MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
