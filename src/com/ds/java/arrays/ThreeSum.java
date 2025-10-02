package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> Solution(int[] arr) {

        List<List<Integer>> sol = new ArrayList<>();
        int len = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<len;i++) {

            int j = i+1;
            int k = len-1;

            int sum = arr[i] + arr[j] + arr[k];
            while(j<k) {
                if (sum > 0)
                    k--;
                else if (sum < 0) {
                    j++;
                } else {
                    sol.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    if (arr[j] == arr[j - 1] && j < k)
                        j++;
                }
            }
        }

        return sol;
    }
}
