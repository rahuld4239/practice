package com.ds.java.arrays;

public class MinRotated {

    public int Solution(int[] arr) {

        int mid, lo=0, hi=arr.length-1;

        while(lo<hi) {

            if(arr[lo] < arr[hi])
                return  arr[lo];

            mid = (lo+hi)/2;

            if(arr[mid] > arr[hi]) // right side not sorted
                lo = mid+1;
            else hi = mid;
        }
        return arr[lo];
    }
}
