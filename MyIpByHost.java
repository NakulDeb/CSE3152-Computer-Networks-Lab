import java.net.*;
import java.net.*;
 
public class MyIpByHost {
 
    public static void main(String a[]){
     
        try {
            InetAddress host = InetAddress.getByName("www.facebook.com");
            System.out.println(host.getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}