package com.test.Test1.src.test;
//Pacific Atlantic water flow
import java.util.LinkedList;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    int m,n;
    int[] dirX = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dirY = new int[] {-1, 0, 1, 1, -1, -1, 0, 1};

    int [][] board;

    public PacificAtlanticWaterFlow(int m, int n) {

        this.m = m;
        this.n = n;
    }

    class Cell{
        public int x,y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfs(int[][] visit, Queue<Cell> queue) {

        //Queue<Cell> queue = new LinkedList<>();

        while(!queue.isEmpty()) {

            Cell c = queue.poll();
            visit[c.x][c.y] = 1;
            for(int i=0; i<8; i++) {
                for(int j=0; j<8; j++) {
                    if(c.x+i > 0 && c.x+i <m && c.y+j < 0 && c.y+j < n
                        && board[c.x][c.y] < board[c.x+i][c.y+j])
                        queue.add(new Cell(c.x+i, c.y+j));

                }
            }
        }

    }
}
