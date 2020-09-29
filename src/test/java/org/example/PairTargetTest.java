package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairTargetTest {

    @Test
    public void pairWithTargetSum() {
        // given
        int arr[] = {10, 50, 90, 30};

        // when
        var result = new PairTarget().pairWithTargetSum(arr, 60);

        // then
        assertEquals(new Tuple(1, 3), result);
    }

    @Test
    public void pairWithTargetSumZero() {
        // given
        int arr[] = {};

        // when
        var result = new PairTarget().pairWithTargetSum(arr, 6);

        // then
        assertEquals(new Tuple(0, 0), result);
    }

}