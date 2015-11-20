import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	private int port = 8888;
	private String IP = "127.0.0.1";
	private String filePath = "test";

	public TCPClient() {

	}

	public TCPClient(String ip, int port) {
		this.port = port;
		this.IP = ip;
	}

	public void send(String filePath) {
		this.filePath = filePath;
		Socket skt = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(this.filePath);
		} catch (FileNotFoundException e1) {
			System.out.println("读取文件失败，错误：" + e1.getMessage());
			System.exit(1);
		}
		try {
			System.out.println("准备打开端口进行传输.");
			long startTime = System.nanoTime();
			skt = new Socket(IP, port);
			long midTime = System.nanoTime();
			System.out.println("端口已打开，耗时：" + (System.nanoTime() - startTime));
			dos = new DataOutputStream(skt.getOutputStream());
			int length = 0;
			while ((length = fis.read(buffer, 0, buffer.length)) > 0) {
				dos.write(buffer, 0, length);
				dos.flush();
			}
			System.out.println("文件发送完毕。总耗时：" + (System.nanoTime() - startTime));
			System.out.println("传输耗时：" + (System.nanoTime() - midTime)/1000/1000 + "ms");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (skt != null) {
				try {
					skt.close();
				} catch (IOException e) {
					System.out.println("Close error.");
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("Close error.");
				}
			}
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					System.out.println("Close error.");
				}
			}
		}
	}

	public static void main(String[] args) {
		TCPClient client = new TCPClient();
		client.send("/Users/lz/Downloads/sogou_mac_32.dmg");
	}

}
