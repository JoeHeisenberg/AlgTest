package cn.blog.dataStru.LinnerStru;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * create by Heisenberg
 */
public class SortTest {

    /**
     * @param key
     * @param sortedTest
     * @return
     */
    public int binarySearch(double key, double[] sortedTest) {
        int l = 0, h = sortedTest.length - 1;
        int mid = (l + h) / 2;

        while (l < h) {
            if (key == sortedTest[mid]) {
                return mid;
            } else if (key < sortedTest[mid]) {
                h = mid - 1;
                mid = (l + h) / 2;
            } else {
                l = mid + 1;
                mid = (l + h) / 2;
            }
        }
        return -1;

    }

    /**
     * Bubble Sort
     * 特点：相邻两两依次比较交换，遍历；O（n*n）
     * @param arr
     * @return
     */
    public double[] bubbleSort(double[] arr) {
        //逐次减去冒泡后的元素个数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }

            }
        }

//        int index_out = 0;
//        int index_in = 0;
//        //逐次记录冒泡后的位置
//        for (index_out = arr.length - 1; index_out > 0; index_out--) {
//            for (index_in = 0; index_in < index_out; index_in++) {
//                if (arr[index_in] > arr[index_in + 1]) {
//                    swap(arr, index_in, index_in + 1);
//                }
//            }
//        }

        return arr;
    }

    /**
     * Selection Sort
     * 特点：两两比较（不一定相邻），记录最小值角标，最终进行交换，部分遍历；O（n）+O（n*n）；
     * 降低了交换次数
     * @param arr
     * @return
     */
    public double[] selectSort(double[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[min] > arr[j + 1]) {
                    min = j + 1;
                }
            }
            swap(arr, i, min);
        }
        return arr;
    }

    /**
     * Insertion Sort
     * 特点：基于数组元素部分有序的假设，记录当前要插入元素的角标和值，进行前向遍历比较（不一定全部遍历）、移动，插入；
     * 减少了比较次数和交换次数
     * @param arr
     * @return
     */
    public double[] insertionSort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int fore = i;
            double temp = arr[i];

            for (int j = i; j > 0 && temp <= arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
                fore--;
            }
            arr[fore] = temp;
        }

//        for (int index_out = 1; index_out < arr.length; index_out++)
//        {
//            int index_in = index_out;
//            double temp = arr[index_out];
//            while(index_in > 0 && arr[index_in - 1] >= temp) {
//                arr[index_in] = arr[index_in -1];
//                index_in--;
//            }
//            arr[index_in] = temp;
//        }
        return arr;
    }

    /**
     * Shell Sort
     * 特点：
     * @param arr
     * @return
     */
    public double[] shellSort(double[] arr) {


        return arr;
    }

    /**
     * Merge Sort
     * 特点：
     * @param arr
     * @return
     */
    public double[] mergeSort(double[] arr){

        List list = new LinkedList();
        List list1 = new ArrayList(list);

        return arr;
    }

    /**
     * Quick Sort
     * 特点：
     * @param arr
     */
    public double[] quickSort(double[] arr){


        return arr;
    }


    private void printArr(double[] arr) {
        for (double d : arr
                ) {
            System.out.print(d + ",");
        }
    }

    private void swap(double[] arr, int v, int v1) {
        double temp = arr[v];
        arr[v] = arr[v1];
        arr[v1] = temp;

//        arr[v] = arr[v] + arr[v1];
//        arr[v1] = arr[v] - arr[v1];
//        arr[v] = arr[v] - arr[v1];
    }

    public static void main(String[] args) {

        SortTest sortTest = new SortTest();
        double[] test = new double[]{1.2, 2.3, 1.56, 56.33, 25.46, 7.9, 1.11, 3.2, 19.56, 8.3, 29.4, 1.56, 12, 8, 34};
//        double[] test = new double[]{1,5,4,45,5,4,4,5,478,75,987};
        System.out.println("test:");
        sortTest.printArr(test);

//        double[] sortedTest = sortTest.bubbleSort(test);
//        double[] sortedTest = sortTest.selectSort(test);
        double[] sortedTest = sortTest.insertionSort(test);
        System.out.println("\nsortedTest:");
        sortTest.printArr(sortedTest);

        int pos = sortTest.binarySearch(34, sortedTest);
        if (pos == -1) {
            System.out.println("\n不存在！");
        } else {
            System.out.println("\npos:" + pos);
        }

    }
}
