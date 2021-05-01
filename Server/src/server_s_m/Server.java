package server_s_m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Server {
    
    Socket soc;
    
    public Server(Socket soc)
        {
           this.soc = soc;
           try
            {
                InputStream is = soc.getInputStream();
                OutputStream os = soc.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                os.write("Welcome to my little calculator <3 \r\n ".getBytes());

                System.out.println(br.readLine());

                os.write("Type the operants that you want to add: \r\n".getBytes());
                     
               try
                {
                    while(true)
                      {
                        int num1 = Integer.parseInt(br.readLine());
                        int num2 = Integer.parseInt(br.readLine());

                        String result = String.valueOf(num1+num2);
                        os.write((result+"\r\n").getBytes());
                      }
               }
               catch(NumberFormatException nfe)
               {
                   System.out.println(nfe);
               }
                
            }
            catch(IOException ie)
                {
                   System.out.println(ie);
                }   
        } 
}
