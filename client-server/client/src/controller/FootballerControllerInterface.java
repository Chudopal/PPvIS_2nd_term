package controller;

import model.Footballer;

import java.io.IOException;
import java.util.List;

public interface FootballerControllerInterface {
    void sendInfo(String info);
    public void createSocket() throws IOException;
    List<String> getInformationFromServer();
    List<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide) throws IOException;
    int getMaxSideOfPages(int numbOfRecOnOneSide);
    void write(String file);
    List<Footballer> find(String line);
    List<Footballer> getFootballers();
    void add(Footballer footballer);
}
