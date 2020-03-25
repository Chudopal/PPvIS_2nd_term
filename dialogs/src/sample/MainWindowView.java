package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


/**This class is creating a space for other
 * buttons, text boxes, and labels*/
public class MainWindowView {

    private FootballerController footballerController;
    private Stage primaryStage;
    private Table table;
    private Button btnAdd = new Button("Add a record");
    private Button btnDel = new Button("Delete a record");
    private Button btnFind = new Button("Find a record");
    private double sizeX;
    private double sizeY;


    /**Constructor of class
     * @param primaryStage -- the main window,
     * @param sizeX -- x-size of main window,
     * @param sizeY -- y-size of main window*/
    MainWindowView(FootballerController footballerController, Stage primaryStage, double sizeX, double sizeY){
        this.footballerController = footballerController;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.primaryStage = primaryStage;
        this.createWindow();
    }

    /**This function is creating form*/
    void createWindow(){
        Group root = new Group();
        VBox mainStruct = new VBox();
        primaryStage.setTitle("Football");
        primaryStage.setScene(new Scene(root, this.sizeX, this.sizeY));
        this.mainBox(mainStruct);
        this.Handler();
        root.getChildren().add(mainStruct);
        primaryStage.show();
    }

    private void mainBox(VBox mainStruct){
        this.table = new Table(mainStruct, this.sizeX, this.sizeY);
        this.table.createTable();
        this.btnAdd.setMinSize(600, 50);
        this.btnFind.setMinSize(600, 50);
        this.btnDel.setMinSize(600, 50);
        mainStruct.setSpacing(20);
        mainStruct.setAlignment(Pos.BOTTOM_CENTER);
        mainStruct.getChildren().addAll(this.btnAdd, this.btnDel, this.btnFind);
    }

    private void Handler(){
        this.table.getBtnOpen().setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(primaryStage);
            //pars = new Pars(file.getName());
            footballerController.readFile(file);
            System.out.println(file.getName());
            this.table.clearTable();
            this.table.setFootballers(footballerController.getFootballers());
        });
    }
}
