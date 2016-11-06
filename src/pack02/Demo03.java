package pack02;

import domain.Point;
import org.junit.Test;
import utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 等距节点插值求x=0.52处的函数值
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
    private static double h = 0.05;

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
        System.out.println("结果是:" + DataUtils.handle(res));
    }

    //（0.5，0.5210）、（0.55,0.57815）、（0.6,0.6366）、（0.65，0.6967）（0.7,0.7585），（0.75，0.82231）、（0.8,0.888106）
    public static double exec(Point px) {
        double xf = getXF(p0, p1, p2, p3, p4);
        double res = p0.y;
        for (int i = 1; i < list.size(); i++) {
            Point[] ps = new Point[i + 1];
            double xs = 1;
            for (int j = 0; j < ps.length; j++) {
                ps[j] = list.get(j);
                if (j == ps.length - 1) break;
                xs *= (px.x - list.get(j).x);
            }
            double dy = getXF(ps);
            double hs = Math.pow(h, i);
            double jc = getJC(i - 1);

            res += dy * xs / (jc * hs);
        }

        return res;
    }

    //利用性质2计算差分
    public static double getXF(Point... pos) {
        int len = pos.length;
        double xs = Demo02.getXS(pos);//计算差商
        double res = xs * getJC(len - 1) * Math.pow(h, len - 1);//利用公式计算差分
        return res;
    }

    //计算阶乘
    public static double getJC(double n) {
        double res = 1;
        for (double i = n; i > 1; i--) {
            res *= i;
        }
        return res;
    }

    @Test
    public void test01() {
        System.out.println(getJC(5));
    }

    /*public static double C(int n, int s) {
        double up = n;
        for (int i = 1; i < s; i++) {
            up *= (n - i);
        }
        double down = 1;
        for (int i = s; i > 1; i--) {
            down *= i;
        }
        return up / down;
    }*/

}
