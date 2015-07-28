package net.spherez.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

    private final static int SERVER_PORT = 5674;

    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        System.out.println("Connect to server : " + serverIp);

        try {
            Socket socket = new Socket(serverIp, SERVER_PORT);
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("Respond from server : " + dis.readUTF());

            dis.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
