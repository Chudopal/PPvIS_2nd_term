package controller;

import model.Footballer;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Class for controlling interaction of footballers and
 * table.
 */
public class FootballerController implements FootballerControllerInterface {

    private List<Footballer> footballers = new ArrayList<>();
    private PageOfTable pageOfTable;

    public FootballerController(){}

    /** This method allows read information from xml-file.
     * @param file - file for save
     */
    public void readFile(File file){
        SAXPar.getSaxPar();
        try {
            SAXPar.getSaxPar().setFile(file);
            footballers.clear();
            footballers.addAll(SAXPar.getSaxPar().getFootballers());
        } catch (Exception e){
            e.printStackTrace();
        }
        this.pageOfTable = new PageOfTable(footballers);
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
        DOMParser.getDomParser().createXML(footballers, file);
    }

    public List<Footballer> getFootballers(){return footballers;}

    /** The method allows to delete records in list of footballers
     * @param line - the object witch need to delete.
     */
    public void delete(String line){
        Footballer footballer = makeFootballerFromString(line);
        int i = 0;
        for(Footballer footballer1: footballers){
            if(footballer1.equal(footballer)){
                footballers.remove(i);
                break;
            }
            i++;
        }
    }

    /** The method allows to add exemplars to list of footballers
     * @param line - the object, witch need to add.
     */
    private Footballer makeFootballerFromString(String line){
        ArrayList<String> properties = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            String buff = line.substring(
                    line.indexOf("{"),
                    line.indexOf("}") + 1);
            line = line.substring(line.indexOf("}") + 1, line.length());
            buff = buff.substring(1, buff.length() - 1);
            properties.add(buff);
        }
        return new Footballer(
                properties.get(0),
                properties.get(1),
                properties.get(2),
                LocalDate.parse(properties.get(3)),
                properties.get(4),
                properties.get(5),
                properties.get(6),
                properties.get(7)
        );
    }

    public void add(String line)
    {
        footballers.add(
                makeFootballerFromString(line)
        );
    }
}
