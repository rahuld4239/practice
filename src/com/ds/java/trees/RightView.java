package com.ds.java.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RightView {

    List<Node> result = new ArrayList<>();

    public List<Integer> view(Node root) {

          viewHelper(root, 0, -1);
          return result.stream().map(x -> x.val).collect(Collectors.toList());
    }

    private void viewHelper(Node node, int level, int maxLevel) {

        if(node == null) return;

        if(level > maxLevel) {
            result.add(node);
            maxLevel = level;
        }

        viewHelper(node.right, level+1, maxLevel);
        viewHelper(node.left, level+1, maxLevel);

    }
}
