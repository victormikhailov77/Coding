package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MaxSiblingNumber {

    public int findMaxSibling(int N) {
        if (N >= 100000000) {
            return -1;
        }
        if (N == 0) {
            return 0;
        }

        // put decimal digits into the heap, where top value is max digit
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int current = N;
        while (current != 0) {
            int reminder = current % 10;
            heap.add(reminder);
            current /= 10;
        }

        // assemble a new number from digits, sorted in reverse order
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            sb.append(heap.poll().toString());
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String args[]) throws IOException {
        // read input parameters
        List<Integer> ints = Files.lines(Paths.get("test-input.txt"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // process results
        MaxSiblingNumber s = new MaxSiblingNumber();
        for (int number : ints) {
            int result = s.findMaxSibling(number);
            System.out.println("Source: " + number + " Max sibling: " + result);
        }
    }

}
