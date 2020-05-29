package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class MainWindow{
    List<Button> buttonList = new ArrayList<>();
    //view
    protected TextField viewStr = new TextField();
    //numbers
    protected Button nulBtn = new Button("0");
    protected Button oneBtn = new Button("1");
    protected Button twoBtn = new Button("2");
    protected Button treBtn = new Button("3");
    protected Button forBtn = new Button("4");
    protected Button fifBtn = new Button("5");
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
    protected Button point = new Button(".");
    //result
    protected Button resultBtn = new Button("=");
    //power function
    protected Button powerBtn = new Button("^");
    protected CheckBox isPowerMode = new CheckBox("power function");
    //brackets
    protected Button leftBracketBtn = new Button("(");
    protected Button rightBracketBtn = new Button(")");
    //triangle brackets
    protected Button leftTriangleBtn = new Button("<");
    protected Button rightTriangleBtn = new Button(">");
    //delete info
    protected Button delBtn = new Button("C");

    public MainWindow(Stage primaryStage){
        Group root = new Group();
        primaryStage.setTitle("Calculator");
        this.makeView(root);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    private void makeView(Group root){
        HBox mainView = new HBox();
        this.setButtonsView();
        this.createButtons(mainView);
        root.getChildren().addAll(mainView);
    }

    private void setButtonsView(){
        //digits
        nulBtn.setMinSize(50,50);
        oneBtn.setMinSize(50,50);
        twoBtn.setMinSize(50,50);
        treBtn.setMinSize(50,50);
        forBtn.setMinSize(50,50);
        fifBtn.setMinSize(50,50);
        sixBtn.setMinSize(50,50);
        sevBtn.setMinSize(50,50);
        eitBtn.setMinSize(50,50);
        ninBtn.setMinSize(50,50);
        //actions
        leftTriangleBtn.setMinSize(50,50);
        leftTriangleBtn.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.CORAL,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        rightTriangleBtn.setMinSize(50,50);
        leftBracketBtn.setMinSize(50,50);
        rightBracketBtn.setMinSize(50,50);
        sumBtn.setMinSize(50,50);
        difBtn.setMinSize(50,50);
        divBtn.setMinSize(50,50);
        mulBtn.setMinSize(50,50);
        delBtn.setMinSize(50,50);
        oneDiv.setMinSize(50,50);
        proBtn.setMinSize(50,50);
        sqrBtn.setMinSize(50,50);
        point.setMinSize(50,50);
        resultBtn.setMinSize(50,50);
    }

    private void createButtons(HBox mainView){
        VBox calculatorPane = new VBox();
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

        buttons.add(leftTriangleBtn,    0, 0);
        buttons.add(rightTriangleBtn,   1, 0);
        buttons.add(delBtn,             2, 0);
        buttons.add(leftBracketBtn,     3, 0);
        buttons.add(rightBracketBtn,    4, 0);

        buttons.add(sevBtn,             0, 1);
        buttons.add(eitBtn,             1, 1);
        buttons.add(ninBtn,             2, 1);
        buttons.add(sumBtn,             3, 1);
        buttons.add(difBtn,             4, 1);

        buttons.add(forBtn,             0, 2);
        buttons.add(fifBtn,             1, 2);
        buttons.add(sixBtn,             2, 2);
        buttons.add(mulBtn,             3, 2);
        buttons.add(divBtn,             4, 2);

        buttons.add(oneBtn,             0, 3);
        buttons.add(twoBtn,             1, 3);
        buttons.add(treBtn,             2, 3);
        buttons.add(proBtn,             3, 3);
        buttons.add(oneDiv,             4, 3);

        buttons.add(nulBtn,             1, 4);
        buttons.add(point,              2, 4);
        buttons.add(sqrBtn,             3, 4);
        buttons.add(resultBtn,          4, 4);

        calculatorPane.getChildren().addAll(viewStr ,buttons);
        mainView.getChildren().addAll(calculatorPane);
    }
}
