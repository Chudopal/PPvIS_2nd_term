package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

class ChildWindow{

    protected Group root = new Group();

    FootballerController footballerController;

    protected Table table;
    protected TextField surName = new TextField("surname");
    protected TextField firstName = new TextField("first name");
    protected TextField middleName = new TextField("middle name");
    protected DatePicker dateOfBirth = new DatePicker();
    protected TextField team = new TextField("team");
    protected TextField homeCity = new TextField("home city");
    protected TextField structure = new TextField("structure");
    protected TextField position = new TextField("position");

    protected Button button = new Button();


    ChildWindow(double sizeX, double sizeY, FootballerController footballerController){
        this.footballerController = footballerController;
        Stage stage = new Stage();
        stage.setScene(new Scene(root, sizeX, sizeY));
        this.makeLook(sizeX, sizeY);
        stage.show();
    }

    private void makeLook(double sizeX, double sizeY){
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        table = new Table(vBox, sizeX, sizeY);
        table.createTable();

        surName.setMaxSize(     100,30);
        firstName.setMaxSize(   100,30);
        middleName.setMaxSize(  100,30);
        dateOfBirth.setMaxSize( 100,30);
        team.setMaxSize(        100,30);
        homeCity.setMaxSize(    100,30);
        structure.setMaxSize(   100,30);
        position.setMaxSize(    100,30);

        button.setMinSize(300, 50);

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.BOTTOM_CENTER);

        hBox.getChildren().addAll(
            surName, firstName, middleName,
            dateOfBirth, team, homeCity,
            structure, position
        );
        vBox.getChildren().addAll(hBox, button);
        this.root.getChildren().addAll(vBox);

    }

}
