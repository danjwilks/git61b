package bearmaps;

import java.util.List;

public class NaivePointSet implements PointSet {

    private final List<Point> points;

    public NaivePointSet(List<Point> points){
        this.points = points;
    }

    /** returns the nearest point */
    @Override
    public Point nearest(double x, double y){

        Point pointToCompare = new Point(x, y);
        Point closestPoint = pointToCompare;
        double smallestDistance = Double.MAX_VALUE;

        for (Point p : points){
            double distance = Point.distance(pointToCompare, p);
            if (distance < smallestDistance){
                smallestDistance = distance;
                closestPoint = p;

            }
        }
        return closestPoint;
    }
}