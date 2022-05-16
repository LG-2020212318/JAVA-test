import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
//120.0.0.1进行回路测试的ip地址
public class client {
    public static void main(String[] args) {
        new MFrame2("客户端");
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
class MFrame2 extends JFrame {
    JTextField id_F = new JTextField(20);//jtextfield单行文本接收用户输入
    JTextField say_F = new JTextField(20);
    JTextField port_F = new JTextField(20);
    JButton con_B = new JButton("connect");//添加按钮
    JButton say_B = new JButton("say");
    JTextArea jTextArea = new JTextArea(20, 20);
    Socket socket = null;//Socket是网络运行的程序之间双向通信的最后结点


    public MFrame2(String string) {
        super(string);
        init();//初始化窗口
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口可关闭
        this.addWindowListener(new WindowAdapter() {//添加窗口监听器
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    socket.close();//socket关闭
                } catch (IOException ioException) {
                    ioException.printStackTrace();//获取出错的栈信息
                }
            }
        });
    }
    public void init() {
        Container container = this.getContentPane();

        JPanel jPanel = new JPanel(null);
        JPanel jPanel1 = new JPanel(null);
        JLabel jLabel = new JLabel("客户机设置:");
        JLabel jLabel1 = new JLabel("Server ID:");
        JLabel jLabel3 = new JLabel("Say:");
        JLabel jLabel2 = new JLabel("Server Port:");
        container.add(jPanel);
        container.add(jTextArea);
        container.add(jPanel1);
        jPanel.add(jLabel1);
        jPanel.add(jLabel);
        jPanel.add(id_F);
        jPanel.add(con_B);
        jPanel.add(jLabel2);
        jPanel.add(port_F);
        jPanel1.add(jLabel3);
        jPanel1.add(say_F);
        jPanel1.add(say_B);

        jPanel.setBounds(10, 10, 390, 100);//中间容器
        jLabel.setBounds(10, 10, 100, 30);//"客户机设置“标签
        jLabel1.setBounds(5, 40, 100, 30);//"Server ID"标签
        jLabel2.setBounds(150, 40, 150, 30);//"Server Port"标签
        id_F.setBounds(60, 45, 80, 20);//左侧文本框
        port_F.setBounds(220, 45, 60, 20);//右侧文本框
        con_B.setBounds(290, 45, 80, 20);//"connect"标签
        jTextArea.setBounds(20, 100, 350, 300);//文本框
        jPanel1.setBounds(10, 380, 400, 80);//中间容器
        jLabel3.setBounds(10, 40, 50, 30);//"Say"标签
        say_F.setBounds(45, 46, 250, 20);//文本框
        say_B.setBounds(300, 45, 70, 20);//"say"按钮

        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(500, 100, 400, 500);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        say_B.addActionListener(new MAction());
        con_B.addActionListener(new MAction());
        this.setResizable(true);//窗口大小可调节
    }
    class MAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "connect") {//getActionCommand获取按钮上的字符串
                try {
                    jTextArea.setText("Connect to server...");
                    int i = Integer.parseInt(port_F.getText());
                    socket = new Socket(id_F.getText(), i);
                    new MThread().start();//启动新线程
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (e.getActionCommand() == "say") {
                try {
                    OutputStream outputStream = socket.getOutputStream();//传出数据
                    outputStream.write(say_F.getText().getBytes());//
                    outputStream.flush();//刷新输出流
                    jTextArea.append("\r\nClient:" + say_F.getText());//将指定字符串添加到指定位置
                    say_F.setText("");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
    class MThread extends  Thread{//实现客户端和服务端同时输出字符
        public void run(){
             try{
                 InputStream inputStream=socket.getInputStream();
                 byte[] b=new byte[1024];
                 int len=0;
                 while((len=inputStream.read(b))!=-1){
                   jTextArea.append("\r\nServer:"+new String(b,0,len));
                 }
             }
             catch(IOException e){
                 e.printStackTrace();
             }
        }
    }
}
