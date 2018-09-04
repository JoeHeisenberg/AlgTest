package cn.blog.Alg.SortAlg;

/**
 * 选择排序：Java
 *
 * 选择排序时间复杂度
 * 选择排序的时间复杂度是O(N2)。
 * 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1！因此，选择排序的时间复杂度是O(N2)。
 *
 * 选择排序稳定性
 * 选择排序是稳定的算法，它满足稳定算法的定义。
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 *
 * @author skywang
 * @date 2014/03/11
 */

public class SelectSort {

    /*
     * 选择排序
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void selectSort(int[] a, int n) {
        int i;        // 有序区的末尾位置
        int j;        // 无序区的起始位置
        int min;    // 无序区中最小元素位置

        for (i = 0; i < n; i++) {
            min = i;

            // 找出"a[i+1] ... a[n]"之间的最小元素，并赋值给min。
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }

            // 若min!=i，则交换 a[i] 和 a[min]。
            // 交换之后，保证了a[0] ... a[i] 之间的元素是有序的。
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {1, 56, 11, 7, 20, 40, 30, 10, 60, 50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        selectSort(a, a.length);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
