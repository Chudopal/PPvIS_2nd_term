package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddWindow extends ChildWindow {
    AddWindow(double sizeX, double sizeY, ArrayList<Footballer> footballers){
        super(sizeX, sizeY, footballers);
    }
}
