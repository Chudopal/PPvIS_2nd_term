package server;

import controller.FootballerController;
import model.Footballer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;
    private FootballerController footballerController;
    /**
     * Конструирует обработчик
     * @param currentSocket Входящий сокет
     */

    public ThreadedEchoHandler(Socket currentSocket, FootballerController footballerController) {
        this.footballerController = footballerController;
        this.incoming = currentSocket;
    }
    public void run() {
        try {
            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);
                // автоматическая очистка
                /*for (Footballer footballer: footballerController.getPage(1,10)) {
                    out.println(footballer.getSurName());
                }*/
                //out.println("Hello! Enter BYE to exit.");
                // передать обратно данные, полученные от клиента
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    //out.println("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                    else {
                        try{
                            for (Footballer footballer : footballerController.getPage(Integer.parseInt(line), 10)) {
                                out.println("{" + footballer.getSurName() + "} {" + footballer.getFirstName() + "} {" + footballer.getMiddleName() + "} {" +
                                            footballer.getBirthDate() + "} {" + footballer.getTeam() + "} {" + footballer.getHomeCity() + "} {" +
                                            footballer.getCommandStructure() + "} {" + footballer.getPosition() + "}");
                            }
                        } catch (NumberFormatException e){
                            out.println("It is not a number");
                        }
                    }
                }
            } finally {
                incoming.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
