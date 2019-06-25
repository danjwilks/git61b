package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {

        double[] percentOpen;

        /** perform T independent experiments on an N-by-N grid */
        public PercolationStats(int N, int T, PercolationFactory pf){
                if (N < 0|| T < 0){
                        throw new IllegalArgumentException("N and T should not be less than 0");
                }
                percentOpen = new double[T];
                Percolation test = pf.make(N);
                for (int i = 0; i<T; i++){
                        while (!test.percolates()){
                                int row = StdRandom.uniform(N);
                                int col = StdRandom.uniform(N);
                                test.open(row, col);
                        }
                        percentOpen[i] = (double) test.numberOfOpenSites()/(N*N);
                }
        }

        /** sample mean of percolation threshold */
        public double mean() {
                return StdStats.mean(percentOpen);
        }

        /** sample standard deviation of percolation threshold */
        public double stddev() {
                return StdStats.stddev(percentOpen);
        }

//        public double confidenceLow() {
//                return StdStats.
//        }


        /*
        public double confidenceLow()                                  // low endpoint of 95% confidence interval
        public double confidenceHigh()                                 // high endpoint of 95% confidence interval
        */
}
