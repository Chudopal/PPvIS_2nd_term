package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**This class is creating a space for other
 * buttons, text boxes, and labels*/
public class MainWindow{
    protected Group root;
    /**Constructor of class
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    MainWindow(Stage primaryStage, double sizeX, double sizeY){
        this.createWindow(primaryStage, sizeX, sizeY);
    }

    /**This function is creating form
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    void createWindow(Stage primaryStage, double sizeX, double sizeY){
        this.root = new Group();
        primaryStage.setTitle("Football");
        primaryStage.setScene(new Scene(this.root, sizeX, sizeY));
        primaryStage.show();
    }

}
