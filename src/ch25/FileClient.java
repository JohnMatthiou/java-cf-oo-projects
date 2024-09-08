package ch25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    public static void main(String[] args) {

        Socket socket = null;

        try (Scanner in = new Scanner(System.in)) {
            InetAddress servAddress = InetAddress.getByName("127.0.0.1");
            final int SERV_PORT = 60666;

            socket = new Socket(servAddress, SERV_PORT);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fileRequest = "";
            String serverResponse = "";

            System.out.println("Give a valid file path to view contents of file");
            fileRequest = in.nextLine();
            pw.println(fileRequest);
            pw.flush();

            System.out.println("Response from Server:");
            while ((serverResponse = br.readLine()) != null) {
                System.out.println(serverResponse);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

