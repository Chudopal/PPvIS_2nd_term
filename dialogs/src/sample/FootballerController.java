package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FootballerController implements FootballerControllerInterface {

    private ArrayList<Footballer> footballers = new ArrayList<>();
    private PageOfTable pageOfTable;

    FootballerController(){}

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

    public ArrayList<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide){
        return new ArrayList<Footballer>(pageOfTable.getCurrentSide(numberOfSide, numbOfRecOnOneSide));
    }

    public int getMaxSideOfPages(int numbOfRecOnOneSide){
        return pageOfTable.getMaxPage(numbOfRecOnOneSide);
    }

    public void writeFile(File file, List<Footballer> footballers){
        DOMParser.getDomParser().createXML(footballers, file);
    }

    public ArrayList<Footballer> getFootballers(){return footballers;}

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

    public void add(Footballer footballer){
        this.footballers.add(footballer);
    }
}
