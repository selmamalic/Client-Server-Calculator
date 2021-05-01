package Client;

import java.io.IOException;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args){
        
        try {
              Socket socket = new Socket(" ", 0); //String host, int port
                
              CalculatorFrame frame = new CalculatorFrame(socket);
     
            } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
    }
}
        
    

