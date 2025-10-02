package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> Solution(int[] arr) {

        List<List<Integer>> sol = new ArrayList<>();
        int len = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<len-1;i++) {

            if(i>0 && arr[i] == arr[i-1])
                continue;

            int j = i+1;
            int k = len-1;


            while(j<k) {
                int sum = arr[i] + arr[j] + arr[k];
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

    public static void main(String[] args) {

        int[] arr = {-4,-1,-1,0,1,2};

        System.out.println(new ThreeSum().Solution(arr));
    }
}
