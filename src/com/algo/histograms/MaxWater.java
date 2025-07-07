package com.algo.histograms;

import java.util.Stack;

public class MaxWater {


    public int Solution(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int res = 0;

        for(int i=0; i<arr.length; i++) {

            while(!s.isEmpty() && arr[s.peek()] < arr[i]) {

                int tp = arr[s.pop()];

                if(s.isEmpty())
                    break;

                int dist = i - s.peek() - 1;

                int water = Math.min(arr[i],arr[s.peek()]);

                water-=tp;

                res+=water*dist;

            }

            s.push(i);
        }
        return res;

    }
}
