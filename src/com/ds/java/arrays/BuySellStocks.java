package com.ds.java.arrays;

import com.test.linkedlists.Solution;

public class BuySellStocks {

    public int Solution(int[] arr) {

        int buy = arr[0];
        int profit = 0;

        for(int i=1;i<arr.length;i++) {

            if(arr[i] < buy) {
                buy = arr[i];
            }

            profit = Math.max(profit, arr[i] - buy);

        }

        return profit;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {7,1,5,3};
        System.out.println(new BuySellStocks().Solution(arr));
    }
}
