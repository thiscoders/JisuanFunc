package pack03;

import domain.Point;
import utils.DataUtils;

import java.util.List;

/**
 * 求幂函数拟合数据
 * Created by ye on 11/10/16.
 */
public class Demo01 {
    private static double[] dx = {0.15, 0.4, 0.6, 1.01, 1.5, 2.2, 2.4, 2.7, 2.9, 3.5, 3.8, 4.4, 4.6, 5.1, 6.6, 7.6};
    private static double[] dy = {4.4964, 5.1284, 5.6931, 6.2884, 7.0989, 7.5507, 7.5106, 8.0756, 7.8708, 8.2403, 8.5303, 8.7394, 8.9981, 9.1450, 9.5070, 9.9115};
    private static List<Point> list;

    public static void main(String[] args) {
        list = DataUtils.initRes(dx, dy);
        System.out.println(list.toString());
    }

    public static void exec() {

    }

}
