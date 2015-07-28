package net.spherez.socket;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private final static int SERVER_PORT = 5674;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Error on server starting : " + e.getCause());
        }

        while (true) {
            try {
                System.out.println("Ready to request...");

                Socket socket = serverSocket.accept();
                System.out.println("Request from : " + socket.getInetAddress());

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("Hello world!");
                dos.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
