//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

public class Controller {
    @FXML
    private Canvas canvas;
    @FXML
    private Canvas real_canvas;
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
    @FXML
    private BorderPane borderPane;
    @FXML
    private Group root;

    private double begin_x = 0;
    private double begin_y = 0;
    private double end_x = 0;
    private double end_y = 0;
    private boolean flag = false;

    public Controller() {
    }


    public void initialize(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        GraphicsContext real_g = real_canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {

            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            g.setStroke(colorPicker.getValue());
            g.setLineWidth(size);

            if(radio_pencil.isSelected()) {
                g.setFill(colorPicker.getValue());
                g.fillRect(x, y, size, size);
            }
            if(radio_erase.isSelected()){
                g.clearRect(x, y, size, size);
                real_g.clearRect(x, y, size, size);
            }



            if(radio_line.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {

                    end_x = e.getX();
                    end_y = e.getY();

                    g.clearRect(0, 0, 600, 600);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    WritableImage image = real_canvas.snapshot(params, null);
                    canvas.getGraphicsContext2D().drawImage(image, 0, 0);
                    g.strokeLine(begin_x, begin_y, end_x, end_y);

                }
            }

            if(radio_rect.isSelected()) {
                if (!flag) {



                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {


                    end_x = e.getX();
                    end_y = e.getY();

                    g.clearRect(0, 0, 600, 600);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    WritableImage image = real_canvas.snapshot(params, null);
                    canvas.getGraphicsContext2D().drawImage(image, 0, 0);

                    if(begin_x < end_x && begin_y < end_y) {
                        //g.clearRect(begin_x, begin_y, 600, 600);
                        g.strokeRect(begin_x, begin_y, end_x - begin_x, end_y - begin_y);
                    }
                    else if(begin_x > end_x && begin_y > end_y) {
                        //g.clearRect(end_x, end_y, 600, 600);
                        g.strokeRect(end_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }else if(begin_x > end_x) {
                        //g.clearRect(0, 0, 600, 600);
                        g.strokeRect(end_x, begin_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                    else if(begin_y > end_y) {
                        //g.clearRect(0, 0, 600, 600);
                        g.strokeRect(begin_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                }
            }

            if(radio_oval.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {

                    end_x = e.getX();
                    end_y = e.getY();

                    g.clearRect(0, 0, 600, 600);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    WritableImage image = real_canvas.snapshot(params, null);
                    canvas.getGraphicsContext2D().drawImage(image, 0, 0);

                    if(begin_x < end_x && begin_y < end_y) {
                        //g.clearRect(begin_x, begin_y, 600, 600);
                        g.strokeOval(begin_x, begin_y, end_x - begin_x, end_y - begin_y);
                    }
                    else if(begin_x > end_x && begin_y > end_y) {
                        //g.clearRect(end_x, end_y, 600, 600);
                        g.strokeOval(end_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }else if(begin_x > end_x) {
                        //g.clearRect(0, 0, 600, 600);
                        g.strokeOval(end_x, begin_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                    else if(begin_y > end_y) {
                        //g.clearRect(0, 0, 600, 600);
                        g.strokeOval(begin_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                }
            }
        });

        canvas.setOnMousePressed(e -> {
            flag = false;
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);
            WritableImage image = canvas.snapshot(params, null);
            real_canvas.getGraphicsContext2D().drawImage(image, 0, 0);


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
