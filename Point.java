/*
pg 577 p   see the powerpoint for Chapter 8   to create the Point class
exercise 9-12
9. Write a class called Line that represents a line segment between two Points. Your Line objects should have the
following methods:
public Line(Point p1, Point p2)
Constructs a new Line that contains the given two Points.
public Point getP1()
Returns this Line’s first endpoint.
public Point getP2()
Returns this Line’s second endpoint.
public String toString()
Returns a String representation of this Line, such as "[(22, 3), (4, 7)]".
10. Add the following method to your Line class:
public double getSlope()
Returns the slope of this Line. The slope of a line between points (x1, y1) and (x2, y2) is equal to (y2 – y1) / (x2 – x1).
If x2 equals x1 the denominator is zero and the slope is undefined, so you may throw an exception in this case.
11. Add the following constructor to your Line class:
public Line(int x1, int y1, int x2, int y2)
Constructs a new Line that contains the given two Points.
12. Add the following method to your Line class:
public boolean isCollinear(Point p)
Returns true if the given Point is collinear with the Points of this Line—that is, if, when this Line is stretched
infinitely, it would eventually hit the given Point. Points are collinear if a straight line can be drawn that connects
them. Two basic examples are three points that have the same x- or y-coordinate. The more general case can be
determined by calculating the slope of the line between each pair of points and checking whether this slope is the
same for all pairs of points. Use the formula (y2 – y1) / (x2 – x1) to determine the slope between two points (x1, y1)
and (x2, y2). (Note that this formula fails for points with identical x-coordinates, so this will have to be a special case
in your code.) Since Java’s double type is imprecise, round all slope values to a reasonable accuracy such as four
digits past the decimal point before you compare them. 
*/
public class Point {  
    private int x;  
    private int y;  // constructs a new point at the origin, (0, 0)  
    public Point() {  
       this(0, 0); // calls Point(int, int) constructor  
    }  // constructs a new point with the given (x, y) location  
    public Point(int x, int y) {  
        setLocation(x, y);  
    }  // returns the distance between this Point and (0, 0)  
    public double distanceFromOrigin() {  
        return Math.sqrt(x * x + y * y);  
    }  // returns the x-coordinate of this point  
    public int getX() {  
        return x;  
    }  // returns the y-coordinate of this point  
    public int getY() {  
        return y;  
    }  // sets this point's (x, y) location to the given values  
    public void setLocation(int x, int y) {  
        this.x = x;  this.y = y;  
    }  // returns a String representation of this point  
    public String toString() {  
        return "(" + x + ", " + y + ")";  
    }  // shifts this point's location by the given amount  
    public void translate(int dx, int dy) {  
        setLocation(x + dx, y + dy);  
    }  
}
