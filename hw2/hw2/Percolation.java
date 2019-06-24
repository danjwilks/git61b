package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    boolean[][] grid;

    /**create N-by-N grid, with all sites initially blocked */
    public Percolation(int N) {

        grid = new boolean[N][N];

        for ( int y = 0; y<grid.length; y++){
            for ( int x = 0; x<grid.length;x++){
                grid[y][x] = false;
            }
        }

    }


        /*

   public Percolation(int N)                // create N-by-N grid, with all sites initially blocked
   public void open(int row, int col)       // open the site (row, col) if it is not open already
   public boolean isOpen(int row, int col)  // is the site (row, col) open?
   public boolean isFull(int row, int col)  // is the site (row, col) full?
   public int numberOfOpenSites()           // number of open sites
   public boolean percolates()              // does the system percolate?
   public static void main(String[] args)   // use for unit testing (not required, but keep this here for the autograder)
         */



}
