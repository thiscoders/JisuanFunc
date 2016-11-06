package pack02;

import domain.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * 等距节点插值求x=0.52处的函数值
 * <p>
 * Created by ye on 11/6/16.
 */
public class Demo03 {
    private static List<Point> list = new ArrayList<Point>();

    private static Point p0 = new Point(0.50, 0.5210);
    private static Point p1 = new Point(0.55, 0.57815);
    private static Point p2 = new Point(0.60, 0.6366);
    private static Point p3 = new Point(0.65, 0.6967);
    private static Point p4 = new Point(0.70, 0.7585);
    private static Point p5 = new Point(0.75, 0.82231);
    private static Point p6 = new Point(0.80, 0.888106);

    static {
        list.add(p0);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
    }


    public static void main(String[] args) {
        Point px = new Point();
        px.setX(0.52);

        double res = exec(px);
        System.out.println(res);
    }

    //（0.5，0.5210）、（0.55,0.57815）、（0.6,0.6366）、（0.65，0.6967）（0.7,0.7585），（0.75，0.82231）、（0.8,0.888106）
    public static double exec(Point px) {
        return 0.1;
    }

}
