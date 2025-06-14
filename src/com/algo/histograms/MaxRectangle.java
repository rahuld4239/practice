package com.algo.histograms;

import java.util.Stack;

public class MaxRectangle {

    public int solution(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int res = 0;
        int n = arr.length, curr;
        for(int i=0; i<arr.length; i++) {

            while(!s.isEmpty() && arr[s.peek()] > arr[i]) {

                int top = s.pop();

                int width = (s.isEmpty()? i : i - s.peek() - 1);

                res = Math.max(res, arr[top]*width);
            }
            s.push(i);

        }

        while(s.isEmpty()) {
            int t = s.pop();
            curr = (s.isEmpty()? n : n - s.peek() - 1) * arr[t];
            res = Math.max(res, curr);
        }

        return res;
    }
}
