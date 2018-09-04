package CasualTest;

import java.util.Scanner;

//public class Test {
//    public static int get3Max(String num){
//        int maxTimes = 0;
//        if(num!=null){
//            for (int i=1;i<=num.length();i++){
//                for (int j=0;j<=num.length()-i;j++){
//                    if((Integer.parseInt(num.substring(j,j+i)))%3==0){
//                        maxTimes++;
//                    }
//                }
//            }
//        }
//        return maxTimes;
//    }
//
//    public static void main(String[] args){
//        System.out.println(get3Max("1251"));
//    }
//}

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        while (in.hasNextLine()) {
//            StringBuilder num =new StringBuilder();
            String num = in.nextLine();
//            num.append(in.nextInt());
            int maxTimes = 0;
            if (num.length() < 100) {
                for (int i = 1; i <= num.length(); i++) {
                    for (int j = 0; j <= num.length() - i; j++) {
                        if ((Integer.parseInt(num.substring(j, j + i))) % 3 == 0) {
                            maxTimes++;
                        }
                    }
                }
            }
            System.out.println(maxTimes);
//        }
    }
}

// 12345     1 2 3 4 5     12 23 34 45    123 234 345        1234 2345       12345

