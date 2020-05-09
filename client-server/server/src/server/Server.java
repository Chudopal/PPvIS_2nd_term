package server;

import controller.FootballerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket s ;
    private FootballerController footballerController;

    public Server(FootballerController footballerController) throws IOException {
        this.footballerController = footballerController;
        s = new ServerSocket(8000);
        //this.startServer();
    }

    public void startServer() throws  IOException{
        try {
            int numbOfThread = 1;
            while (true) {

                Socket incoming = s.accept();
                System.out.println("Spawning " + numbOfThread);
                Runnable runnable = new ThreadedEchoHandler(incoming, footballerController);
                Thread t = new Thread(runnable);
                t.start();
                numbOfThread++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stopServer() throws IOException{
        System.out.println("HEHEEH");
        s.close();
    }

}
