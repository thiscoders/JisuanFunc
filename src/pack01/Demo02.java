package pack01;

/**
 * 弦截法求解方程
 * Created by ye on 11/1/16.
 */
public class Demo02 {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        // 设本函数隔根区间为[1,1.5]
        if (!isOK(1, 1.5)) {
            System.out.println("函数在[1,1.5]区间不可以使用弦截法求解！");
            return;
        }
        double zeropoint = exec(1, 1.5);
        System.out.println("弦截法零点是：" + zeropoint);
    }
    /**
     * 执行函数
     */
    public static double exec(double x1, double x2) {
        double res = 1.00;
        // 记不动点为(1,f(1))
        double x0 = x1;
        double y0 = fx(x1);
        double temp = x0 - (x2 - x0) * fx(x0) / (fx(x2) - fx(x0));
        double tt = temp;
        while (true) {
            tt = temp;
            temp = x0 - (temp - x0) * fx(x0) / (fx(temp) - fx(x0));
            if (tt == temp) {
                res = temp;
                break;
            }
        }
        return res;
    }
    /**
     * 判断函数在[x1,x2]上是否可以用弦截法进行求解
     * @param x1 区间开始节点
     * @param x2 区间结束节点
     * @return true/false 可以/不可以弦截求解
     */
    public static boolean isOK(double x1, double x2) {
        boolean flag = false;
        if (deri3(x1) > 0) { // 三阶导大于0，二阶导函数单调递增
            if (deri2(x1) > 0 && (deri2(x1) < deri2(x2))) { // 二阶导函数在区间开始节点大于0，则二阶导函数在区间大于0，则一阶导函数在区间单调递增
                if (deri1(x1) > 0 && (deri1(x1) < deri1(x2))) {// 一阶导函数在x1处大于0，则一阶函数在区间大于0，原函数单调递增
                    flag = true;
                }
            }
        }
        return flag;
    }
    // f(x)=x*x*x -x-1
    /**
     * 原函数
     * @param x
     * @return
     */
    public static double fx(double x) {
        double f01 = x * x * x - x - 1;
        return f01;
    }
    /**
     * 一阶导函数，判断函数的单调性
     *
     * @param x
     * @return
     */
    public static double deri1(double x) {
        double deri01 = 3 * x * x - 1;
        return deri01;
    }
    /**
     * 二阶导函数，判断一阶导函数的单调性
     *
     * @param x
     * @return
     */
    public static double deri2(double x) {
        double deri02 = 6 * x;
        return deri02;
    }
    /**
     * 三阶导函数，判断二阶导函数的单调性
     *
     * @param x
     * @return
     */
    public static double deri3(double x) {
        double deri03 = 6;
        return deri03;
    }
}
