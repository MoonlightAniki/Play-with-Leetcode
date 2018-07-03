package solution676;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary1 {

    private Map<Integer, List<String>> records = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary1() {
        records.clear();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            if (!records.containsKey(word.length())) {
                records.put(word.length(), new ArrayList<>());
            }
            records.get(word.length()).add(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        if (!records.containsKey(word.length())) {
            return false;
        }
        List<String> words = records.get(word.length());
        for (String w : words) {
            if (match(word, w)) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff == 2) {
                    return false;
                }
            }
        }
        return diff == 1;
    }

}
