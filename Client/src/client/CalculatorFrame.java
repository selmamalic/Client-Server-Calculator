package Client;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class CalculatorFrame extends Frame{
   
    
    public CalculatorFrame(Socket socket)
    {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            os.write("Connected!\r\n".getBytes());
            
            GridBagLayout gbl = new GridBagLayout();
           
            Frame frame = new Frame();
                  frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent ew)
                        {
                            System.exit(0);
                        }
                    });
                  frame.setLocation(400, 300);
                  frame.setTitle(br.readLine());
                  frame.setLayout(gbl);
                  frame.setForeground(Color.DARK_GRAY);
            
            Label label = new Label(br.readLine());
            label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
            label.setAlignment(Label.CENTER);
            
            TextField num1 = new TextField("", 6);
            
            Label plus = new Label(" + ");
            plus.setFont(new Font("Dialog", Font.PLAIN, 16));
            
            TextField num2 = new TextField("", 6);
            
            TextField result = new TextField("", 6);
            result.setEditable(false);
          
            Button result2 = new Button(" = ");
            result2.addActionListener((ActionEvent e) -> {
                try
                {
                    os.write((num1.getText()+"\r\n").getBytes());
                    os.write((num2.getText()+"\r\n").getBytes());
                    result.setText(br.readLine());
                }
                catch(NumberFormatException | IOException nfe)
                {
                    System.out.println(nfe);
                }
            });
            
            Button reset = new Button("Reset");
            reset.addActionListener((ActionEvent e) -> {
                num1.setText("");
                num2.setText("");
                result.setText("");
            });
                    GridBagConstraints gBc;
                    gBc = new GridBagConstraints();
                    gBc.gridx = 0;
                    gBc.gridy = 0;
                    frame.add(label,gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 1;
                    gBc.gridy = 0;
                    frame.add(num1, gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 2;
                    gBc.gridy = 0;
                    frame.add(plus, gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 3;
                    gBc.gridy = 0;
                    frame.add(num2, gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 5;
                    gBc.gridy = 0;
                    frame.add(result, gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 4;
                    gBc.gridy = 0;
                    gBc.gridheight = 300;
                    frame.add(result2, gBc);
                    gBc = new GridBagConstraints();
                    gBc.gridx = 3;
                    gBc.gridy = 3;
                    gBc.gridheight = 300;
                    frame.add(reset, gBc);
                    
                    frame.setSize(800, 100);
                    frame.setVisible(true);
            
        } catch (IOException ex) {
            System.out.println("ex");
        } 
    }
 }
