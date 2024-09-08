package ch25;

import java.io.*;
import java.net.Socket;

public class ConcurrentFileServer implements Runnable {

    private final Socket sockFd;

    public ConcurrentFileServer(Socket sockFd) {
        this.sockFd = sockFd;
    }

    @Override
    public void run() {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(sockFd.getInputStream()));
             PrintWriter pw = new PrintWriter(sockFd.getOutputStream())) {
            String file = br.readLine();

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                StringBuilder sb = new StringBuilder();
                String line = "";

                while ((line = fileReader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                pw.print(sb);
                pw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                pw.println("Error. Could not open file.");
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sockFd != null) sockFd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
