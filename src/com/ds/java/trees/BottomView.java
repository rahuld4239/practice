package com.ds.java.trees;

import java.util.*;

public class BottomView {

    class Pair {
        int hd;
        Node node;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> View(Node root) {

        List<Integer> result = new ArrayList<>();

        Map<Integer, Node> hdMap = new HashMap<>();

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()) {

            hdMap.put(queue.peek().hd, queue.peek().node);
            Pair p = queue.poll();

            if(p!= null &&  p.node.left != null) {
                queue.add(new Pair(p.node.left, p.hd-1));
            }
            if(p!= null &&  p.node.right != null) {
                queue.add(new Pair(p.node.right, p.hd+1));
            }
        }

        for(Node n: hdMap.values()) {
            result.add(n.val);
        }

        return result;
    }
}
