    package view;

    import javafx.geometry.Pos;
    import javafx.scene.Group;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.layout.VBox;
    import javafx.stage.Stage;

    /**This class is creating a space for other
     * buttons, text boxes, and labels*/
    public class MainWindowView  {

        protected Stage primaryStage;

        protected Table table;
        protected Button btnAdd = new Button("Add a record");
        protected Button btnDel = new Button("Delete a record");
        protected Button btnFind = new Button("Find a record");
        protected Button btnSave = new Button("Save");
        private double sizeX;
        private double sizeY;


        /**Constructor of class
         * @param primaryStage -- the main window,
         * @param sizeX -- x-size of main window,
         * @param sizeY -- y-size of main window*/
        MainWindowView(Stage primaryStage, double sizeX, double sizeY){
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
            root.getChildren().add(mainStruct);
            primaryStage.show();
        }

        private void mainBox(VBox mainStruct){
            this.table = new Table(mainStruct, this.sizeX, this.sizeY);
            this.table.createTable();
            this.btnAdd.setMinSize(600, 50);
            this.btnFind.setMinSize(600, 50);
            this.btnDel.setMinSize(600, 50);
            this.btnSave.setMinSize(200, 40);
            mainStruct.setSpacing(15);
            mainStruct.setAlignment(Pos.BOTTOM_CENTER);
            mainStruct.getChildren().addAll(this.btnAdd, this.btnDel, this.btnFind, this.btnSave);
        }

    }
