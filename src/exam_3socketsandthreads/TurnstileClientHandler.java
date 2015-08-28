/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_3socketsandthreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurnstileClientHandler extends Thread
{
    TurnstileCounter tc;
    TurnstileServer ts;
    BufferedReader in;
    PrintWriter out;
    
    public TurnstileClientHandler(Socket socket, TurnstileServer s, TurnstileCounter c) throws IOException
    {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.ts = s;
        this.tc = c;
    }
    
    @Override
    public void run()
    {
        String input = "";
        try {
            input = in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(TurnstileClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String returnMessage = clientCommand(input);
        out.println(returnMessage);
    }
    
    private String clientCommand(String msg)
    {
        String splitter = "[#]";
        String[] tokens = msg.split(splitter);
        
        if(tokens.length < 2)
        {
            return "FAIL";
        }
        
        String turnstileID = tokens[0].toUpperCase();
        String turnstileCommand = tokens[1];
        
        switch (turnstileCommand)
        {
            case "INCREMENT":
                return "INCREMENT REGISTERED";
            case "TOTAL":
                String returnMessage = "" + tc.getTotalAmount();
                return returnMessage;
            default:
                return "FAIL";
        }
    }
}
