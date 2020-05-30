package view;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class MainWindow{
    protected List<Button> buttonDigitList = new ArrayList<>();
    protected List<Button> buttonActionList = new ArrayList<>();
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
    protected Button divBtn = new Button("/");
    protected Button sqrBtn = new Button("√");
    protected Button proBtn = new Button("%");
    protected Button oneDiv = new Button("1/");
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
    //tree view
    protected TextField result = new TextField();
    protected TreeView<String> tree = new TreeView<>();

    protected GridPane buttons = new GridPane();

    public MainWindow(Stage primaryStage){
        Group root = new Group();
        primaryStage.setTitle("Calculator");
        this.makeView(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void makeView(Group root){
        HBox mainView = new HBox();
        this.buttonsMakeList();
        this.setProperties(mainView);
        this.createButtons(mainView);
        root.getChildren().addAll(mainView);
    }

    private void buttonsMakeList(){
        buttonDigitList.addAll(
                Arrays.asList(
                        oneBtn,
                        twoBtn,
                        treBtn,
                        forBtn,
                        fifBtn,
                        sixBtn,
                        sevBtn,
                        eitBtn,
                        ninBtn,
                        nulBtn
                )
        );
        buttonActionList.addAll(
                Arrays.asList(
                        sumBtn,
                        difBtn,
                        divBtn,
                        mulBtn,
                        sqrBtn,
                        proBtn,
                        oneDiv,
                        point,
                        powerBtn,
                        leftBracketBtn,
                        rightBracketBtn,
                        delBtn
                )
        );
    }

    private void setProperties(HBox mainView){
        buttonDigitList.forEach(button -> {
            button.setMinSize(50,50);
            button.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.CORNSILK,
                                    CornerRadii.EMPTY,
                                    Insets.EMPTY
                            )
                    )
            );
        });
        leftTriangleBtn.setMinSize(50,50);
        leftTriangleBtn.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.MISTYROSE,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        rightTriangleBtn.setMinSize(50,50);
        rightTriangleBtn.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.MISTYROSE,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        buttonActionList.forEach(button -> {
            button.setMinSize(50,50);
            button.setBackground(
                    new Background(
                            new BackgroundFill(
                                    Color.MISTYROSE,
                                    CornerRadii.EMPTY,
                                    Insets.EMPTY
                            )
                    )
            );
        });
        resultBtn.setMinSize(50,50);
        resultBtn.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.PALETURQUOISE,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        mainView.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.SEASHELL,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        result.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.LIGHTPINK,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        viewStr.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.SEASHELL,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        tree.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.SEASHELL,
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );
        result.setFont(Font.font ("Verdana", 30));
        result.setMaxWidth(200);
    }

    private void createButtons(HBox mainView){
        VBox calculatorPane = new VBox();
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

        VBox treeView = new VBox();
        tree.setMaxSize(200, 250);

        treeView.getChildren().addAll(result, tree);
        calculatorPane.getChildren().addAll(viewStr,buttons, isPowerMode);
        mainView.getChildren().addAll(treeView, calculatorPane);
    }
}
