package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddWindow {
    AddWindow(double sizeX, double sizeY){
        Stage stage = new Stage();
        Group root = new Group();
        stage.setScene(new Scene(root, sizeX, sizeY));
        stage.show();
    }
}
