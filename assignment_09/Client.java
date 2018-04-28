package assignment_09;

import java.io.*;
import java.net.*;

public class Client {
    private Socket s;

    Client(String host, int port, String file){
        try{
            s = new Socket(host, port);
            sendFile(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {
        DataOutputStream output = new DataOutputStream(s.getOutputStream());
        FileInputStream input = new FileInputStream(file);
        byte[] buffer = new byte[4096];

        while(input.read(buffer) > 0){
            output.write(buffer);
        }

        input.close();
        output.close();
    }
}
