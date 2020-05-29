package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainWindow{
    //numbers
    protected Button nulBtn = new Button("0");
    protected Button oneBtn = new Button("1");
    protected Button twoBtn = new Button("2");
    protected Button treBtn = new Button("3");
    protected Button forBtn = new Button("4");
    protected Button fivBtn = new Button("5");
    protected Button sixBtn = new Button("6");
    protected Button sevBtn = new Button("7");
    protected Button eitBtn = new Button("8");
    protected Button ninBtn = new Button("9");
    //actions
    protected Button sumBtn = new Button("+");
    protected Button difBtn = new Button("-");
    protected Button mulBtn = new Button("*");
    protected Button divBtn = new Button("\\");
    protected Button sqrBtn = new Button("sqrt");
    protected Button proBtn = new Button("%");
    protected Button oneDiv = new Button("1/x");
    //result
    protected Button resultBtn = new Button("=");
    //power function
    protected Button powerBtn = new Button("^");
    protected CheckBox isPowerMode = new CheckBox("power function");

    public MainWindow(Stage primaryStage){
        Group root = new Group();
        primaryStage.setTitle("Calculator");
        this.makeView(root);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private void makeView(Group root){
        HBox mainView = new HBox();
        this.createButtons(mainView);
        root.getChildren().addAll(mainView);
    }

    public void createButtons(HBox mainView){
        GridPane buttons = new GridPane();
        buttons.getColumnConstraints().addAll(
                new ColumnConstraints(50),
                new ColumnConstraints(50),
                new ColumnConstraints(50),
                new ColumnConstraints(50),
                new ColumnConstraints(50)
        );
        buttons.getRowConstraints().addAll(
                new RowConstraints(50),
                new RowConstraints(50),
                new RowConstraints(50),
                new RowConstraints(50),
                new RowConstraints(50)
        );



        mainView.getChildren().addAll(buttons);
    }
}
