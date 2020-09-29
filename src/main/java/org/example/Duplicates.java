package org.example;

public class Duplicates {

    public int removeDuplicates(int arr[]) {
        if (arr == null || arr.length == 0) return 0;

        int nextNonDup = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDup - 1] != arr[i]) {
                arr[nextNonDup] = arr[i];
                nextNonDup++;
            }
        }
        return nextNonDup;
    }

    public int countUniques(int arr[]) {
        if (arr == null || arr.length == 0) return 0;

        int nextNonDup = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDup - 1] != arr[i]) {
                nextNonDup++;
            }
        }
        return nextNonDup;
    }
}
