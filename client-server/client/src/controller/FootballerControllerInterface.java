package controller;

import model.Footballer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FootballerControllerInterface {
    //List<String> getInfoFromServer();
    void sendInfo(String info);
    List<String> getInformationFromServer();
    List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide) throws IOException;
    int getMaxSideOfPages(int numbOfRecOnOneSide);
    void write(File file, List<Footballer> footballers);
    List<Footballer> getFootballers();
    void add(Footballer footballer);
}
