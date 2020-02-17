//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.awt.*;

public class Main extends Application {
    public Main() {
    }
    @FXML
    private Canvas real_canvas;
    @FXML
    private Canvas canvas;

    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene((Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"))));
        stage.setTitle("Graphic editor");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
