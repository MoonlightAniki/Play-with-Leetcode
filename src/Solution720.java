import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 720. Longest Word in Dictionary
// https://leetcode.com/problems/longest-word-in-dictionary/description/
class Solution720 {
    private class Trie {
        private class Node {
            private boolean isWord;
            private Node[] next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                this.next = new Node[26];
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void add(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null)
                    cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean contains(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean isPrefix(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); ++i) {
                char c = prefix.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return true;
        }

        public boolean canBeBuiltFromOtherWords(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!cur.next[c - 'a'].isWord) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
            return true;
        }
    }

    public String longestWord2(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (trie.canBeBuiltFromOtherWords(word)) {
                list.add(word);
            }
        }
        if (list.isEmpty()) {
            return "";
        }
        Collections.sort(list, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        return list.get(0);
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution720 s = new Solution720();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        System.out.println(s.longestWord(words));
    }
}
