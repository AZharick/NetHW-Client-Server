import java.io.*;
import java.net.Socket;

public class Client {

   public static void main(String[] args) throws IOException {
      Socket socket = new Socket("127.0.0.1", 8080);
      System.out.println("Connected!");

      OutputStream outputStream = socket.getOutputStream();
      DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

      System.out.println("Sending string to Server");

      dataOutputStream.writeUTF("Hello from the Client!");
      dataOutputStream.flush();
      dataOutputStream.close();

      System.out.println("Closing socket");
      socket.close();
   }
}