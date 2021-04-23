
/*
pg 577 p   see the powerpoint for Chapter 8   to create the Point class *Page 558*
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
public class Line {
    public Point pt1;
    public Point pt2;
    public Line(){
        pt1.setLocation(0, 0);
        pt2.setLocation(1, 1);
    }
    public Line(Point p1, Point p2){
        pt1 = p1;
        pt2 = p2;
    }
    public Line(int x1, int y1, int x2, int y2){
        pt1.setLocation(x1, y1);
        pt2.setLocation(x2, y2);
    }
    public Point getP1(){
        return pt1;
    }
    public Point getP2(){
        return pt2;
    }
    public String toString(){
        return pt1.toString()+pt2.toString();
        //return ("[("+pt1.getX()+", "+pt1.getY()+")"+", ("+pt2.getX()+", "+pt1.getY()+")]");
    }
    //(y2 – y1) / (x2 – x1).
    public Double getSlope(){
        if(pt2.getX() != pt1.getX()){
            return Double.valueOf((pt2.getY()-pt1.getY())/(pt2.getX()-pt1.getX()));
        }
        else{
            return null;
        }
    }
    public boolean isCollinear(Point p){
        //System.out.println(getSlope()+" "+Double.valueOf((p.getY()-pt1.getY())/(p.getX()-pt1.getX())));
        if(p.getX()!=pt1.getX()){
            if(Double.compare(getSlope(),Double.valueOf((p.getY()-pt1.getY())/(p.getX()-pt1.getX())))==0){
                System.out.println("hello");
                return true;
                
            }
            else{
                return false;
            }
        }
        else{
            //if(Double.compare(getSlope(), Double.valueOf(((p.getY()+getSlope())-pt1.getY())/((p.getX()+getSlope())-pt1.getX())))==0){
            if(p.getY() ==  pt1.getY()){  
                return true;
            }
            else{
                return false;
            }
        }
    }

}
