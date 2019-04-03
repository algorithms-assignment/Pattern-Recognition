import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class LineSegment {
    private final Point p;
    private final Point q;

    public LineSegment(Point p, Point q) {
        if(p == null || q == null) throw new NullPointerException("NULL POINT EXCEPTION");
        this.p = p;
        this.q = q;
    }

    public void draw() {
        this.p.drawTo(this.q);
    }

    public String toString() {
        return p.toString() + " -> " + q.toString();
    }

    public int hashCode() {
        throw new UnsupportedOperationException();
    }

}
