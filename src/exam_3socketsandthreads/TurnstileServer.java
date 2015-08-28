/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_3socketsandthreads;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TurnstileServer
{
    static TurnstileCounter tc = new TurnstileCounter();
    Socket socket;
    
    TurnstileServer(Socket soc, TurnstileCounter t)
    {
        this.socket = soc;
        tc = t;
    }

    private TurnstileServer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void runServer() throws IOException
    {
        String ip = "localhost";
        int port = 4321;
        
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress(ip, port));
        
        while(true)
        {
            TurnstileClientHandler tch = new TurnstileClientHandler(ss.accept(), this, tc);
            tch.start();
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        new TurnstileServer().runServer();
    }
}
