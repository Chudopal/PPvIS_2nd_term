//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

public class Controller {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private TextField brushSize;

    @FXML
    private RadioButton radio_pencil;

    @FXML
    private RadioButton radio_erase;

    @FXML
    private RadioButton radio_line;

    @FXML
    private RadioButton radio_rect;

    @FXML
    private RadioButton radio_oval;

    private double begin_x = 0;
    private double begin_y = 0;
    private double end_x = 0;
    private double end_y = 0;
    private boolean flag = false;

    public Controller() {
    }


    public void initialize(){
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;


            if(radio_pencil.isSelected()) {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
            if(radio_erase.isSelected()){
                g.clearRect(x, y, size, size);
            }
        });

        canvas.setOnMouseClicked(e -> {
            if(radio_line.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {
                    flag = false;
                    end_x = e.getX();
                    end_y = e.getY();
                    g.strokeLine(begin_x, begin_y, end_x, end_y);
                }
            }

            if(radio_rect.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {
                    flag = false;
                    end_x = e.getX();
                    end_y = e.getY();
                    g.strokeRect(begin_x, begin_y, end_x, end_y);
                }
            }

            if(radio_oval.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {
                    flag = false;
                    end_x = e.getX();
                    end_y = e.getY();
                    g.strokeOval(begin_x, begin_y, end_x, end_y);
                }
            }
        });
    }

    public void onSave() {
        try {
            Image snapshot = this.canvas.snapshot((SnapshotParameters)null, (WritableImage)null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, (BufferedImage)null), "png", new File("paint.png"));
        } catch (Exception var2) {
            System.out.print("Failed to save image:" + var2);
        }

    }

    public void onExit() {
        System.exit(0);
    }
}
