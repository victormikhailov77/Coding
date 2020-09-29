package org.example;


import java.util.HashMap;

class Tuple {
    int x = 0;
    int y = 0;
    Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PairTarget {

    public Tuple pairWithTargetSum(int arr[], int sum) {
        if (arr == null || arr.length == 0) return new Tuple(0, 0);

        HashMap<Integer, Integer> complementToSum = new HashMap<>();
        for (var i = 0; i < arr.length; i++) {
            if (complementToSum.containsKey(sum - arr[i])) {
                return new Tuple(complementToSum.get(sum - arr[i]), i);
            }
            else {
                complementToSum.put(arr[i], i);
            }
        }
        return new Tuple(0, 0);
    }
}
