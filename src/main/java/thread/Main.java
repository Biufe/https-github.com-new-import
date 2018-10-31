package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int k = input.nextInt();
//
//        Scanner in = new Scanner(System.in);
//        //{begin}{a=1{a=2{print(a)}}}{end}  32 7
        StringBuffer sb = new StringBuffer();
//        String ss = in.nextLine();

        String ss = "{begin}{a=1{a=2{print(a)}}}{end}";
        sb.append(ss.substring(7));

        int count = 1;
        for(int i = 1 ;i<sb.length();i++){
            if(sb.charAt(i)=='{'){
                count++;
            }
            if(sb.charAt(i)=='}'){
                count--;
                if(count==0){
                    System.out.println(i+7);
                    break;
                }
            }
        }
        System.out.println(sb);

    }

    /*

     */
}
