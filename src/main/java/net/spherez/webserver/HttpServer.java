package net.spherez.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(Constants.SERVER_PORT);
            System.out.println("Server is ready (port:" + Constants.SERVER_PORT + ")");
        } catch (IOException e) {
            System.out.println("Error on server starting : " + e.getCause());
            e.printStackTrace();
        }

        boolean shutdown = false;
        Socket socket = null;
        InputStream input = null;
        OutputStream output = null;
        while (!shutdown) {
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();

                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();

                socket.close();
                shutdown = request.getUri().equals(Constants.SHUTDOWN_COMMAND);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
