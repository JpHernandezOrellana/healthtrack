import java.net.*;
import java.io.*;

public class MiniServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4567);
        System.out.println("Servidor básico en puerto 4567...");

        while (true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain");
            out.println();
            out.println("Servidor básico funcionando");
            out.close();
            client.close();
        }
    }
}

