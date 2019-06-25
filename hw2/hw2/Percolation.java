package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int sideLength;

    private WeightedQuickUnionUF squares;

    private int openSites;

    /**create N-by-N grid, with all sites initially blocked */
    public Percolation(int N) {

        grid = new boolean[N][N];
        sideLength = N;

        squares = new WeightedQuickUnionUF(N*N);

        openSites = 0;

        for ( int y = 0; y<grid.length; y++){
            for ( int x = 0; x<grid.length;x++){
                grid[y][x] = false;
            }
        }

    }

    public int xyTo1D(int row, int col){
        return row * sideLength + col;
    }

    public boolean isSquare(int row, int col){
        if (row < 0 || row >= sideLength ){
            return false;
        }
        if (col < 0 || col >= sideLength){
            return false;
        }
        return true;
    }

    /** open the site (row, col) if it is not open already */
    public void open(int row, int col) {

        if(!isSquare(row, col)){
            throw new IllegalArgumentException("this is not a valid input");
        }

        if (!isOpen(row, col)) {
            grid[row][col] = true;

            openSites = openSites + 1;

            // above
            if (isSquare(row - 1, col)) {
                if (isOpen(row - 1, col)) {
                    squares.union(xyTo1D(row - 1, col), xyTo1D(row, col));
                }
            }
            // below
            if (isSquare(row + 1, col)) {
                if (isOpen(row + 1, col)) {
                    squares.union(xyTo1D(row + 1, col), xyTo1D(row, col));
                }
            }
            // right
            if (isSquare(row, col + 1)) {
                if (isOpen(row, col + 1)) {
                    squares.union(xyTo1D(row, col + 1), xyTo1D(row, col));
                }
            }
            // left
            if (isSquare(row, col - 1)) {
                if (isOpen(row, col - 1)) {
                    squares.union(xyTo1D(row, col - 1), xyTo1D(row, col));
                }
            }
        }
    }

    /** returns true if single space row,col is open */
    public boolean isOpen(int row, int col){
        return grid[row][col];
    }

    /** returns true if single space, row, col is full */
    public boolean isFull(int row, int col){

        for (int i = 0; i<sideLength; i++){
            if (squares.connected(i,xyTo1D(row,col))){
                return true;
            }
        }
        return false;

    }

    /** returns number of open sites */
    public int numberOfOpenSites(){
        return openSites;
    }

    /** returns true if system percolates */
    public boolean percolates() {
        for (int i = 0; i<sideLength;i++){
            if(isFull(sideLength-1,i)){
                return true;
            }
        }
        return false;
    }

}
