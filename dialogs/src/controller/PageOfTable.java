package controller;

import model.Footballer;

import java.util.ArrayList;
import java.util.List;

public class PageOfTable {

    private ArrayList<Footballer> footballers;

    public PageOfTable(ArrayList<Footballer> footballers){
        this.footballers = footballers;
    }

    public List<Footballer> getCurrentSide(int currentSide, int numbOfRecOnOneSide){
        try {
            return footballers.subList((currentSide - 1) * numbOfRecOnOneSide, currentSide * numbOfRecOnOneSide);
        }catch (Exception e){
            return footballers.subList((currentSide - 1) * numbOfRecOnOneSide, footballers.size());
        }
    }

    public int getMaxPage(int numbOfRecOnOneSide){
        return footballers.size()/numbOfRecOnOneSide + 1;
    }

}
