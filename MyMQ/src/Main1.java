import java.io.IOException;
import java.util.Scanner;
 
public class Main1 {
 
    public static void main(String[] args) throws IOException {
        System.out.println("������1��2ѡ��д�뻹��ȡ��:");
        System.out.println("1.д����Ϣ  2.������Ϣ");
        int in;
        int i = 1;
        while(( in = new Scanner(System.in).nextInt())!=-1){
            if(in==1){//д����Ϣ
                MqClient mqClient = new MqClient();
                mqClient.produce("Hello world-"+i);
                i++;
            }else if(in==2){
                MqClient mqClient = new MqClient();
                String msg = mqClient.consume();
                System.out.println("��ȡ����Ϣ�ǣ�"+msg);
            }else{
                System.out.println("��������ȷ��ѡ��");
            }
            
            System.out.println("������1��2ѡ��д�뻹��ȡ��:");
            System.out.println("1.д����Ϣ  2.������Ϣ");
        }
    }
}
 