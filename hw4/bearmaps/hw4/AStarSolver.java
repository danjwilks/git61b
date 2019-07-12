package bearmaps.hw4;

import java.util.List;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {


    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout){
    }

    public SolverOutcome outcome(){
        return null;
    }

    public List<Vertex> solution(){
        return null;
    }
    public double solutionWeight(){
        return 1.0;
    }
    public int numStatesExplored(){
        return 1;
    }
    public double explorationTime(){
        return 1.0;
    }
}

