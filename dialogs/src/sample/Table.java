package sample;


import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.util.ArrayList;


public class Table {
    TableDisplay tableDisplay;
    private VBox mainBox = new VBox();
    private Label sideOfPage = new Label("1");
    private Button btnLeft = new Button("<");
    private Button btnRight = new Button(">");
    private Button btnBegin = new Button("<<");;
    private Button btnEnd = new Button(">>");
    private ChoiceBox numbOfStr = new ChoiceBox<String>(FXCollections.observableArrayList("5", "10"));
    private Button btnOpen = new Button("Open");

    Table(VBox root, double sizeX, double sizeY){
        tableDisplay = new TableDisplay(this.mainBox, sizeX, sizeY);
        this.createButtons();
        root.getChildren().add(this.mainBox);
    }

    private void createButtons(){
        HBox buttonLayout = new HBox();
        buttonLayout.setSpacing(20);
        buttonLayout.setAlignment(Pos.BASELINE_CENTER);
        buttonLayout.getChildren().addAll(this.btnOpen,
                this.btnBegin,
                this.btnLeft,
                this.sideOfPage,
                this.btnRight,
                this.btnEnd,
                this.numbOfStr
        );
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
    public Button getBtnOpen() {
        return btnOpen;
    }

    public Label getSideOfPage() {
        return sideOfPage;
    }

    public ChoiceBox getNumbOfStr() {
        return numbOfStr;
    }
}
