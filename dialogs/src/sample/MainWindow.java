package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**This class is creating a space for other
 * buttons, text boxes, and labels*/
public class MainWindow{
    protected Group root;
    protected double sizeX;
    protected double sizeY;


    /**Constructor of class
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    MainWindow(Stage primaryStage, double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.createWindow(primaryStage);
    }

    /**This function is creating form
     * @param primaryStage -- the main window*/
    void createWindow(Stage primaryStage){
        this.root = new Group();
        primaryStage.setTitle("Football");
        primaryStage.setScene(new Scene(this.root, this.sizeX, this.sizeY));
        this.mainBox();

        primaryStage.show();
    }

    private void mainBox(){
        TableDisplay tableDisplay = new TableDisplay(root, sizeX, sizeY);
        ArrayList<Footballer> footballers = new ArrayList<>();
        footballers.add(new Footballer(
                "name",
                "newName",
                "Oldname",
                new Date("00:00:2000"),
                "team",
                "HC",
                "CommStr",
                "Pos"
        ));

        tableDisplay.setFootballers(footballers);
        tableDisplay.createTable();
        footballers.add(new Footballer(
                "name",
                "newName",
                "Oldname",
                new Date("00:00:2000"),
                "team",
                "HC",
                "CommStr",
                "Pos"
        ));
        tableDisplay.clearTable();
        tableDisplay.setFootballers(footballers);
    }

}
