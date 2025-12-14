package hashmap_exercises;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2260 - Minimum Consecutive Cards to Pick Up
 *
 * You are given an integer array cards where cards[i] represents the value of the i-th card.
 * You need to pick up a sequence of cards (a contiguous subarray) that contains at least
 * two cards with the same value.
 *
 * Return the minimum length of such a subarray, or -1 if it is impossible.
 *
 * Example:
 * cards = [3, 4, 2, 3, 4, 7] -> answer = 4
 * (e.g., subarray [3, 4, 2, 3] from index 0 to 3)
 */
public class MinimumConsecutiveCards {

    /**
     * @param cards array of card values
     * @return minimum length of a contiguous subarray containing two equal cards,
     *         or -1 if no such subarray exists
     */
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastIndexSeen = new HashMap<>();
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int cardValue = cards[i];

            Integer prevIndex = lastIndexSeen.get(cardValue);
            if (prevIndex != null) {
                int len = i - prevIndex + 1;
                answer = Math.min(answer, len);
            }

            lastIndexSeen.put(cardValue, i);
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
}
