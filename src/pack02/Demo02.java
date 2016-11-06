package pack02;

import java.util.ArrayList;
import java.util.List;

import domain.Point;
import utils.DataUtils;

/**
 * 牛顿插值法求解x=0.596出函数的取值
 * Created by ye on 11/3/16.
 */
public class Demo02 {
    private static List<Point> list = new ArrayList<Point>();
    private static Point p0 = new Point(0.4, 0.4107);
    private static Point p1 = new Point(0.55, 0.57815);
    private static Point p2 = new Point(0.65, 0.69675);
    private static Point p3 = new Point(0.8, 0.8881);
    private static Point p4 = new Point(0.9, 1.0265);
    private static Point p5 = new Point(1.05, 1.2538);

    static {
        list.add(p0);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
    }

    //（0.4，0.4107）、（0.55,0.57815）、（0.65,0.69675）、（0.8，0.8881）（0.9,1.0265），（1.05，1.2538）
    public static void main(String[] args) {
        Point px = new Point();
        px.setX(0.596);
        double res = exec(px);
        System.out.println("结果是：" + DataUtils.handle(res));
    }

    public static double exec(Point px) {
        //此处为牛顿插值公式
        double res = p0.getY();
        for (int i = 1; i < list.size(); i++) {
            Point[] f1 = new Point[i + 1];
            double f2 = 1;
            for (int j = 0; j < f1.length; j++) {
                f1[j] = list.get(j);
                if (j == f1.length - 1)
                    break;
                f2 *= (px.getX() - list.get(j).getX());
            }
            res += getXS(f1) * f2;
        }
        return res;
    }

    //此处递归计算差商
    public static double getXS(Point... pos) {
        int len = pos.length;
        double xs = 0;
        if (len == 2)
            return (pos[0].getY() - pos[1].getY()) / (pos[0].getX() - pos[1].getX());

        if (len > 2) {
            Point[] f1 = new Point[len - 1];
            Point[] f2 = new Point[len - 1];
            for (int i = 0; i < f1.length; i++) {
                f1[i] = pos[i];
                f2[i] = pos[i + 1];
            }
            xs = (getXS(f1) - getXS(f2)) / (pos[0].getX() - pos[len - 1].getX());
        }
        return xs;
    }
}
