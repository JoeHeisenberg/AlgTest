package cn.blog.Alg.SortAlg;

/**
 * 希尔排序：Java
 * <p>
 * 希尔排序时间复杂度
 * 希尔排序的时间复杂度与增量(即，步长gap)的选取有关。
 * 例如，当增量为1时，希尔排序退化成了直接插入排序，此时的时间复杂度为O(N²)，而Hibbard增量的希尔排序的时间复杂度为O(N3/2)。
 * <p>
 * 希尔排序稳定性
 * 希尔排序是不稳定的算法，它不满足稳定算法的定义。对于相同的两个数，可能由于分在不同的组中而导致它们的顺序发生变化。
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。
 * 则这个排序算法是稳定的！
 *
 * @author skywang
 * @date 2014/03/11
 */

public class ShellSort {

    /**
     * 希尔排序
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组的长度
     */
    public static void shellSort1(int[] a, int n) {

        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {

                //如果gap=1则退化为insertSort
                for (int j = i + gap; j < n; j += gap) {

//                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
//                    if (a[j] < a[j - gap]) {
//
//                        int tmp = a[j];
//                        int k = j - gap;
//                        while (k >= 0 && a[k] > tmp) {
//                            a[k + gap] = a[k];
//                            k -= gap;
//                        }
//                        a[k + gap] = tmp;
//                    }

                    //使用for循环
                    int k;
                    for (k = j - gap; k >= 0; k--)
                        if (a[k] < a[j])
                            break;

                    if (k != (j - gap)) {
                        int temp = a[j];
                        for (int z = j - 1; z > k; z--)
                            a[z + 1] = a[z];
                        a[k + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * 对希尔排序中的单个组进行排序(相当于步长为gap的插入排序)
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组总的长度
     * i -- 组的起始位置
     * gap -- 组的步长
     * <p>
     * 组是"从i开始，将相隔gap长度的数都取出"所组成的！
     */
    public static void groupSort(int[] a, int n, int i, int gap) {

        for (int j = i + gap; j < n; j += gap) {

            // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
            if (a[j] < a[j - gap]) {

                int tmp = a[j];
                int k = j - gap;
                while (k >= 0 && a[k] > tmp) {
                    a[k + gap] = a[k];
                    k -= gap;
                }
                a[k + gap] = tmp;
            }
        }
    }

    /**
     * 希尔排序
     * <p>
     * 参数说明：
     * a -- 待排序的数组
     * n -- 数组的长度
     */
    public static void shellSort2(int[] a, int n) {
        // gap为步长，每次减为原来的一半。
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++)
                groupSort(a, n, i, gap);
        }
    }

    public static void main(String[] args) {
        int i;
        int a[] = {80, 30, 60, 40, 20, 10, 50, 70, 90};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        shellSort1(a, a.length);
        //shellSort2(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}