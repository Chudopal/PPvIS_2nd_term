package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        stage.setTitle("Graphic editor");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
