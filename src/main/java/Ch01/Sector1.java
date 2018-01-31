package Ch01;

import org.junit.Test;

/**
 * Created by lph on 2017/10/2.
 */
public class Sector1 {

    public static void main(String[] args) {
        System.out.println(sqrt(1e-15));

        int[] arr = {1,2,13,6,5,8,9,14,6};
        System.out.println(rank(5,arr));
    }

    //牛顿迭代法求平方根
    @Test
    public static double sqrt(double dd){
        if(dd<0) return Double.NaN;
        double err = 1e-15;
        double t = dd;
        while(Math.abs(t-dd/t)>err*t)
            t = (dd/t + t)/2.0;
        return t;
    }

    //用递归方法实现二分查找
    public static int rank(int key,int[] a){
        return rank(key,a,0,a.length-1);
    }

    private static int rank(int key,int[] a,int lo,int hi){
        if(lo>hi) return -1;
        int mid = lo + (lo+hi)/2;
        if(key<a[mid]) return rank(key,a,lo,mid);
        else if(key>a[mid]) return rank(key,a,mid,hi);
        return mid;
    }


}
