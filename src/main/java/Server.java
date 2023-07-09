import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String[] args) throws IOException {
      try (ServerSocket ss = new ServerSocket(8080)) {
         System.out.println("Server awaiting connections...");

         while (true) {
            try (Socket socket = ss.accept();
                 InputStream inputStream = socket.getInputStream();
                 DataInputStream dataInputStream = new DataInputStream(inputStream)) {
               System.out.println("Connection from " + socket);

               String message = dataInputStream.readUTF();
               System.out.println("The message sent from the socket was: " + message);
            }
         }
      }
   }
}