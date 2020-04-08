package view;


import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Footballer;

import java.util.ArrayList;
import java.util.List;


/** Class for table and buttons.
 */
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

    /** Constructor of class.
     * @param root - where the table will locate,
     * @param sizeX - size of x-coordinate of window,
     * @param sizeY - size of x-coordinate of window.
     */
    Table(VBox root, double sizeX, double sizeY){
        tableDisplay = new TableDisplay(this.mainBox, sizeX, sizeY);
        this.createButtons();
        root.getChildren().add(this.mainBox);
    }

    /**This method allows to put each button
     * onto the window.
     */
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

    public void setFootballers(List<Footballer> footballers){
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
