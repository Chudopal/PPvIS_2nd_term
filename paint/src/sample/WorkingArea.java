package sample;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


/**This class is a graphic interface.*/
public class WorkingArea {

    protected Canvas canvas;
    private BorderPane borderPane;
    protected RadioButton radio_cursor;
    protected RadioButton radio_pencil;
    protected RadioButton radio_line;
    protected RadioButton radio_rectangle;
    protected RadioButton radio_oval;
    protected RadioButton radio_copy;
    protected RadioButton radio_paste;
    protected RadioButton radio_text;
    protected RadioButton radio_zoom;
    protected Button save_btn;
    protected Button exit_btn;
    protected MenuItem saveItem;
    protected MenuItem exitItem;

    protected double sizeX;
    protected double sizeY;

    /**The constructor for area-class.
     * @param borderPane this panel has an interface,
     * @param sizeX a wight of the workspace,
     * @param sizeY a height of the workspace.*/
    public WorkingArea(BorderPane borderPane,
                       double sizeX,
                       double sizeY){
        this.borderPane = borderPane;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.makeCanvas();
        this.makeTopLevel();
    }

    /**This method creates a canvas*/
    private void makeCanvas(){
        this.canvas = new Canvas(this.sizeX, this.sizeY);
        this.borderPane.setCenter(this.canvas);
    }

    /**This method creates menu, each button, and radiobutton in borderpane.
     * It creates the layer with menu,
     * the layer with modes, and the layer with settings.*/
    private void makeTopLevel(){
        HBox modesBox = new HBox();
        modesBox.setPadding(new Insets(15, 12, 15, 12));
        modesBox.setSpacing(10);
        modesBox.setStyle("-fx-background-color: #ccffcc;");

        ToggleGroup group = new ToggleGroup();
        //Cursor button
        this.radio_cursor = new RadioButton("Cursor");
        this.radio_cursor.setToggleGroup(group);
        //Pencil button
        this.radio_pencil = new RadioButton("Pencil");
        this.radio_pencil.setToggleGroup(group);
        //Line draw button
        this.radio_line = new RadioButton("Line");
        this.radio_line.setToggleGroup(group);
        //Rectangle draw button
        this.radio_rectangle = new RadioButton("Rectangle");
        this.radio_rectangle.setToggleGroup(group);
        //Oval draw button
        this.radio_oval = new RadioButton("Oval");
        this.radio_oval.setToggleGroup(group);
        //Copy button
        this.radio_copy = new RadioButton("Copy");
        this.radio_copy.setToggleGroup(group);
        //Paste button
        this.radio_paste = new RadioButton("Paste");
        this.radio_paste.setToggleGroup(group);
        //Text button
        this.radio_text = new RadioButton("Text");
        this.radio_text.setToggleGroup(group);
        //Zoom button
        this.radio_zoom = new RadioButton("Zoom");
        this.radio_zoom.setToggleGroup(group);
        //Save button
        this.save_btn = new Button("Save");
        //exit button
        this.exit_btn = new Button("Exit");

        modesBox.getChildren().addAll(radio_cursor, radio_pencil,
                radio_line, radio_rectangle,
                radio_oval, radio_copy, radio_paste,
                radio_text, radio_zoom, save_btn,
                exit_btn);
        //Make the menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        this.saveItem = new MenuItem("Save");
        this.exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(saveItem, exitItem);
        menuBar.getMenus().addAll(fileMenu);
        //Make the setting layer
        HBox settingBox = new HBox();
        TextField brushSize = new TextField("10");
        ColorPicker colorPicker = new ColorPicker();
        settingBox.getChildren().addAll(brushSize, colorPicker);
        settingBox.setStyle("-fx-background-color: #eeffe4;");
        //Add all in the border pane
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, modesBox, settingBox);
        this.borderPane.setTop(vBox);
    }
}
