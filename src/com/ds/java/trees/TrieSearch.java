package com.ds.java.trees;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;


public class TrieSearch {
    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        String filePath = "/home/amod/dsa/datafile.txt";

        try {
            List<String> data = Files.readAllLines(Paths.get(filePath));
            for(String line : data){
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        trie.insert(word);
                    }
                }
            }
            System.out.println("Word Count for - lorem is " + trie.search("lorem"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static class TrieTreeNode {
        Map<Character, TrieTreeNode> childs = new HashMap<>();
        int count = 0;
    }

    static class TrieTree {
        private TrieTreeNode root = new TrieTreeNode();

        public void insert(String word) {
            TrieTreeNode temp = root;
            for (char ch : word.toCharArray()) {
                temp = temp.childs.computeIfAbsent(ch, c -> new TrieTreeNode());
            }
            temp.count++;
        }

        public int search(String word) {
            TrieTreeNode temp = root;
            for (char ch : word.toCharArray()) {
                temp = temp.childs.get(ch);
                if (temp == null) return 0;
            }
            return temp.count;
        }
    }

}
