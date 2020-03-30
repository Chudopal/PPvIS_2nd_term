package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainWindowHandler extends MainWindowView {
    private FootballerController footballerController;
    private int numbSide;
    private int numbOfRecOnSide;


    MainWindowHandler(FootballerController footballerController, Stage primaryStage, double sizeX, double sizeY){
        super(primaryStage, sizeX, sizeY);
        this.footballerController = footballerController;
        this.Handler();
    }

    private void Handler(){
        this.table.getBtnOpen().setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(primaryStage);

            footballerController.readFile(file);

            this.table.clearTable();
            this.table.setFootballers(footballerController.getPage(1, 5));
        });

        this.table.getBtnRight().setOnAction(e -> {

        });

        this.table.getNumbOfStr().setOnAction(e ->{
            //this.numbOfRecOnSide = this.table.getNumbOfStr().getValue();
        });

        this.btnDel.setOnAction(e -> {
            DeleteWindow deleteWindow = new DeleteWindow(400, 400);
        });

        this.btnAdd.setOnAction(e -> {
            AddWindow deleteWindow = new AddWindow(400, 400);
        });

        this.btnFind.setOnAction(e -> {
            DeleteWindow deleteWindow = new DeleteWindow(400, 400);
        });
    }
}
