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
            this.numbSide = 1;
            this.numbOfRecOnSide = 5;
            this.table.setFootballers(footballerController.getPage(numbSide, this.numbOfRecOnSide));
        });

        this.table.getBtnRight().setOnAction(e -> {

        });

        this.table.getNumbOfStr().setOnAction(e ->{
            this.numbOfRecOnSide = Integer.parseInt((String) this.table.getNumbOfStr().getValue());
            numbSide = 1;
            this.table.getSideOfPage().setText(Integer.toString(this.numbSide));
            this.table.setFootballers(footballerController.getPage(this.numbSide, numbOfRecOnSide));
        });

        this.table.getBtnRight().setOnAction(e -> {
            this.numbSide++;
            //this.table.clearTable();
            this.table.getSideOfPage().setText(Integer.toString(this.numbSide));
            this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
        });

        this.table.getBtnLeft().setOnAction(e -> {
            this.numbSide--;
            //this.table.clearTable();
            this.table.getSideOfPage().setText(Integer.toString(this.numbSide));
            this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
        });

        this.table.getBtnBegin().setOnAction(e -> {
            this.numbSide = 1;
            this.table.getSideOfPage().setText(Integer.toString(this.numbSide));
            this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
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
