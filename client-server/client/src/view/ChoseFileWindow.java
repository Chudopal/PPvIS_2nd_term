package view;

import controller.FootballerController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChoseFileWindow {
    private Group root = new Group();
    private double sizeX = 300;
    private double sizeY = 500;
    private FootballerController footballerController;
    private List<Button> listOfAvailableFiles = new ArrayList<>();

    public ChoseFileWindow(FootballerController footballerController){
        footballerController.sendInfo("open");
        VBox vBox = new VBox();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, sizeX, sizeY));
        stage.show();
        this.footballerController = footballerController;
        for (String path: footballerController.getInformationFromServer()) {
            listOfAvailableFiles.add(new Button(path));
            this.customise(listOfAvailableFiles.get(listOfAvailableFiles.size()-1),
                    listOfAvailableFiles.size()-1);
        }

        vBox.getChildren().setAll(listOfAvailableFiles);
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.BOTTOM_CENTER);
        root.setAutoSizeChildren(true);
        root.getChildren().setAll(vBox);
    }

    public void customise(Button button, int index){
        button.setMinSize(300,10);
        button.setOnAction(e->{
            footballerController.sendInfo("filename");
            footballerController.sendInfo(button.getText());
            footballerController.getPage(1,5);
        });
    }
}
