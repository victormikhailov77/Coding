package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Calc {
    public double[] calcAvgSubarrays(int[] arr, int k) {
        if (arr == null || arr.length <k) return new double[]{};
        List<Double> result = new ArrayList<>();
        for (int start = 0, end = start + k; end <= arr.length; start++, end++) {
            double avg = getAvg(arr, start, end);
            result.add(avg);
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private double getAvg(int[] arr, int start, int end) {
        return IntStream.range(start, end).map(i -> arr[i]).average().getAsDouble();
    }
}