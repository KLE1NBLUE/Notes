
package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

        public static void main(String[] args) {

            JFrame f=new JFrame("server");
            f.setLocation(400,500);
            f.setSize(600, 650);
            JButton b1=new JButton("send");
            b1.setBounds(20,20,100,30);

            JTextArea ja=new JTextArea();

            ja.setLineWrap(true);//将参数设为true自动换行
            //如果是想每一次输入都是换行的话，那就在在上一次输入的最后加一个"\r\n"

            //调节JTextArea的字体大小
            Font font=new Font("Default",Font.PLAIN,29);
            ja.setFont(font);

            ja.setSize(new Dimension(400,400));
            ja.setLocation(0,0);
            JTable jt=new JTable();
            jt.add(ja);
            jt.setLocation(150, 20);
            jt.setSize(new Dimension(400,500));

            JTextField jf=new JTextField();
            jf.setLocation(20,80);
            jf.setSize(new Dimension(100,50));

            try {
                ServerSocket ss=new ServerSocket(8888);
                System.out.println("监听在端口号：8888");
                Socket s=ss.accept();
                InputStream is= s.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                OutputStream os=s.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                //接收
                Thread t1=new Thread() {
                    public void run() {
                        //线程的While(true)里面放要循环的内容需要不停执行的内容，不需要不停执行的不必放
                        //按钮监听了发送，不需要发送线程了
                        while(true) {
                            try {
                                String s=dis.readUTF();
                                if(s!="") {
                                    ja.append("client:"+s+"\r\n");
                                    jt.updateUI();
                                }
                            } catch (IOException e) {
                                // TODO 自动生成的 catch 块
                                e.printStackTrace();
                            }
                        }
                    }
                };  t1.start();

                b1.addMouseListener(new MouseAdapter(){
                    public void mouseReleased(MouseEvent e) {
                        String s=jf.getText();
                        jf.setText(null);
                        //发送
                        try {
                            dos.writeUTF(s);ja.append("server:"+s+"\r\n");//jt.updateUI();
                        } catch (IOException e1) {
                            // TODO 自动生成的 catch 块
                            e1.printStackTrace();
                        }
                    }
                });

            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

            f.add(b1);
            f.add(jf);
            f.add(jt);

            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        }

}
