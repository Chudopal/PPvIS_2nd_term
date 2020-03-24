package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**This class is creating a space for other
 * buttons, text boxes, and labels*/
public class MainWindowView {

    protected Table table;

    private double sizeX;
    private double sizeY;


    /**Constructor of class
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    MainWindowView(Stage primaryStage, double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.createWindow(primaryStage);
    }

    /**This function is creating form
     * @param primaryStage -- the main window*/
    void createWindow(Stage primaryStage){
        Group root = new Group();
        primaryStage.setTitle("Football");
        primaryStage.setScene(new Scene(root, this.sizeX, this.sizeY));
        this.mainBox(root);
        primaryStage.show();
    }

    private void mainBox(Group root){
        this.table = new Table(root, this.sizeX, this.sizeY);
    }
}
