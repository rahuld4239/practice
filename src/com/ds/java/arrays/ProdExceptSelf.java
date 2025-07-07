package com.ds.java.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ProdExceptSelf {

    public int[] Solution(int[] arr) {

        int n = arr.length;
        int[] rtol = new int[n];
        int[] ltor = new int[n];
        int[] prod = new int[n];

        rtol[0] = 1;

        for(int i=1; i<n; i++) {
                rtol[i] = arr[i-1]*rtol[i-1];
        }

        ltor[n-1] = 1;

        for(int i=n-2;i>=0;i--) {
            ltor[i] = arr[i+1]*ltor[i+1];
        }

        for(int i=0; i<n; i++) {
            prod[i] = rtol[i]*ltor[i];
        }
        return prod;

    }

    public static void main(String[] args) {

        int[] arr = new int[] {7,1,5,3};
        Arrays.stream(new ProdExceptSelf().Solution(arr)).mapToObj(s -> s+" ").toList().forEach(System.out::print);
    }
}
