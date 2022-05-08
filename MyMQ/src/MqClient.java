import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
 
public class MqClient {
    private final static int SERVER_PORT = 9999;
    //������Ϣ
    public static void produce(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            out.println(msg);
            out.flush();
        }
    }
    //������Ϣ
    public static String consume() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),SERVER_PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
        ){
            //������Ϣ���з����ַ���"CONSUME"��ʾ����
            out.println("CONSUME");
            out.flush();
            //�ٴ���Ϣ�����л�ȡһ����Ϣ
            String msg = in.readLine();
            return  msg;
        }
    }
}