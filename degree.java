package degree;

import java.math.BigDecimal;
import java.util.Scanner;


public class degree {
    public static void main(String[] args){
        double d,H;
        System.out.println("摄氏度转化为华氏度");
        System.out.println("请输入摄氏度");
        Scanner input=new Scanner(System.in);
        d=input.nextDouble();
        System.out.println(d);
        H=(9.0/5)*d+32;
        System.out.println("H="+H);
    }
}
