package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquaresArrayTest {

    @Test
    public void calculateSquares() {
        // given
        int arr[] = {-2, -1, 0, 3, 4, 5};
        int desired[]={ 0, 1, 4, 9, 16, 25};

        // when
        int result[] = new SquaresArray().calculateSquares(arr);

        // then
        assertArrayEquals(desired, result);
    }


    @Test
    public void calculateSquaresAllNeg() {
        // given
        int arr[] = {-5, -4, -2};
        int desired[]={ 4, 16, 25};

        // when
        int result[] = new SquaresArray().calculateSquares(arr);

        // then
        assertArrayEquals(desired, result);
    }
}