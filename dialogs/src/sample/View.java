package sample;

import javafx.scene.control.Button;
import javafx.stage.Stage;
/**This class is a view of the app.
 * Here is the buttons, labels, text fields and other.*/
public class View extends MainWindow {

    protected Button deleteBtn;
    protected Button findBtn;
    protected Button addBtn;


    /**This is the constructor.
     * Here calls the methods for building
     * the view of the app.
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    View(Stage primaryStage, double sizeX, double sizeY){
        super(primaryStage, sizeX, sizeY);
        this.mainBox();
    }

    private void mainBox(){
        TableDisplay tableDisplay = new TableDisplay(root);
    }

}
