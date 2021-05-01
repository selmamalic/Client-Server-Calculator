package server_s_m;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args) {
       
        try {
              ServerSocket server = new ServerSocket(0); //enter port number
                while(true)
                    {
                        System.out.println("Server is listening.....");
                        Socket soc = server.accept(); 
                        Server sm = new Server(soc);
                    }
            } 
        catch (IOException ex) 
            {
                System.out.println(ex);
            }
    }
    
}
