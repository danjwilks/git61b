package bearmaps;

import java.util.List;

public class KdTree {

    Node root;

    private class Node{
        Point point;
        Node left;
        Node right;
        int xory;

        private Node(Point point, int xory){
            this.point = point;
            this.xory = xory;
        }
    }

    public KdTree(List<Point> points){
        for (Point p: points) {
            insert(p);
        }
    }

    /** places point into kd tree, comparing x co-ordinate first
     * 1 represents x co-ordinate
     * 0 represents y co-ordinate */
    private void insert(Point point){

        int coordinate = 1;

        if (root == null){
            root = new Node(point, 0);
        } else {

            Node currentNode = root;

            while (currentNode != null) {
                if (coordinate == 1){
                    if (currentNode.point.getX() <= point.getX()) {
                        if (currentNode.right == null) {
                            currentNode.right = new Node(point, 1);
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = new Node(point, 1);
                            break;
                        } else {
                            currentNode = currentNode.left;
                        }
                    }
                    coordinate = 0;
                } else {
                    if (currentNode.point.getY() <= point.getY()) {
                        if (currentNode.right == null) {
                            currentNode.right = new Node(point, 0);
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = new Node(point, 0);
                            break;
                        } else {
                            currentNode = currentNode.left;
                        }
                    }
                    coordinate = 1;
                }
            }
        }
    }

    public Point nearest(double x, double y) {
        return nearestHelper(root, new Point(x,y), root).point;
    }

    private Node nearestHelper(Node n, Point goal, Node best){

        if (n == null){
            return best;
        }
        if (distance(n, goal) < distance(best, goal)){
            best = n;
        }
        Node goodside;
        Node badside;

        if (n.xory == 1){
            if (n.point.getY() < goal.getY()){
                goodside = n.right;
                badside = n.left;
            } else {
                goodside = n.left;
                badside = n.right;
            }
        } else {
            if (n.point.getX() < goal.getX()){
                goodside = n.right;
                badside = n.left;
            } else {
                goodside = n.left;
                badside = n.right;
            }
        }


        best = nearestHelper(goodside, goal, best);

        Point bestPossible;

        if (n.xory == 0){
            bestPossible = new Point(n.point.getX(), goal.getY());

        } else {
            bestPossible = new Point(goal.getX(), n.point.getY());
        }

        if (Point.distance(bestPossible, goal) < Point.distance(goal,best.point)){
            best = nearestHelper(badside, goal, best);
        }

        return best;

    }

    /** returns the distance between one node and a point */
    private double distance(Node n1, Point p){
        return Point.distance(n1.point, p);
    }

}

