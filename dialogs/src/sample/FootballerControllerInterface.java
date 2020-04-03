package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface FootballerControllerInterface {
    void readFile(File file);
    ArrayList<Footballer> getPage(int numberOfSide, int numbOfRecOnOneSide);
    int getMaxSideOfPages(int numbOfRecOnOneSide);
    void writeFile(File file, List<Footballer> footballers);
    ArrayList<Footballer> getFootballers();
    void add(Footballer footballer);
}
