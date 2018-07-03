package solution676;

import java.util.HashSet;
import java.util.Set;

class MagicDictionary2 {

    private Set<String> records = new HashSet<>();

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary2() {
        records.clear();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0; i < word.length(); ++i) {
                for (int j = 0; j < 26; ++j) {
                    char c = (char) ('a' + j);
                    if (c != word.charAt(i)) {
                        records.add(word.substring(0, i) + c + word.substring(i + 1));
                    }
                }
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return records.contains(word);
    }

    public static void main(String[] args) {
        MagicDictionary2 dict = new MagicDictionary2();
        String[] words = {"hello", "leetcode"};
        dict.buildDict(words);
        System.out.println(dict.search("hello"));
        System.out.println(dict.search("hell"));
        System.out.println(dict.search("eello"));
    }
}
