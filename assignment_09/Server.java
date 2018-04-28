package assignment_09;

import java.io.*;
import java.net.*;

public class Server extends Thread {
    private ServerSocket ssoc;
    private int port;

    Server(int _port){
        try{
            port = _port;
            ssoc = new ServerSocket(port);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
            try{
                System.out.println("Server waiting for connection in port : " + port + ".");
                Socket s = ssoc.accept();
                System.out.println("User Connected");
                saveFile(s);
            }catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    private void saveFile(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(socket.getInputStream());
        FileOutputStream output  = new FileOutputStream("Katakuri1.png");
        byte[] buffer = new byte[4096];

        int fileSize = 15000;
        int read = 0;
        int remaining = fileSize;

        while((read = input.read(buffer, 0, Math.min(remaining, buffer.length))) > 0){
            remaining -= read;
            output.write(buffer, 0, read);
        }

        input.close();
        output.close();
    }
}