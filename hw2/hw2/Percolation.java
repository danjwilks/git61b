package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    int[][] grid;

    /**create N-by-N grid, with all sites initially blocked */
    public Percolation(int N) {

        grid = new int[N][N];

        /** could I leave as null? */
        for ( int y = 0; y<grid.length; y++){
            for ( int x = 0; x<grid.length;x++){
                grid[y][x] = -1;
            }
        }

    }

    /** opens the site (row, col) if it is not open already */
    public void open(int row, int col){
        if (!isOpen(row,col)){
            grid[row][col] = 1;
        }

        //TODO  record who is connected to who
        //      create helper function of above
        //      including instance variables
    }

    /** returns true if the site (row, col) is open */
    public boolean isOpen(int row, int col){
        if (grid[row][col] == -1){
            return false;
        }
        return true;
    }

    /**  returns true if the site (row, col) is full */
    public boolean isFull(int row, int col){
        return !isOpen(row, col);
    }



        /*

        public int numberOfOpenSites()           // number of open sites
        public boolean percolates()              // does the system percolate?
        public static void main(String[] args)   // use for unit testing (not required, but keep this here for the autograder)

         */



}
