import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class faculty extends employee {
    private String lecture;
    private String classtime;
    private String major;
    public void showlecture(String lecture){
        this.lecture=lecture;
        System.out.println(this.lecture);
    }
    public void showclasstime(String classtime){
        this.classtime=classtime;
    }
}
