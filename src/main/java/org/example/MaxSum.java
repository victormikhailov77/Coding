package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaxSum {

    public int maxSumSubarray(int arr[], int k) {
        var maxSum = 0;
        var windowSum = 0;
        var windowStart = 0;
        for (var windowEnd =0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k-1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }


    public int minSizeSubarray(int arr[], int s) {
        var minLength = Integer.MAX_VALUE;
        var windowSum = 0;
        var windowStart = 0;
        for (var windowEnd =0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while (windowSum >= s) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }



    public int longestSubstringWithUnique(String str, int k) {
        var maxLength = 0;
        var windowStart = 0;
        var windowEnd =0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (; windowEnd < str.length(); windowEnd++) {
            var rightChar = str.charAt(windowEnd);
            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1); // if exist - increment by 1; otherwise put 1
            while (countMap.size() > k) {
                var leftChar = str.charAt(windowStart);
                countMap.put(leftChar, countMap.getOrDefault(leftChar, 0) - 1);
                if (countMap.get(leftChar) == 0) {
                    countMap.remove(leftChar);
                }
                windowStart++;
            }
        }
        return maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

}
