package bearmaps.hw4;

import bearmaps.proj2ab.DoubleMapPQ;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {

    private DoubleMapPQ<Vertex> pq;
    private AStarGraph<Vertex> graph;
    private List<Vertex> solution;
    private Map<Vertex, Double> distTo;

    private SolverOutcome outcome;
    private double solutionWeight;
    private int numStatesExplored;
    private double time;



    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout){
        Stopwatch sw = new Stopwatch();
        graph = input;
        solution = new LinkedList<>();
        distTo = new HashMap<>();

        pq = new DoubleMapPQ<>();
        pq.add(start, 0.0);
        distTo.put(start, 0.0);

        outcome = SolverOutcome.TIMEOUT;
        solutionWeight = -1;

        while (true/**sw.elapsedTime() < timeout*/) {

            if(pq.size() == 0){
                outcome = SolverOutcome.UNSOLVABLE;
                solution = new LinkedList<>();
                break;
            }

            Vertex v = pq.removeSmallest();
            numStatesExplored ++;
            solution.add(v);
            if (v.equals( end) ){
                outcome = SolverOutcome.SOLVED;
                solutionWeight = distTo.get(v);
                break;
            }

            for (WeightedEdge<Vertex> edge : graph.neighbors(v)) {

                Vertex from = edge.from();
                Vertex to = edge.to();
                double weight = edge.weight();

                if (!distTo.containsKey(to)) {
                    distTo.put(to, Double.MAX_VALUE);
                }
                if (distTo.get(from) + weight < distTo.get(to)) {
                    distTo.replace(to, distTo.get(from) + weight);
                    if (pq.contains(to)) {
                        pq.changePriority(to, distTo.get(to) + heuristic(to, end));
                    } else {
                        pq.add(to, distTo.get(to) + heuristic(to, end));
                    }
                }
            }
        }
        time = sw.elapsedTime();
    }

    private double heuristic(Vertex s, Vertex goal){
        return graph.estimatedDistanceToGoal(s, goal);
    }

    public SolverOutcome outcome(){
        return outcome;
    }

    public List<Vertex> solution(){
        return solution;
    }

    public double solutionWeight(){
        return solutionWeight;
    }
    public int numStatesExplored(){
        return numStatesExplored;
    }
    public double explorationTime(){
        return time;
    }
}

