package sample;

import java.util.ArrayList;
import java.util.List;

public class PageOfTable {

    private ArrayList<Footballer> footballers;

    PageOfTable(ArrayList<Footballer> footballers){
        this.footballers = footballers;
    }

    public List<Footballer> getCurrentSide(int currentSide, int numbOfRecOnOneSide){
        return footballers.subList((currentSide-1)*numbOfRecOnOneSide, currentSide*numbOfRecOnOneSide);
    }
}
