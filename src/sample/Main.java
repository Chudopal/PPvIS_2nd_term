package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    Button button;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Graphic editor");
        button = new Button("Click here");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene (layout, 1440, 900);
        stage.setScene(scene);
        stage.show();
    }
}