package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    private Calc objInTest = new Calc();

    @Test
    public void shouldNotCalcEmpty() {
        // given
        int[] arr = null;

        // when
        var res = objInTest.calcAvgSubarrays(arr, 4);

        // then
        assertEquals(0, res.length);
    }

    @Test
    public void shouldNotCalcLessSize() {
        // given
        var arr = new int[]{1, 3, 2};

        // when
        var res = objInTest.calcAvgSubarrays(arr, 4);

        // then
        assertEquals(0, res.length);
    }

    @Test
    public void shouldCalcExactSubarray() {
        // given
        var arr = new int[]{1, 3, 2, 6};

        // when
        var res = objInTest.calcAvgSubarrays(arr, 4);

        // then
        assertEquals(3.0, res[0], 0.001);
    }

    @Test
    public void shouldCalcSubarrayWithExtraElement() {
        // given
        var arr = new int[]{1, 3, 2, 6, 7};

        // when
        var res = objInTest.calcAvgSubarrays(arr, 4);

        // then
        assertEquals(3.0, res[0], 0.001);
        assertEquals(4.5, res[1], 0.001);
    }

}