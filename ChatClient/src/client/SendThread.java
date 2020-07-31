package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SendThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {

		super.run();

		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String sendString;
			
			System.out.print("����� ID�� �Է����ֽʽÿ� : ");
			ChatClient.UserID = tmpbuf.readLine();
			// id �� ���� �Է¹��� ID�� userid�� ����.
			
			
			sendWriter.println("IDhighkrs12345" + ChatClient.UserID);
			sendWriter.flush();
			// id�� ������ ���� �ѹ� ����.			
			while (true) {
				sendString = tmpbuf.readLine();

				if(sendString.equals("exit")) {
					break;
				}
				
				sendWriter.println(sendString);
				sendWriter.flush();
				// ê �����͵��� ����.
			}	
			
			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}