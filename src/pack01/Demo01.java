package pack01;

/**
 * 牛顿法求解方程
 * Created by ye on 11/1/16.
 */
public class Demo01 {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args){
        newton10();
    }

    //newton x*x*x-155=0  10
    public static void newton10(){
        double podouble=yt1where0(10);
        System.out.println("podouble is "+podouble);
        yt1where0(podouble);
        for(int i=0;i<=10;i++){
            double bef=podouble;
            podouble=yt1where0(podouble);
            if(bef==podouble)
                return;
            System.out.println("podouble haha is "+podouble);
        }
    }

    //y1
    public static double y1(double x){
        return x*x*x-155;
    }

    //y1d
    public static double yd1(double x){
        return 3*x*x;
    }

    //return qiexian 0 podouble
    public static double yt1where0(double x0){
        double up=y1(x0);
        double down=yd1(x0);
        return x0-up/down;
    }



}
