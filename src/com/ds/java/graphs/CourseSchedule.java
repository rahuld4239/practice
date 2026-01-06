package com.ds.java.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public boolean Solution(int numCourses, int[][] map) {

        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : map) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for(int i = 0; i<numCourses; i++) {
            List<Integer> visiting = new ArrayList<>();
            List<Integer> visited = new ArrayList<>();
            if(!dfs(i, preMap, visiting, visited))
                return false;
        }

        return true;
    }

    private  boolean dfs(int course, Map<Integer, List<Integer>> preMap, List<Integer> visiting,
                         List<Integer> visited) {
        if(visiting.contains(course)) return false;
        if(visited.contains(course)) return true;

        visiting.add(course);
        for(int i:preMap.get(course)) {
            if(!dfs(i,preMap,visiting,visited))
                return false;
        }
        visiting.remove(course);
        visited.add(course);
        return true;


    }
}
