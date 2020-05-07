package view;

import controller.FootballerController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Class for making child windows.
 */
class ChildWindow{

    protected Group root = new Group();
    protected FootballerController footballerController;
    protected Table table;
    protected TextField surName = new TextField("surname");
    protected TextField firstName = new TextField("first name");
    protected TextField middleName = new TextField("middle name");
    protected DatePicker dateOfBirth = new DatePicker();
    protected TextField team = new TextField("team");
    protected TextField homeCity = new TextField("home city");
    protected TextField structure = new TextField("structure");
    protected TextField position = new TextField("position");
    protected int numbSide = 1 ;
    protected int numbOfRecOnSide = 5 ;
    protected int maxNumbOfSides;
    protected Button button = new Button();

    /** There is creating of a new window.
     * @param sizeX - x-coordinate size of window,
     * @param sizeY - y-coordinate size of window,
     * @param footballerController - controller of footballers.
     */
    ChildWindow(double sizeX, double sizeY, FootballerController footballerController){
        this.footballerController = footballerController;
        Stage stage = new Stage();
        stage.setScene(new Scene(root, sizeX, sizeY));
        this.makeLook(sizeX, sizeY);
        stage.show();
    }

    /** Here each element puts on window.
     * @param sizeX - x-coordinate size of window,
     * @param sizeY - y-coordinate size of window,
     */
    private void makeLook(double sizeX, double sizeY){
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        table = new Table(vBox, sizeX, sizeY);
        table.createTable();

        surName.setMaxSize(     100,30);
        firstName.setMaxSize(   100,30);
        middleName.setMaxSize(  100,30);
        dateOfBirth.setMaxSize( 100,30);
        team.setMaxSize(        100,30);
        homeCity.setMaxSize(    100,30);
        structure.setMaxSize(   100,30);
        position.setMaxSize(    100,30);

        button.setMinSize(300, 50);

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.BOTTOM_CENTER);

        hBox.getChildren().addAll(
            surName, firstName, middleName,
            dateOfBirth, team, homeCity,
            structure, position
        );
        vBox.getChildren().addAll(hBox, button);
        this.root.getChildren().addAll(vBox);
        this.handler();

    }

    /** Here for each button made action.
     */
    private void handler(){
        //this.table.setFootballers(footballerController.getPage(1,5));

        this.maxNumbOfSides = this.footballerController.getMaxSideOfPages(5);
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
                //this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
        });

        this.table.getBtnLeft().setOnAction(e -> {
            try{
                if (this.numbSide != 1) {
                    this.numbSide--;
                    this.table.getSideOfPage().setText(Integer.toString(this.numbSide) + "/" + this.maxNumbOfSides);
                    //this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
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
                //this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
            catch(Exception exc){
                this.table.getSideOfPage().setText("Don't select a file");
            }
        });

        this.table.getBtnEnd().setOnAction(e -> {
            if(this.maxNumbOfSides > this.numbSide){
                this.numbSide = this.maxNumbOfSides;
                this.table.getSideOfPage().setText(Integer.toString(this.numbSide)+ "/" + this.maxNumbOfSides);
                //this.table.setFootballers(footballerController.getPage(this.numbSide, this.numbOfRecOnSide));
            }
        });
    }
}
