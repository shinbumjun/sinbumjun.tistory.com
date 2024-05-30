package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * <pre>
 * Socket 서버 프로그램 제작
 * @author 신범준
 * 1. ServerSocket 생성
 * 1-1. ServerSocket server = new S(5555);
 * 2. bind() : 50, 1번단계에서 내부적으로 수행
 * 3. accept() : Socket(서비스 소켓) 
 *     <- 클라이언트의 new Socket()에 의해 만들어짐, 서비스 소켓은 해당 클라이언트 소켓에 의존, 국한되어 서비스한다.
 * 3-1. Socket service = server.accept();
 * 4. 3번의 객체에서 InputStream/OutputStream을 얻어옴.
 * 4-1. In in = service.getI; Out out = service.getOut
 * 5. input-> read(), output-> write()
 * 5-1. in.read();  out.write();
 * 6. close() < 서비스 소켓
 * 6-1. service.close();
 * 7. close() <- ServerSocket - 일반적으로는 7번은 수행하지 않아도 된다.
 * 7-1. server.close();
 * </pre>
 */
public class TestSocket {

	static String data = "";
	public static void main(String[] args) throws IOException {
		
		 // 1. 서버 소켓 생성 및 시작 : 포트 5555, 클라이언트의 연결을 대기, ServerSocket 객체를 생성하고 시작
		 ServerSocket server = new ServerSocket(5555); 
		 System.out.println("Socket Server (5555) started...!");
		 final ArrayList<OutputStream> outs = new ArrayList();
		 
		 // 2. 클라이언트 연결 수락 : 서버는 무한 루프를 돌며 클라이언트의 연결을 기다림
		 while(true) 
		 {
			// 클라이언트가 연결을 시도 accept() 메서드 호출 Socket 객체 반환
			 Socket service = server.accept();
			 
			 // 새로운 Service 객체를 생성
			 System.out.println("Client Connected...! ");
			 System.out.println("Client connect Client IP : " + service.getInetAddress());
			 System.out.println("Client connect Client port : " + service.getPort());
			 
			 // 이를 새로운 스레드에서 실행
			 new Thread(new Service(service, outs)).start();
		 }
		 // 7. close() <- ServerSocket - 일반적으로는 7번은 수행하지 않아도 된다.
		 // 7-1. server.close();
	}
}

// 3. 클라이언트 서비스 처리: 클라이언트로부터 데이터를 읽고 TestSocket.data 변수에 저장 후 데이터는 콘솔에 출력
class Service implements Runnable {

	private Socket service;
	ArrayList<OutputStream> outs;
	
	public Service(Socket service, ArrayList<OutputStream> outs) {
		this.service = service;		
		this.outs = outs;	
	}

	@Override
	public void run() {
		 InputStream in = null;
		 OutputStream out = null;
		 byte[] buffer = new byte[44]; // 채팅프로그램 버퍼 44로 줄임
		try {
			in = service.getInputStream();
			out = service.getOutputStream();
			outs.add(out);
			OutputTarget outputTarget = new OutputTarget(outs);
			Thread outCPU = new Thread(outputTarget);
			outCPU.start();
		 
		}catch (Exception e) {

		}
		 while(true)
		 {
			try {
			 int i = in.read(buffer);
			 TestSocket.data = new String(buffer);
			 System.out.println("read data : 서버 = " + TestSocket.data); // 62159>10
			 if(i == 0)	break;
			} catch (IOException e) {	 
				e.printStackTrace();			
			} 
		 }
		 try {	
			 in.close();  
			 out.close();  
			 service.close();		
		} catch (IOException e) {			
			e.printStackTrace();	
		}
	}
}

// 4. 출력 타겟: 주기적으로 모든 클라이언트에게 데이터를 전송
class OutputTarget implements Runnable{
	ArrayList<OutputStream> outs;
	
	public OutputTarget(ArrayList<OutputStream> outs) {		
		this.outs = outs;	
	}
	
	public void run() {
		try {
			 while(true) {	 
				 for (OutputStream out : outs) {
					out.write(TestSocket.data.getBytes());
					out.flush();
				}
				System.out.println("write data : 서버 -> 모든 클라이언트에게 데이터를 전송 = " + TestSocket.data);
				int i = 0;			
				if(i == 1) {
					break;	 
				}
				Thread.sleep(3000);
			 }
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}




