
public class mainPoint {
    public static void main (String args[]){
        //test commands

        //construcotrs
        Point pnt1 =new Point (3,5); 
        Point pnt2 =new Point (6,5);
        Point pnt3 =new Point (3,6);

        //line object
        Line ln = new Line (pnt1, pnt2);

        //tests different methods
        System.out.println(ln.toString());
        System.out.println(ln.getSlope());
        System.out.println(ln.isCollinear(pnt3));
    }
}
