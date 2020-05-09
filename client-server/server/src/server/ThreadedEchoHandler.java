package server;

import controller.FootballerController;
import model.Footballer;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    final Socket incoming;
    final FootballerController footballerController;
    private int numbOfRectOnOneSide = 5;
    private boolean choseFile = false;
    private boolean delData = false;
    private boolean addData = false;
    private boolean numbOfRec = false;
    private boolean findData = false;
    private boolean saveData = false;

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
        if(choseFile || delData || addData || numbOfRec || findData || saveData){
            if(choseFile){
                File file = new File(line);
                footballerController.readFile(file);
                choseFile = false;
            }
            if(saveData){
                saveData = false;
                footballerController.writeFile(line);
            }
            if (delData) {
                footballerController.delete(line);
                delData = false;
            }
            if (addData) {
                addData = false;
                footballerController.add(line);
            }
            if (numbOfRec) {
                numbOfRec = false;
                numbOfRectOnOneSide = Integer.parseInt(line);
            }
            if (findData) {
                findData = false;
                for (Footballer footballer : footballerController.find(line)) {
                    out.println("{" + footballer.getSurName() + "} {" + footballer.getFirstName() + "} {" + footballer.getMiddleName() + "} {" +
                            footballer.getBirthDate() + "} {" + footballer.getTeam() + "} {" + footballer.getHomeCity() + "} {" +
                            footballer.getCommandStructure() + "} {" + footballer.getPosition() + "}");
                }
                out.println("all");
            }
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
                    out.println("all");
                    break;
                case "filename":
                    choseFile = true;
                    break;
                case "save":
                    saveData = true;
                    break;
                case "delete":
                    delData = true;
                    break;
                case "find":
                    findData = true;
                    break;
                case "numberOfRecords":
                    numbOfRec = true;
                    break;
                case "add":
                    addData = true;
                    break;
                case "getMaxSizeOfPages":
                    System.out.println("HERE");
                    out.println(footballerController.getMaxSideOfPages(numbOfRectOnOneSide));
                    out.println("all");
                    break;
                default:
                    try {
                        for (Footballer footballer : footballerController.getPage(Integer.parseInt(line), numbOfRectOnOneSide)) {
                            out.println("{" + footballer.getSurName() + "} {" + footballer.getFirstName() + "} {" + footballer.getMiddleName() + "} {" +
                                    footballer.getBirthDate() + "} {" + footballer.getTeam() + "} {" + footballer.getHomeCity() + "} {" +
                                    footballer.getCommandStructure() + "} {" + footballer.getPosition() + "}");
                        }
                        out.println("all");
                    } catch (NumberFormatException e) {
                        System.out.println("it is not a number");
                    }
                }
            }
        }
    }

