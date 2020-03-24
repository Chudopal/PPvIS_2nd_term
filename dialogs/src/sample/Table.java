package sample;


import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class Table {
    TableDisplay tableDisplay;
    private VBox mainBox = new VBox();
    private Button btnLeft = new Button("<");
    private Button btnRight = new Button(">");
    private Button btnBegin = new Button("<<");;
    private Button btnEnd = new Button(">>");
    private ChoiceBox numbOfStr = new ChoiceBox<String>(FXCollections.observableArrayList("5", "10"));;

    Table(Group root, double sizeX, double sizeY){
        mainBox.setSpacing(10);
        tableDisplay = new TableDisplay(this.mainBox, sizeX, sizeY);
        this.createButtons();
        root.getChildren().add(this.mainBox);
    }

    private void createButtons(){
        HBox buttonLayout = new HBox();
        buttonLayout.setSpacing(20);
        buttonLayout.setAlignment(Pos.BASELINE_CENTER);
        buttonLayout.getChildren().addAll(this.btnBegin, this.btnLeft, this.btnRight, this.btnEnd, this.numbOfStr);
        this.mainBox.getChildren().add(buttonLayout);
    }

    public void createTable(){
        tableDisplay.createTable();
    }

    public void clearTable(){
        tableDisplay.clearTable();
    }

    public void setFootballers(ArrayList <Footballer> footballers){
        tableDisplay.setFootballers(footballers);
    }

    public Button getBtnLeft(){return btnLeft;}
    public Button getBtnRight(){return btnRight;}
    public Button getBtnBegin(){return btnBegin;}
    public Button getBtnEnd(){return btnEnd;}
}
