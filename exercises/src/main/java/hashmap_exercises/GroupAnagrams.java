package hashmap_exercises;

import java.util.*;

/**
 * LeetCode 49 - Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * Example:
 * Input:  ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]] (order may vary)
 */
public class GroupAnagrams {

    /**
     * Groups the given words into lists of anagrams.
     *
     * @param strs array of input strings
     * @return a list of groups, where each group is a list of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            if (word == null) {
                continue; // or throw IllegalArgumentException, depending on requirements
            }

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String canonicalForm = new String(chars);

            map.computeIfAbsent(canonicalForm, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

}

