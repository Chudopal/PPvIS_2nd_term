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
    final FootballerController footballerController;
    final List<Button> listOfAvailableFiles = new ArrayList<>();
    final Stage stage = new Stage();
    final MainWindowHandler handler;

    public ChoseFileWindow(FootballerController footballerController, MainWindowHandler handler){
        double sizeX = 300;
        double sizeY = 500;
        Group root = new Group();
        this.handler = handler;
        footballerController.sendInfo("open");
        VBox vBox = new VBox();
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
            stage.close();
            System.out.println("DDDDD");
            this.handler.getTable().clearTable();
            this.handler.setNumbSide(1);
            this.handler.setNumbOfRecOnSide(5);
            this.handler.setMaxNumbOfSides(this.footballerController.getMaxSideOfPages(this.handler.getNumbOfRecOnSide()));
            this.handler.getTable().getSideOfPage().setText(Integer.toString(this.handler.getNumbSide())+ "/" + this.handler.getMaxNumbOfSides());
            this.handler.getTable().setFootballers(footballerController.getPage(this.handler.getNumbSide(), this.handler.getNumbOfRecOnSide()));
        });
    }
}
