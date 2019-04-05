/**
 *
 * @Author Kaleab Mekonen
 *
 * */

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }


    public void draw() {

        StdDraw.point(x, y);
    }


    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if (this.x == that.x)
            if (this.y == that.y) return Double.NEGATIVE_INFINITY;  // Both points are the same
            else return Double.POSITIVE_INFINITY;  // Vertical line

        if (this.y == that.y)
            return 0.0;  // Horizontal line

        else return ((double) (that.y - this.y) / (double) (that.x - this.x));
    }

    public int compareTo(Point that) {
        int difY = this.y - that.y;
        if (difY != 0){
            return difY;
        } else {
            return (this.x - that.x);
        }
    }

    public Comparator<Point> slopeOrder() {
        return new BySlope(this);
    }

    private static class BySlope implements Comparator<Point> {
        private final Point p;

        public BySlope(Point p) {
            this.p = p;
        }

        public int compare(Point p1, Point p2) {
            double slopeTo1 = this.p.slopeTo(p1);
            double slopeTo2 = this.p.slopeTo(p2);

            if (slopeTo1 > slopeTo2) return 1;
            if (slopeTo1 < slopeTo2) return -1;
            else return 0;
        }
    }

    public String toString() {

        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        // Empty method
    }
}
