package server;

import controller.FootballerController;
import model.Footballer;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;
    private FootballerController footballerController;
    private boolean choseFile = false;
    private boolean delData = false;


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

                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.trim().equals("BYE"))
                        done = true;
                    else {
                        this.listener(line, out);
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

    public void listener(String line, PrintWriter out){
        if(choseFile){
            System.out.println("here");
            File file = new File(line);
            footballerController.readFile(file);
            choseFile = false;
        }
            else{
        if(delData){
            delData = false;
        }
        else {
            switch (line) {
                case "open":
                    File dir = new File(".//examples");
                    File[] arrFiles = dir.listFiles();
                    List<File> lst = Arrays.asList(arrFiles);
                    for (File file : lst) {
                        out.println(file.toString());
                    }
                    break;
                case "filename":
                    choseFile = true;
                    break;
                case "save":
                    break;
                case "delete":
                    delData = true;
                    break;
                default:
                    try {
                        for (Footballer footballer : footballerController.getPage(Integer.parseInt(line), 10)) {
                            out.println("{" + footballer.getSurName() + "} {" + footballer.getFirstName() + "} {" + footballer.getMiddleName() + "} {" +
                                    footballer.getBirthDate() + "} {" + footballer.getTeam() + "} {" + footballer.getHomeCity() + "} {" +
                                    footballer.getCommandStructure() + "} {" + footballer.getPosition() + "}");
                        }
                    } catch (NumberFormatException e) {
                        out.println("It is not a number");
                    }
                }
            }
        }
    }
}
