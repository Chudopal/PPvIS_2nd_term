package view;

import controller.FootballerController;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SetHostWindow {
    FootballerController footballerController;
    private TextField enterPort = new TextField();
    private TextField enterHost = new TextField();

    public SetHostWindow(FootballerController footballerController){
        Stage stage = new Stage();
        Group root = new Group();
        stage.setTitle("Change host");
        this.footballerController = footballerController;
        VBox vBox = new VBox();
        HBox hostField = new HBox();
        Label host = new Label("Host:");

        hostField.getChildren().addAll(host, enterHost);
        hostField.setAlignment(Pos.BOTTOM_CENTER);
        HBox portField = new HBox();
        Label port = new Label("Port:");

        portField.getChildren().addAll(port, enterPort);
        portField.setAlignment(Pos.BOTTOM_CENTER);
        Button set = new Button("set");
        vBox.getChildren().addAll(hostField, portField, set);
        root.getChildren().addAll(vBox);
        stage.setScene(new Scene(root, 210, 90));

        set.setOnAction((e)->{
            footballerController.setHost(enterHost.getText(), Integer.parseInt(enterPort.getText()));
        });

        vBox.setAlignment(Pos.BOTTOM_CENTER);
        stage.show();
    }
}
