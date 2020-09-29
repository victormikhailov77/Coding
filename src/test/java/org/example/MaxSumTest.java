package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumTest {

    private MaxSum objInTest = new MaxSum();

    @Test
    public void shouldReturnMaxSumSubarray() {
        // given
        var arr = new int[] {2, 1, 5, 4, 6, 1, 0, 7};

        // when
        var result = objInTest.maxSumSubarray(arr, 3);

        // then
        assertEquals(15, result);
    }

    @Test
    public void shouldReturnMinSizeSubarray() {
        // given
        var arr = new int[] {2, 1, 5, 4, 6, 1, 0, 7};

        // when
        var result = objInTest.minSizeSubarray(arr, 15);

        // then
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnLongestSubstringWithUniqueChars() {
        assertEquals(3, objInTest.longestSubstringWithUnique("araaci", 2));
    }
}