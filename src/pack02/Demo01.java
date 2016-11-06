package pack02;

import org.junit.Test;

/**
 * 用拉格郎日插值公式确定函数值；对函数f(x)进行拉格郎日插值，并对f(x)与插值多项式的曲线作比较
 * （0.56160,0.82741）、（0.56280,0.82659）、（0.56401,0.82577）、（0.56521,0.82495）
 * x=0.5635
 * Created by ye on 11/1/16.
 */
public class Demo01 {
    private static double x0 = 0.56160, y0 = 0.82741;
    private static double x1 = 0.56280, y1 = 0.82659;
    private static double x2 = 0.56401, y2 = 0.82577;
    private static double x3 = 0.56521, y3 = 0.82495;

    //已知函数表：（0.56160,0.82741）、（0.56280,0.82659）、（0.56401,0.82577）、（0.56521,0.82495）
    // 用三次拉格朗日插值多项式求x=0.5635时函数近似值
    public static void main(String[] args) {
        double res = exec01(0.5635);
        System.out.println("结果是:" + res);
    }

    //(x - x0) * (x - x1) * (x - x2) * (x - x3)
    public static double exec01(double x) {
        double res = ((x - x1) * (x - x2) * (x - x3) * y0) / ((x0 - x1) * (x0 - x2) * (x0 - x3))
                + (((x - x0) * (x - x2) * (x - x3) * y1) / ((x1 - x0) * (x1 - x2) * (x1 - x3)))
                + (((x - x0) * (x - x1) * (x - x3) * y2) / ((x2 - x0) * (x2 - x1) * (x2 - x3)))
                + (((x - x0) * (x - x1) * (x - x2) * y3) / ((x3 - x0) * (x3 - x1) * (x3 - x2)));
        return res;
    }


    /*
    @Test
    public void test01() {
        String s1 = "lala";
        String s2 = "lala";
        String s3 = new String("lala");

        int i1 = 10;
        int i2 = 10;
        int i3 = new Integer(10);
        System.out.println(i1 == i2);
    }*/

}
