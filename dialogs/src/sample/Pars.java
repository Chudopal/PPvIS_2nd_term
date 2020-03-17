package sample;

import java.util.ArrayList;

public class Pars {

    private String name;
    private ArrayList <Footballer> footballers;


    Pars(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){return name;}

    public ArrayList <Footballer> readFile(){
        try {
            SAXPar saxPar = new SAXPar(this.name);
            footballers.addAll(saxPar.getFootballers());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return footballers;
    }

    public void writeIntoFile(ArrayList <Footballer> footballers){
        DOMParser domParser = new DOMParser(footballers, this.name);
    }
}
