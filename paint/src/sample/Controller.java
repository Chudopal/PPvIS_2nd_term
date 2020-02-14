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
    private CheckBox eraser;

    public Controller() {
    }

    public void initialize(){
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()){
                g.clearRect(x, y, size, size);
            } else {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
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
