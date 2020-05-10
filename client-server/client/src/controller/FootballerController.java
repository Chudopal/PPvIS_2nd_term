package controller;

import model.Footballer;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Class for controlling interaction of footballers and
 * table.
 */
public class FootballerController implements FootballerControllerInterface {

    private List<Footballer> footballers = new ArrayList<>();
    private Socket socket;
    OutputStream outStream;
    PrintWriter out;
    InputStream inStream;
    Scanner in;
    private int numbOfStrFromServer = 0;
    private String host = "localhost";
    private int port = 8000;

    public FootballerController(){
        this.createSocket();
    }

    public void setHost(String host, int port ){
        this.host = host;
        this.port = port;
        try{
            this.createSocket();
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }

    public void createSocket(){
        try {
            this.socket = new Socket(host, port);
            this.outStream = this.socket.getOutputStream();
            this.out = new PrintWriter(this.outStream, true);
            this.inStream = this.socket.getInputStream();
            this.in = new Scanner(this.inStream);
        }
        catch(Exception exp){
            System.out.println("Server stops");
        }
    }

    public void sendInfo(String info){
        System.out.println(info);
        this.out.println(info);
    }

    public List<String> getInformationFromServer(){
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNextLine())
        {
            System.out.println("HERE");
            String line = in.nextLine();
            if(line.equals("all")){
                for (String str: list) {
                    System.out.println(str);
                }
                return list;
            }
            list.add(line);
        }
        return list;
    }


    /** This method return current page of list
     * @param numberOfSide  - number of current page,
     * @param numbOfRecOnOneSide - user can choice numb of rec
     * @return records on the current page.
     */
    public List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide){
        this.sendInfo("numberOfRecords");
        this.sendInfo(Integer.toString(numbOfRecOnOneSide));

        this.sendInfo(Integer.toString(numberOfSide));

        return this.makeFootballerFromString(this.getInformationFromServer());
    }

    private String makeStringFromFootballer(Footballer footballer){
        return ("{" + footballer.getSurName() + "} {" + footballer.getFirstName() + "} {" + footballer.getMiddleName() + "} {" +
                footballer.getBirthDate() + "} {" + footballer.getTeam() + "} {" + footballer.getHomeCity() + "} {" +
                footballer.getCommandStructure() + "} {" + footballer.getPosition() + "}");
    }

    private List<Footballer> makeFootballerFromString(List<String> footballersInString){
        ArrayList<Footballer> footballers = new ArrayList<>();

        for(String footballerInString: footballersInString){
            ArrayList<String> properties = new ArrayList<>();
            for(int i = 0; i < 8; i++) {
                String buff = footballerInString.substring(
                            footballerInString.indexOf("{"),
                            footballerInString.indexOf("}") + 1);
                footballerInString = footballerInString.substring(footballerInString.indexOf("}") + 1, footballerInString.length());
                buff = buff.substring(1, buff.length() - 1);
                properties.add(buff);
            }
            footballers.add(
              new Footballer(
                      properties.get(0),
                      properties.get(1),
                      properties.get(2),
                      LocalDate.parse(properties.get(3)),
                      properties.get(4),
                      properties.get(5),
                      properties.get(6),
                      properties.get(7)
              )
            );
        }
        return footballers;
    }

    /**
     * @param numbOfRecOnOneSide - the numb of rec on one page
     * @return the max number of page in table.
     */
    public int getMaxSideOfPages(int numbOfRecOnOneSide){
        this.sendInfo("getMaxSizeOfPages");

        return Integer.parseInt(getInformationFromServer().get(0));
    }

    /** This method allows to write information to the xml-file
     * @param file - file for writing
     */
    public void write(String file){
        sendInfo("save");
        sendInfo(".//examples//" + file + ".xml");
    }

    public List<Footballer> getFootballers(){return footballers;}

    /** The method allows to delete records in list of footballers
     * @param footballer - the object witch need to delete.
     */
    public void delete(Footballer footballer){
        sendInfo("delete");
        sendInfo(makeStringFromFootballer(footballer));
    }

    /** The method allows to add exemplars to list of footballers
     * @param footballer - the object, witch need to add.
     */
    public void add(Footballer footballer){
        sendInfo("add");
        sendInfo(makeStringFromFootballer(footballer));
    }

    public List<Footballer> find(String line){
        ArrayList<Footballer> footballers;
        sendInfo("find");
        sendInfo(line);
        return this.makeFootballerFromString(this.getInformationFromServer());
    }
}
