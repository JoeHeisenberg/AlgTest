package DataSAna;

import java.util.Stack;

public class MaxSubSeqCase {
    //Liner time max contiguous sub-sequence sum O(N) implement
    public static int maxSubSum(int[] a) {
        int subMaxSum = 0;
        int subSum = 0;
        for (int i = 0; i < a.length; i++) {

            subSum += a[i];
            if (subSum > subMaxSum) {
                subMaxSum = subSum;
            } else if (subSum < 0)
                subSum = 0;
        }
        return subMaxSum;
    }

    //递归实现
    public static int maxSubSeq1(int[] a, int lo, int hi) {

        if (lo == hi)
            if (a[lo] > 0) return a[lo];
            else return 0;

        //递归切分调用（分）
        int mid = (lo + hi) / 2;
        int maxLeftSub = maxSubSeq1(a, lo, mid);
        int maxRightSub = maxSubSeq1(a, mid + 1, hi);
        //求左半最大子序列和
        int maxLeftSubSum = 0, leftSubSum = 0;
        for (int i = mid; i >= lo; i--) {
            leftSubSum += a[i];
            if (leftSubSum > maxLeftSubSum) {
                maxLeftSubSum = leftSubSum;
            }
        }

        //求右半最大子序列和
        int maxRightSubSum = 0, rightSubSum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            rightSubSum += a[j];
            if (rightSubSum > maxRightSubSum) {
                maxRightSubSum = rightSubSum;
            }
        }

        //比较求最大值（治）
        int big = maxLeftSub > (maxLeftSubSum + maxRightSubSum) ? maxLeftSub : (maxLeftSubSum + maxRightSubSum);
        return big > maxRightSub ? big : maxRightSub;
    }


    public static void main(String[] args) {
        int[] a = {1, -3, 4, -67, 55, 7, 4, -6, -5,-3, 4, -67, 55, 7, 4, -6, 41, 4,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5, 1, -3, 4, -67, 55, 7, 4, -6, -5,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5,  -3, 4, -67, 5, 1, -3, 4, -67,
                1, -3, 4, -67, 55, 7, 4, -6, -5,4, -67, 5, 1,4, -6, -5,-3, 4, -67, 55, 7, 4,
                -67, 5, 1, -3, 4, -67, 55, 7, 4, -6, -5, -67, 5, 1,4, -6, -5,
                1, -3, 4, -67, 55, 7, 4, -6, -5,-3, 4, -67, 55, 7, 4, -6, 41, 4,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5, 1, -3, 4, -67, 55, 7, 4, -6, -5,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5,  -3, 4, -67, 5, 1, -3, 4, -67,
                1, -3, 4, -67, 55, 7, 4, -6, -5,4, -67, 5, 1,4, -6, -5,-3, 4, -67, 55, 7, 4,
                -67, 5, 1, -3, 4, -67, 55, 7, 4, -6, -5, -67, 5, 1,4, -6, -5,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5,  -3, 4, -67, 5, 1, -3, 4, -67,
                1, -3, 4, -67, 55, 7, 4, -6, -5,4, -67, 5, 1,4, -6, -5, -5,4, -67, 5, 1,4, -6, -5,-3, 4,
                41, 4, -65, 1, 1, 59, 5, 65, 7, 4, -6, -5, 41, 4, -65, 1, 1, 59, 5, 6,
                -65, 1, 1, 59, 5, 6, 1, -3, 4, -67, 5,  -3, 4, -67, 5, 1, -3, 4, -67,
                1, -3, 4, -67, 55, 7, 4, -6, -5,4, -67, 5, 1,4, -6, -5, -5,4, -67, 5, 1,4, -6, -5,-3, 4,
                41, 4, -65, 1, 1, 59, 5, 65, 7, 4, -6, -5, 41, 4, -65, 1, 1, 59, 5, 6
        };
        //int[] a = {1, 4, -9, 9};
        int subMax = maxSubSum(a);
        int subMax1 = maxSubSeq1(a, 0, a.length - 1);

        System.out.println("线性实现：" + subMax);
        System.out.println("递归实现：" + subMax1);
    }
}
