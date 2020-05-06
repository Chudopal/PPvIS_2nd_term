package server;

import controller.FootballerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private FootballerController footballerController;
    public Server(FootballerController footballerController) throws IOException {
        this.footballerController = footballerController;
        this.makeServer();
    }

    public void makeServer() throws  IOException{
        try {
            int numbOfThread = 1;
            ServerSocket s = new ServerSocket(8000);
            while (true) {

                Socket incoming = s.accept();
                System.out.println("Spawning " + numbOfThread);
                Runnable r = new ThreadedEchoHandler(incoming, footballerController);
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
