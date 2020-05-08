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
    private PageOfTable pageOfTable;
    private Socket socket;
    OutputStream outStream;
    PrintWriter out;
    InputStream inStream;
    Scanner in;


    public FootballerController() throws IOException{
        this.socket = new Socket("localhost", 8000);
        this.outStream = this.socket.getOutputStream();
        this.out = new PrintWriter(this.outStream, true);
        this.inStream = this.socket.getInputStream();
        this.in = new Scanner(this.inStream);
    }

    public void sendInfo(String info){
        this.out.println(info);
    }

    public List<String> getInformationFromServer(){
        ArrayList<String> listOfPaths = new ArrayList<>();

        while (in.hasNextLine())
        {
            String line = in.nextLine();
            if(line.equals("all")){
                return listOfPaths;
            }
            System.out.println(line);
            listOfPaths.add(line);
        }
        return listOfPaths;
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
        return Integer.parseInt(this.getInformationFromServer().get(0));
    }

    /** This method allows to write information to the xml-file
     * @param file - file for writing
     * @param footballers - list of footballers
     */
    public void write(File file, List<Footballer> footballers){
    }

    public List<Footballer> getFootballers(){return footballers;}

    /** The method allows to delete records in list of footballers
     * @param footballer - the object witch need to delete.
     */
    public void delete(Footballer footballer){
        int i = 0;
        for(Footballer footballer1: footballers){
            i++;
            if(footballer1.equal(footballer)){
                footballers.remove(i);
                break;
            }
        }
    }

    /** The method allows to add exemplars to list of footballers
     * @param footballer - the object, witch need to add.
     */
    public void add(Footballer footballer){
        sendInfo("add");
        sendInfo(makeStringFromFootballer(footballer));
    }
}
