package ch25;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ConcurrentFileServerApp {

    private static final int PORT = 60666;

    public static void main(String[] args) {
        try (ServerSocket servFd = new ServerSocket()) {
            servFd.bind(new InetSocketAddress("127.0.0.1", PORT));
            System.out.println("File Sever has started ...");

            while (true) {
                Socket connectedFd = servFd.accept();
                Thread socketThread = new Thread(new ConcurrentFileServer(connectedFd));
                socketThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
