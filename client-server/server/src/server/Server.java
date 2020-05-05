package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() throws IOException {
        this.makeServer();
    }

    void makeServer() throws  IOException{
        try {
            int numbOfThread = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + numbOfThread);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                numbOfThread++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
