package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicatesTest {

    @Test
    public void shouldRemoveDuplicates() {
        // given
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5};

        // when
        int result = new Duplicates().removeDuplicates(arr);

        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldRemoveDuplicatesSingle() {
        // given
        int arr[] = {1};

        // when
        int result = new Duplicates().removeDuplicates(arr);

        // then
        assertEquals(1, result);
    }


    @Test
    public void shouldCountUniqueArray() {
        // given
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5};

        // when
        int result = new Duplicates().removeDuplicates(arr);

        // then
        assertEquals(5, result);
    }

    @Test
    public void shouldCountUniqueSingle() {
        // given
        int arr[] = {10};

        // when
        int result = new Duplicates().removeDuplicates(arr);

        // then
        assertEquals(1, result);
    }

    @Test
    public void shouldCountUniqueAllTheSame() {
        // given
        int arr[] = {10, 10, 10};

        // when
        int result = new Duplicates().removeDuplicates(arr);

        // then
        assertEquals(1, result);
    }
}