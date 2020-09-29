package org.example;

public class SquaresArray {

    public int[] calculateSquares(int arr[]) {
        int n = arr.length;
        int squares[] = new int[n];
        int left = 0;
        int right = n-1;
        int highestSqrt = n - 1;
        while (left <= right) {
            int sqLeft = sqrt(arr[left]);
            int sqRight = sqrt(arr[right]);
            if (sqLeft < sqRight) {
                squares[highestSqrt--] = sqRight;
                right--;
            } else {
                squares[highestSqrt--] = sqLeft;
                left++;
            }
        }

        return squares;
    }

    private int sqrt(int a) { return a*a; }
}
