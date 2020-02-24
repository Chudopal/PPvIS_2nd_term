package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**This class is created the main window of the application.*/
public class MainWindow {
    private Stage stage;
    private Scene scene;
    private double sizeX;
    private double sizeY;
    private Group root = new Group();

    /**The constructor of MainWindow-class.
     * @param stage stage of the main window,
     * @param sizeX the wight of the main window,
     * @param sizeY the height of the main window.
     * */
    public MainWindow(Stage stage, double sizeX, double sizeY){
        this.stage = stage;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.makeGroup();
        this.createWindow();
    }

    /**This func allows to create the main window*/
    private void createWindow(){
        this.stage.setTitle("Graphic editor");
        stage.setResizable(false);
        scene = new Scene(root, this.sizeX, this.sizeX);
        this.stage.setScene(scene);
        this.stage.show();
    }

    /**This func creates the group and puts it onto the scene*/
    private void makeGroup(){
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(this.sizeX, this.sizeY);
        DrawingArea area = new DrawingArea(borderPane,
                                               this.sizeX,
                                               this.sizeY);
        root.getChildren().addAll(borderPane);
    }
}
