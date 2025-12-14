package hashmap_exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 2342 - Max Sum of a Pair With Equal Sum of Digits
 *
 * You are given a 0-indexed integer array nums.
 * Find the maximum sum of a pair of numbers (nums[i] + nums[j]) such that
 * the sum of digits of nums[i] is equal to the sum of digits of nums[j],
 * and i != j.
 *
 * If no such pair exists, return -1.
 */
public class MaxSumPairEqualDigitSum {

    /**
     * @param nums input array
     * @return maximum sum of a pair of numbers sharing the same digit sum,
     *         or -1 if no such pair exists
     */
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> digitSumToHighest = new HashMap<>();
        int answer = -1;

        for (int num : nums) {
            int digitSum = digitSum(num);

            Integer bestSoFar = digitSumToHighest.get(digitSum);
            if (bestSoFar != null) {
                answer = Math.max(answer, num + bestSoFar);
                digitSumToHighest.put(digitSum, Math.max(bestSoFar, num));
            } else {
                digitSumToHighest.put(digitSum, num);
            }
        }

        return answer;
    }

    /**
     * Optional helper method:
     * Computes the sum of digits of a non-negative integer.
     */
    int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

