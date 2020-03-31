package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

class ChildWindow{

    protected Group root = new Group();
    protected ArrayList<Footballer> footballers = new ArrayList<>();

    ChildWindow(double sizeX, double sizeY, ArrayList<Footballer> footballers){
        this.footballers.addAll(footballers);
        Stage stage = new Stage();
        stage.setScene(new Scene(root, sizeX, sizeY));
        stage.show();
    }

    public ArrayList<Footballer> getFootballers() {
        return footballers;
    }
}
