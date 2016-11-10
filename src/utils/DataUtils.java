package utils;

import domain.Point;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ye on 11/6/16.
 */
public class DataUtils {

    /**
     * 初始化数据，将数组转化成对应的点
     * @param dx x的数组
     * @param dy y的数组
     * @return 包含点的集合
     */
    public static List<Point> initRes(double[] dx, double[] dy) {
        List<Point> list = new ArrayList<Point>();
        Point point;
        for (int i = 0; i < dx.length; i++) {
            point = new Point();
            point.setX(dx[i]);
            point.setY(dy[i]);
            list.add(point);
        }
        return list;
    }


    //处理计算结果，保留5位小数
    public static double handle(double i) {
        BigDecimal b = new BigDecimal(i);
        double f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}
