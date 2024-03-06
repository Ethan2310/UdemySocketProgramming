import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Waiting for client");
        Socket sock = serverSocket.accept();
        System.out.println("Client connected");
        InputStream in =  sock.getInputStream();
        OutputStream out =  sock.getOutputStream();
        byte buffer[] = new byte[1024];

        in.read(buffer);

        System.out.println("From client" + new String(buffer).trim());

        out.write("Hello from server".getBytes());

        sock.close();
        serverSocket.close();
    }
}
