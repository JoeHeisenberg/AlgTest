package CasualTest;

/**
 * 1.给定一个整数数组，调整数组元素顺序，使得偶数元素在前，奇数元素在后，
 * 并且保证原先输入数组的奇数内部顺序以及偶数内部顺序
 */
public class ArrayPosTest {

    private static int[] solution(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int st = 0;
        int evenCount = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (isOdd(nums[i])) {
                evenCount += 1;
                temp[evenCount - 1] = nums[i];
            } else {
                if (st < i) {
                    // 将偶数依次放在原数组前面
                    nums[st] = nums[i];
                }
                st++;
            }
        }

        if (evenCount > 0) {
            for (int i = st; i < nums.length; i++) {
                nums[i] = temp[i - st];
            }
        }
        return nums;
    }

    // 与1做按位运算，不为0就是奇数，反之为偶数
    private static boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    //打印结果
    private static void print(int[] result) {
        if (result != null) {
            for (int i : result
                    ) {
                System.out.print(i + ",");
            }
            System.out.println();
        } else
            System.out.println("null");
    }

    public static void main(String[] args) {
        int[] test1 = {11, 9, 5, 7, 3, 15, 19};
        print(solution(test1));

        int[] test2 = {0, 6, 12, 8, 4, 14, 20};
        print(solution(test2));

        int[] test3 = {2, 1, 3, 6, 4, 7, 8, 5};
        print(solution(test3));

        int[] test4 = {1, 3, 7, 5, 2, 6, 4, 8};
        print(solution(test4));

        int[] test5 = null;
        print(solution(test5));

    }

}
