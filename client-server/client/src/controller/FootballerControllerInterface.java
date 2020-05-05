package controller;

import model.Footballer;

import java.io.File;
import java.util.List;

public interface FootballerControllerInterface {
    void readFile(File file);
    List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide);
    int getMaxSideOfPages(int numbOfRecOnOneSide);
    void writeFile(File file, List<Footballer> footballers);
    List<Footballer> getFootballers();
    void add(Footballer footballer);
}
