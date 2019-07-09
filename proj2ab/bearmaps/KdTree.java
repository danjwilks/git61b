package bearmaps;

import java.util.List;

public class KdTree {

    Node root;

    private class Node{
        Point point;
        Node left;
        Node right;

        private Node(Point point){
            this.point = point;
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
            root = new Node(point);
        } else {

            Node currentNode = root;
            //TODO refactor, reuse code somehow, maybe a comparator

            while (currentNode != null) {
                if (coordinate == 1){
                    if (currentNode.point.getX() <= point.getX()) {
                        if (currentNode.right == null) {
                            currentNode.right = new Node(point);
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = new Node(point);
                            break;
                        } else {
                            currentNode = currentNode.left;
                        }
                    }
                    coordinate = 0;
                } else {
                    if (currentNode.point.getY() <= point.getY()) {
                        if (currentNode.right == null) {
                            currentNode.right = new Node(point);
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }
                    } else {
                        if (currentNode.left == null) {
                            currentNode.left = new Node(point);
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
        best = nearestHelper(n.left, goal, best);
        best = nearestHelper(n.right, goal, best);

        return best;

    }

    /** returns the distance between one node and a point */
    private double distance(Node n1, Point p){
        return Point.distance(n1.point, p);
    }

}

