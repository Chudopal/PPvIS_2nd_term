package controller;

import model.Footballer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FootballerControllerInterface {
    void read() throws IOException;
    List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide);
    int getMaxSideOfPages(int numbOfRecOnOneSide);
    void writeFile(File file, List<Footballer> footballers);
    List<Footballer> getFootballers();
    void add(Footballer footballer);
}
