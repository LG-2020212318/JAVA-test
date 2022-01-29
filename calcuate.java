package calcuate;
 /*class orgain{
int x=5;
int y=3,z=0;}//通过类和对象实现每次计算完成都能初始化
*/
public class calcuate {
    public  int x=5, y=3, z=0;
    public void cal1() {
        System.out.println("已知x="+x+" y="+y +" z="+z);//print不会换行，而println会换行
    }
    public void cal2()
    {
        System.out.println("(1)求z=z+y*x++ 的值为" + (z + y * x++) + "  此时x的值为" + x);
    }
    public void cal3() {
        System.out.println("(2)求z=y+++x  的值为" + (y++ + x));
    }
    public void cal4() {
        System.out.println("(3)求z=y+x++  的值为" + ( y +  x++));
    }
    public void cal5(){
        System.out.println("(4)求z=~x  的值为"+ (~ x));//~是条件运算符，相当于if else
    }
    public void cal6(){
        System.out.println("(5)求z=x^y  的值为"+( x^ y));
    }
    public void cal7() {
        System.out.println("(6)求z=x<<y  的值为" + ( x <<  y));
    }
    public static void main(String[] args ){
        calcuate a=new calcuate();
        calcuate b=new calcuate();
        calcuate c=new calcuate();
        calcuate d=new calcuate();
        calcuate e=new calcuate();
        calcuate f=new calcuate();
        calcuate g=new calcuate();
        a.cal1();
        b.cal2();
        c.cal3();
        d.cal4();
        e.cal5();
        f.cal6();
        g.cal7();
    }
    }

