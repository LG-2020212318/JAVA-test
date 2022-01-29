import java.util.Random;
public class test {
    public static int getnum(int num1, int num2){//随机数的创建
        int result=(int)(num1+Math.random()*(num2-num1+1));
        return result;
    }
    public static String getstring(int length){//字符串随机数的创建
        String base="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuffer str=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(base.length());
            str.append(base.charAt(number));}
            return str.toString();

    }
    public static void main(String[] args) {
        student a[]=new student[5];//对象数组的定义
        for(int j=0;j<5;j++){
            a[j]=new student();
            a[j].showname(getstring(3));
            a[j].showID(getnum(100,999));
        }

        staff b[]=new staff[3];
        for(int k=0;k<3;k++){
            b[k]=new staff();
            b[k].showname(getstring(3));
            b[k].showID(getnum(100,999));
        }
        for(int i=0;i<5;i++){
            System.out.println(a[i].toString());
        }
        for(int k=0;k<3;k++){
            System.out.println(b[k].toString());
        }
    }
}
