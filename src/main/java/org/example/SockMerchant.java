package org.example;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> pairs = new HashMap<>();
        int result = 0;
        for (int i=0; i < ar.length; i++) {
            int color = ar[i];
            if (pairs.containsKey(color)) {
                int num = pairs.get(color);
                num++;
                if (num % 2 == 0) {
                    result++;
                }
                pairs.put(color, num);
            } else {
                pairs.put(color, 1);
            }
        }
        return result;
    }
}
