import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 */

/**
 * @date 下午5:38:05
 */
public class TCPServer {

	int port = 8888;
	String saveFilePath = "save";

	public TCPServer() {

	}

	public void start() {
		System.out.println("Tcp Server starting...");
		ServerSocket ssServerSocket = null;
		try {
			ssServerSocket = new ServerSocket(port);
			System.out.println("Server has bind to IP:"
					+ ssServerSocket.getInetAddress().getHostAddress()
					+ ",port:" + port);
		} catch (IOException e) {
			System.out.println("Start Server failed,error message:"
					+ e.getMessage());
			e.printStackTrace();
		}
		Socket skt = null;
		FileOutputStream foStream = null;
		DataInputStream inputStream = null;
		byte[] inputByte = null;
		while (true) {// 循环接收文件
			long fileSize = 0;
			try {
				skt = ssServerSocket.accept();
				long startTime = System.nanoTime();
				String fileNameString = saveFilePath + "_" + startTime;
				System.out.println("----------------------begin------------------------");
				System.out.println("Ready to Receiver data, start time:"
						+ startTime);
				System.out.println("Save file to:" + (new File(fileNameString)).getAbsolutePath());
				foStream = new FileOutputStream(fileNameString);
				inputStream = new DataInputStream(skt.getInputStream());
				inputByte = new byte[1024];
				System.out.println("开始接收数据...");
				int length = 0;
				while ((length = inputStream.read(inputByte, 0, inputByte.length)) > 0) {
					fileSize += length;
					foStream.write(inputByte, 0, length);
					foStream.flush();
				}
				long endTime = System.nanoTime();
				System.out.println("Receive finished.end time:"+endTime);
				long time = (endTime - startTime)/1000/1000;
				System.out.println(String.format("FileSize:" + fileSize + "B, time:"+ time +"ms, speed:"+ fileSize/time +"KB/s"));
				System.out.println("---------------------end---------------------------");
			} catch (IOException e) {
				System.out.println("IO error");
				e.printStackTrace();
			} finally {
				if (skt != null) {
					try {
						skt.close();
					} catch (IOException e) {
						System.out.println("Close error.");
					}
				}
				if (foStream != null) {
					try {
						foStream.close();
					} catch (IOException e) {
						System.out.println("Close error.");
					}
				}
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						System.out.println("Close error.");
					}
				}

			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TCPServer svr = new TCPServer();
		svr.start();
	}

}
