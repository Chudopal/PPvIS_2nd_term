package view;

import controller.FootballerController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveWindow {
    private TextField nameOfFile = new TextField("Write a name of the file");
    private Button save = new Button("save");
    private FootballerController footballerController;

    public SaveWindow(FootballerController footballerController){
        double sizeX = 300;
        double sizeY = 100;
        Stage stage = new Stage();
        Group root = new Group();
        this.footballerController = footballerController;
        save.setMinSize(300,10);

        save.setOnAction((e)->{
            this.footballerController.write(nameOfFile.getText());
        });

        VBox vBox = new VBox();
        vBox.getChildren().setAll(nameOfFile, save);
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        root.setAutoSizeChildren(true);
        root.getChildren().setAll(vBox);
        stage.setScene(new Scene(root, sizeX, sizeY));
        stage.show();
    }
}
