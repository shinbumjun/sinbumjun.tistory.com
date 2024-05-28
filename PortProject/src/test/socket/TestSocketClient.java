package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * <pre>
 * Socket 클라이언트 프로그램 제작
 * @author 신범준
 * 1. Socket 생성
 * 1-1. Socket client = new S(127.0.0.1, 5555); 
 *        (127.0.0.1 ->localhost)
 * 2. connect() : 필요요소(ip, port), 1번단계에서 내부적으로 수행
 * 3. 1번의 객체에서 InputStream/OutputStream을 얻어옴.
 * 3-1. In in = client.getI; Out out = client.getOut
 * 4. input-> read(), output-> write()
 * 4-1. in.read();  out.write();
 * 5. close() <- IO 및 소켓
 * 5-1. client.close();
 * </pre>
 */
public class TestSocketClient {
	
	static Socket client; // 생성
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		 
		 // 1. 클라이언트 소켓 생성 및 서버 연결: 연결이 성공하면 클라이언트 소켓이 생성
		 System.out.println("Client started...");
		 // 클라이언트는 127.0.0.1 주소의 포트 5555에 연결을 시도 
		 client = new Socket("192.168.100.57", 5555); 
		 final int port = client.getLocalPort();
		 System.out.println("Connected OK!");
		 
		 // 2. 출력 타겟 생성 및 실행: 클라이언트는 서버로 데이터를 전송
		 InputStream in = client.getInputStream(); 
		 OutputStream out = client.getOutputStream();
		 Target outputTarget = new Target(out, port); // Target 객체 생성 
		 Thread outCPU = new Thread(outputTarget); // 이를 새로운 스레드에서 실행
		 outCPU.start();
		 
		 
		 // 4. 서버로부터 데이터 읽기: 클라이언트는 서버로부터 데이터를 읽고, 이를 콘솔에 출력
		 byte[] buffer = new byte[44]; // 버퍼 줄이기 1024-> 22
		 while(true)
		 {
			 int i = in.read(buffer);		 
			 System.out.println("read data : 클라이언트, 서버로부터 데이터 읽고 콘솔에 출력 = " + new String(buffer));
			 if(i == 0) {
				 break;	 
			 }
			 Thread.sleep(3000);
		 }
		 in.close();
		 client.close();
	}
}

// 3. 클라이언트 데이터 전송: 주기적으로 서버로 데이터를 전송
class Target implements Runnable{
	OutputStream out;
	int port;
	// 내 ip를 데이터에 추가 / data + scan로 전송해야한다
	String data = "" + TestSocketClient.client.getLocalAddress() + ">"; 
	
	public Target(OutputStream out, int port) {		
		this.out = out;	
		this.port = port;		
		// 여기서는 클라이언트의 포트 번호와 10을 결합한 문자열을 서버로 전송																
		this.data = data+port+ ">" + 10;	
	}
	
	public void run() {
		// Scanner 사용하여 입력하여 출력
		Scanner scan = new Scanner(System.in);
		
		try {
			
			 while(true) {	 
				// data = data + scan.next();
				System.out.println("대화내용");
				data = data + scan.next();
				
				out.write(data.getBytes());
				out.flush();
				// client 생성하고 -> 내 ip도 보내기, TestSocketClient.client.getLocalAddress()
				System.out.println(data + " write data : 클라이언트 = " + 999); 
				
				int i = 0;		
				if(i == 1) {
					break;	 
				}
				Thread.sleep(3000);
			 }
			 
			out.close();
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}





