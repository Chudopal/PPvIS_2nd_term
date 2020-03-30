package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteWindow {
    DeleteWindow(double sizeX, double sizeY){
        Stage stage = new Stage();
        Group root = new Group();
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
}
