package utils;

import java.math.BigDecimal;

/**
 * Created by ye on 11/6/16.
 */
public class DataUtils {

    //处理计算结果，保留5位小数
    public static double handle(double i) {
        BigDecimal b = new BigDecimal(i);
        double f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

}
