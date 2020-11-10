

package socket;



import java.io.IOException;

import java.net.Socket;

import java.net.UnknownHostException;



public class Client {


        public static void main(String[] args) {
            Socket s;
            try {
                s = new Socket("127.0.0.1",8888);
                //接收
                new SendThread(s).start();
                //发送
                new RecieveThread(s).start();
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

        }
    }





