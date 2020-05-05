package controller;

import model.Footballer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Class for controlling interaction of footballers and
 * table.
 */
public class FootballerController implements FootballerControllerInterface {

    private List<Footballer> footballers = new ArrayList<>();
    private PageOfTable pageOfTable;

    public FootballerController(){}

    public void read() throws IOException {
        try(Socket s = new Socket("localhost", 8000)){
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }

    /** This method return current page of list
     * @param numberOfSide  - number of current page,
     * @param numbOfRecOnOneSide - user can choice numb of rec
     * @return records on the current page.
     */
    public List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide){
        return new ArrayList<Footballer>(pageOfTable.getCurrentSide(numberOfSide, numbOfRecOnOneSide));
    }

    /**
     * @param numbOfRecOnOneSide - the numb of rec on one page
     * @return the max number of page in table.
     */
    public int getMaxSideOfPages(int numbOfRecOnOneSide){
        return pageOfTable.getMaxPage(numbOfRecOnOneSide);
    }

    /** This method allows to write information to the xml-file
     * @param file - file for writing
     * @param footballers - list of footballers
     */
    public void writeFile(File file, List<Footballer> footballers){
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
        this.footballers.add(footballer);
    }
}
