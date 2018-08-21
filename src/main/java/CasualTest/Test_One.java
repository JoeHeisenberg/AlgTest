package CasualTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test_One {

    @Test
    public void arraysTest(){
        int[] i = {1, 2, 3, 4, 5, 5};
        Integer[] integers ={6666,2,534,56,54};

        List list = Arrays.asList(i);
        List<Integer> list1 = Arrays.asList(integers);

        for (Object aList : list) {
            int[] a = (int[]) aList;
            for (int num : a
                    ) {
                System.out.println(num);
            }
        }

        for (Integer integer:list1
             ) {
            //System.out.println(Integer.parseInt(String.valueOf(integer)));
            System.out.println(integer);
        }
    }
}
