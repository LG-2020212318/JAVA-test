public class person {
   private String name;
   private long ID;
   private String address;
   private long phonenum;
   private String email;
   public void showname(String name){
    this.name=name;
       //System.out.println(this.name);
   }
   public void showID(long ID){
       this.ID=ID;
       //System.out.println(this.ID);
   }
   public String toString(){
       return "类名："+this.getClass().getName()+" ID:"+ID+" 姓名:"+name;
   }
}
