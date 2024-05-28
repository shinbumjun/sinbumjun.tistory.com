package test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip = "127.0.0.1";
		int port = 5000;
		// TODO Auto-generated method stub
		//1.
		Socket client = new Socket(ip, port);
		System.out.println("Server connect Client port11111111111 : " + client.getLocalPort());
		System.out.println("Server connect Server IP : " + client.getInetAddress());
		System.out.println("Server connect Server port : " + client.getPort());
		//2. 
		OutputStream out = client.getOutputStream();
		InputStream in = client.getInputStream();
		out.write('C');
		out.close();
//		PrintWriter pw = new PrintWriter(out);
//		Scanner scan = new Scanner(in);
//		//4. 
//		String data = "Client MSG : start";
//		pw.print(data);
//		System.out.println(scan.next());
//		//5. 
//		//7. 
//		pw.close();
//		scan.close();
//		client.close();
	}

}




