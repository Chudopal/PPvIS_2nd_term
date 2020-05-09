package server;

import controller.FootballerController;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
    private ServerSocket s ;
    private FootballerController footballerController;
    private boolean isRunning = false;
    TextArea text = new TextArea();

    public void addTextArea(TextArea area){
        text = area;
    }

    public Server(FootballerController footballerController) throws IOException {
        this.footballerController = footballerController;

    }

    public void makeTrue(){
        this.isRunning = true;
    }

    public void makeFalse(){
        this.isRunning = false;
    }

    public void runServer(){
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public class MyThread extends Thread{

        public void run (){
            try{startServer();}
            catch (Exception exp){
                exp.printStackTrace();
            }
        }

    public void startServer() throws  IOException{
        try {
            int numbOfThread = 1;
            s = new ServerSocket(8000);
            ArrayList<Socket> sockets = new ArrayList<>();
            while (isRunning) {
                try {
                    Socket incoming = s.accept();
                    sockets.add(incoming);
                    System.out.println("Spawning " + numbOfThread);
                    Runnable runnable = new ThreadedEchoHandler(incoming, footballerController, text);
                    Thread t = new Thread(runnable);
                    t.start();
                    numbOfThread++;
                }
                catch(SocketException se){
                    System.out.println();
                    for (Socket socket: sockets) {
                        socket.close();
                    }
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    }

    public void stopServer() throws IOException{
        s.close();
    }
}
