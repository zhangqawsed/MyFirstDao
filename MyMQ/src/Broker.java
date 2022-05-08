import  java.util.concurrent.ArrayBlockingQueue ;
public class Broker {
	private  final  static  int  MAX_SIZE  =  3;
	private  static  ArrayBlockingQueue<String>  messageQueue = new ArrayBlockingQueue(MAX_SIZE) ;
	
	public  static  void  produce(String  msg){
		if(messageQueue.offer(msg)){
		System.out.println("�ɹ�����Ϣ��������Ͷ����Ϣ��"+msg+", ��ǰ�ݴ����Ϣ�����ǣ� " + messageQueue.size());
		}
		else{
			System.out.println("�ݴ����Ϣ�ﵽ��󸺺ɣ����ܼ���������Ϣ��");
		}
		System.out.println("=================");
	}
	
	public  static  String  consume(){
		String msg = messageQueue.poll();
		if(msg!=null){
			System.out.println("�Ѿ�������Ϣ�� "+ msg +", ��ǰ�ݴ����Ϣ�����ǣ� "+messageQueue.size());
		}else{
			System.out.println("��Ϣ����������û����Ϣ�ɹ����ѣ�");
		}
		System.out.println("=================");
		return msg;
		
	}
	
}
