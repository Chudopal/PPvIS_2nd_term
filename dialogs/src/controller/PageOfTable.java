package controller;

import model.Footballer;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for each page on the table
 */
public class PageOfTable {

    private ArrayList<Footballer> footballers;

    /** The constructor. There is just an initialisation of
     * main list of footballers.
     * @param footballers - list of footballers.
     */
    public PageOfTable(ArrayList<Footballer> footballers){
        this.footballers = footballers;
    }

    /** The method allows to get current page in table.
     * @param currentSide - numb of page at the moment.
     * @param numbOfRecOnOneSide - numb of rec on one side,
     * @return list of footballers on one page.
     */
    public List<Footballer> getCurrentSide(int currentSide, int numbOfRecOnOneSide){
        try {
            return footballers.subList((currentSide - 1) * numbOfRecOnOneSide, currentSide * numbOfRecOnOneSide);
        }catch (Exception e){
            return footballers.subList((currentSide - 1) * numbOfRecOnOneSide, footballers.size());
        }
    }

    /** Allows to get max numb of page un the table.
     * @param numbOfRecOnOneSide - the recs in one page,
     * @return max numb of page.
     */
    public int getMaxPage(int numbOfRecOnOneSide){
        return footballers.size()/numbOfRecOnOneSide + 1;
    }

}
