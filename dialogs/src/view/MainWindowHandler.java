package view;

import controller.FootballerController;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/** This is class for buttons and its actions
 */
public class MainWindowHandler extends MainWindowView {
    private FootballerController footballerController;
    private int numbSide;
    private int numbOfRecOnSide;
    private int maxNumbOfSides;

    /** Constructor of class. Here is initialisation of
     * parameters.
     * @param footballerController - controller
     * @param primaryStage - main window
     * @param sizeX - x-coordinate of window,
     * @param sizeY - y-coordinate of window,
     */
    public MainWindowHandler(FootballerController footballerController, Stage primaryStage, double sizeX, double sizeY){
        super(primaryStage, sizeX, sizeY);
        this.footballerController = footballerController;
        this.Handler();
    }

    /** Here for each button on main window
     * creating action.
     */
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
            this.maxNumbOfSides = this.footballerController.getMaxSideOfPages(this.numbOfRecOnSide);
            this.table.getSideOfPage().setText(Integer.toString(this.numbSide)+ "/" + this.maxNumbOfSides);
            this.table.setFootballers(footballerController.getPage(numbSide, this.numbOfRecOnSide));
        });

        this.btnSave.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("file.xml");
            File file = fileChooser.showSaveDialog(primaryStage);
            footballerController.writeFile(file, footballerController.getFootballers());
            //DOMParser.getDomParser().createXML(footballerController.getFootballers(), file);
            //System.out.println(file.getPath());
        });

        this.table.getNumbOfStr().setOnAction(e ->{
            try {
                this.numbOfRecOnSide = Integer.parseInt((String) this.table.getNumbOfStr().getValue());
                numbSide = 1;
                this.table.setFootballers(footballerController.getPage(this.numbSide, numbOfRecOnSide));
                this.maxNumbOfSides = this.footballerController.getMaxSideOfPages(this.numbOfRecOnSide);
                this.table.getSideOfPage().setText(Integer.toString(this.numbSide) + "/" + this.maxNumbOfSides);
            } catch(Exception exc){
                this.table.getSideOfPage().setText("Don't select a file");
            }
        });

        this.table.getBtnRight().setOnAction(e -> {
                if (this.maxNumbOfSides > this.numbSide) {
                    this.numbSide++;
                    this.table.getSideOfPage().setText(Integer.toString(this.numbSide) + "/" + this.maxNumbOfSides);
                    this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
                }
        });

        this.table.getBtnLeft().setOnAction(e -> {
            try{
            if (this.numbSide != 1) {
                this.numbSide--;
                this.table.getSideOfPage().setText(Integer.toString(this.numbSide) + "/" + this.maxNumbOfSides);
                this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
            }
            catch(Exception exc){
                this.table.getSideOfPage().setText("Don't select a file");
            }
        });

        this.table.getBtnBegin().setOnAction(e -> {
            try {
                this.numbSide = 1;
                this.table.getSideOfPage().setText(Integer.toString(this.numbSide) + "/" + this.maxNumbOfSides);
                this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
            catch(Exception exc){
                    this.table.getSideOfPage().setText("Don't select a file");
                }
        });

        this.table.getBtnEnd().setOnAction(e -> {
            if(this.maxNumbOfSides > this.numbSide){
                this.numbSide = this.maxNumbOfSides;
                this.table.getSideOfPage().setText(Integer.toString(this.numbSide)+ "/" + this.maxNumbOfSides);
                this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
        });

        this.btnDel.setOnAction(e -> {
            DeleteWindow deleteWindow = new DeleteWindow(800, 400, this.footballerController);
        });

        this.btnAdd.setOnAction(e -> {
            AddWindow addWindow = new AddWindow(800, 400, this.footballerController);
        });

        this.btnFind.setOnAction(e -> {
            FindWindow findWindow = new FindWindow(800, 400, this.footballerController);
        });
    }
}
