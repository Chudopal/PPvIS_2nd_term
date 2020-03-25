package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FootballerController {

    private ArrayList<Footballer> footballers = new ArrayList<>();

    FootballerController(){}

    public void readFile(File file){
        SAXPar.getSaxPar();
        try {
            SAXPar.getSaxPar().setFile(file);
            footballers.addAll(SAXPar.getSaxPar().getFootballers());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(File file, List<Footballer> footballers){
        DOMParser.getDomParser().createXML(footballers, file);
    }

    public ArrayList<Footballer> getFootballers(){return footballers;}
}
