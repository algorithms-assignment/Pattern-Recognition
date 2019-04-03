import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(this.x, this.y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        int changeInY = this.y - that.y;
        int changeInX = this.x - that.x;
        if(changeInX == 0 && changeInY == 0){
            return Double.NEGATIVE_INFINITY;
        }else if(changeInY == 0){
            return Double.POSITIVE_INFINITY;
        }else{
            return (double) (changeInY) / (double)(changeInX);
        }
    }


    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point that) {
        if(this.y != that.y){
            return this.y - that.y;
        }else{
            return this.x - that.x;
        }
    }


    public Comparator<Point> slopeOrder() {

        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double difference = slopeTo(o1) - slopeTo(o2);
                if(difference < 0) return -1;
                else if(difference > 0) return 1;
                else return 0;
            }
        };

    }

    public static void main(String args[]) {
        Point p = new Point(32,77);
        p.draw();


    }
}
