package CasualTest;

public class MySortTest {

    /**
     * 通过记录最小元素（角标），依次选择比较，记录最下角标值，循环遍历排序
     * n=arr.length
     * i:[0,n-2]    <n
     * j:[i+1,n-1]  <n
     * 内循环一次，比较多次，赋值交换一次
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //记录数组长度
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            //记录最小元素角标
            int min = i;

            for (int j = i + 1; j < len; j++) {
                //比较后，最小元素角标记录赋值
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //一次循环后找出最小元素（角标）,做交换,然后进行下一轮循环
            if (min != i)
                swap(arr, i, min);
        }
    }

    /**
     * 依次取相邻两个比较，交换i:[]
     * n = arr.length
     * i:[n-1,1]    >0
     * j:[0,i-1]    <i-1
     * 内循环一次，比较多次，赋值交换多次
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //局部冒泡，插入
//        int len = arr.length;
//        for (int i = 1; i < len; i++) {
//            int temp = i;
//            for (int j = i - 1; j >= 0; j--) {
//                if (arr[temp] >= arr[j])
//                    break;
//
//                swap(arr, j, temp);
//                temp--;
//            }
//        }

        //真插入排序，插入后整体移动
        int i, j, k;
        int len = arr.length;
        //在arr[i]之前找到一个合适的插入位置
        for (i = 1; i < len; i++) {
            for (j = i - 1; j >= 0; j--)
                if (arr[j] < arr[i])
                    break;

            //如果找到合适的插入位置，则比arr[i]大的元素整体向后移动，然后插入
            if (j != i - 1) {       //！！如果arr[i]最大，则无需执行下边代码
                int temp = arr[i];
                for (k = i; k > j; k--)
                    arr[k] = arr[k - 1];
                arr[k + 1] = temp;
            }
        }

    }

    /**
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        //gap划分
        for (int gap = len / 2; gap > 0; gap /= 2) {
            //分组内元素循环
            for (int i = 0; i < gap; i++) {
                //选择分组元素，比较
                for (int j = i + gap; j < len; j += gap) {

//                    if (arr[j] < arr[j - gap]) {
//                        int temp = arr[j];
//                        int k = j - gap;
//                        while (k >= 0 && arr[k] > temp) {
//                            arr[k + gap] = arr[k];
//                            k -= gap;
//                        }
//                        arr[k + gap] = temp;
//                    }

                    //使用for循环
                    int k;
                    for (k = j - gap; k >= 0; k--)
                        if (arr[k] < arr[j])
                            break;

                    if (k != (j - gap)) {
                        int temp = arr[j];
                        for (int z = j - 1; z > k; z--)
                            arr[z + 1] = arr[z];
                        arr[k + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     *
     *
     * @param a
     * @param l
     * @param r
     */
    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i,j,x;

            i = l;
            j = r;
            x = a[j];
            while (i < j) {
                while(i < j && a[i] < x)
                    i++; // 从右向左找第一个小于x的数
                if(i < j)
                    a[j--] = a[i];
                while(i < j && a[j] > x)
                    j--; // 从左向右找第一个大于x的数
                if(i < j)
                    a[i++] = a[j];
            }
            a[j] = x;
            quickSort(a, l, i-1); /* 递归调用 */
            quickSort(a, i+1, r); /* 递归调用 */
        }
    }

    //交换数组元素位置
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void show(int[] arr) {
        for (int e : arr
                ) {
            System.out.print(e + " ");
        }
    }

    public static void main(String args[]) {

        int[] arr = {1, 12, 5, 89, 45, 11, 36, 25};

        System.out.println("排序前：");
        show(arr);

        System.out.println("\nSelectSort 排序后：");
        selectSort(arr);
        show(arr);

        System.out.println("\nBubbleSort 排序后：");
        bubbleSort(arr);
        show(arr);

        System.out.println("\nInsertSort 排序后：");
        insertSort(arr);
        show(arr);

        System.out.println("\nShellSort 排序后：");
        shellSort(arr);
        show(arr);

        System.out.println("\nQuickSort 排序后：");
        quickSort(arr,0,arr.length-1);
        show(arr);
    }
}
