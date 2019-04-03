import java.util.Arrays;
import java.util.Vector;

public class BruteCollinearPoints {
    private final Point[] points;
    private  int numberOfSegments;
    public BruteCollinearPoints(Point[] points) {
        int numberOfPoints = points.length;
        if(numberOfPoints == 0) throw new IllegalArgumentException("NO POINTS");
        for(int i = 0; i < numberOfPoints; i++) {
            if(points[i] == null) throw new IllegalArgumentException("NULL POINT DETECTED");
        }
        Arrays.sort(points); // since it implements the comparable interface and overrides the compareTo method;
        // slope from the initial point to the next , the next to the next to the next;
        for(int i = 0; i < numberOfPoints - 1; i++){
            if(points[i].slopeTo(points[i+1]) == Double.NEGATIVE_INFINITY)
                throw new IllegalArgumentException("REPEATED POINT IS DETECTED");
        }

        // If there is no repeated line, null points, and if the array is not empty, then sort the array and
        // assign the property

        this.points = points.clone();

    }

    public int numberOfSegments() {
        return this.numberOfSegments;
    }

    public LineSegment[] segments() {
        Vector<LineSegment> lineSegments = new Vector();

        Arrays.sort(points);
        double prevSlope = Double.NEGATIVE_INFINITY;

        int numberOfPoints = points.length;
        for(int i = 0; i < numberOfPoints - 1; i++) {
            for(int j = i + 1; j < numberOfPoints - 1; j++) {
                double newSlope = points[i].slopeTo(points[j]);
                if(newSlope != prevSlope){
                    numberOfSegments++;
                    lineSegments.add(new LineSegment(points[i], points[j]));
                    prevSlope = newSlope;
                }
            }
        }

        LineSegment[] array = new LineSegment[lineSegments.size()];
        return lineSegments.toArray(array);

    }
}
