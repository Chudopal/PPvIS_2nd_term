//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.awt.image.BufferedImage;
import java.io.File;

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
    private Canvas backup_canvas;
    @FXML
    private Canvas copy_canvas;
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
    private RadioButton radio_copy;
    @FXML
    private RadioButton radio_paste;

    private double begin_x = 0;
    private double begin_y = 0;
    private double end_x = 0;
    private double end_y = 0;
    private boolean flag = false;
    private boolean is_not_first_copy = false;

    public Controller() {
    }


    public void initialize(){
        GraphicsContext g = canvas.getGraphicsContext2D();
        GraphicsContext real_g = real_canvas.getGraphicsContext2D();
        GraphicsContext backup_g = backup_canvas.getGraphicsContext2D();
        GraphicsContext copy_g = copy_canvas.getGraphicsContext2D();

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
                        g.strokeRect(begin_x, begin_y, end_x - begin_x, end_y - begin_y);
                    }
                    else if(begin_x > end_x && begin_y > end_y) {
                        g.strokeRect(end_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }else if(begin_x > end_x) {
                        g.strokeRect(end_x, begin_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                    else if(begin_y > end_y) {
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
                        g.strokeOval(begin_x, begin_y, end_x - begin_x, end_y - begin_y);
                    }
                    else if(begin_x > end_x && begin_y > end_y) {
                        g.strokeOval(end_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }else if(begin_x > end_x) {
                        g.strokeOval(end_x, begin_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                    else if(begin_y > end_y) {
                        g.strokeOval(begin_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }
                }
            }

            if(radio_copy.isSelected()) {
                if (!flag) {
                    flag = true;
                    begin_x = e.getX();
                    begin_y = e.getY();
                } else {
                    g.setStroke(Color.BLACK);
                    g.setLineWidth(1);
                    end_x = e.getX();
                    end_y = e.getY();

                    g.clearRect(0, 0, 600, 600);
                    copy_g.clearRect(0, 0, 600, 600);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);
                    WritableImage image = real_canvas.snapshot(params, null);
                    canvas.getGraphicsContext2D().drawImage(image, 0, 0);

                    if (!is_not_first_copy) {
                        SnapshotParameters copy_params = new SnapshotParameters();
                        copy_params.setFill(Color.TRANSPARENT);
                        WritableImage copy_image = real_canvas.snapshot(copy_params, null);
                        backup_canvas.getGraphicsContext2D().drawImage(copy_image, 0, 0);
                    }else{
                        real_g.clearRect(0,0,600,600);
                        SnapshotParameters copy_params = new SnapshotParameters();
                        copy_params.setFill(Color.TRANSPARENT);
                        WritableImage copy_image = backup_canvas.snapshot(copy_params, null);
                        real_canvas.getGraphicsContext2D().drawImage(copy_image, 0, 0);
                    }

                    is_not_first_copy = true;

                    if (begin_x < end_x && begin_y < end_y) {
                        g.strokeRect(begin_x, begin_y, end_x - begin_x, end_y - begin_y);
                    } else if (begin_x > end_x && begin_y > end_y) {
                        g.strokeRect(end_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    } else if (begin_x > end_x) {
                        g.strokeRect(end_x, begin_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    } else if (begin_y > end_y) {
                        g.strokeRect(begin_x, end_y, Math.abs(end_x - begin_x), Math.abs(end_y - begin_y));
                    }

                    SnapshotParameters copy_params = new SnapshotParameters();
                    copy_params.setFill(Color.TRANSPARENT);
                    WritableImage copy_image = real_canvas.snapshot(copy_params, null);
                    copy_canvas.getGraphicsContext2D().drawImage(copy_image, -begin_x, -begin_y);

                    copy_g.clearRect(end_x - begin_x, 0, 600, 600);
                    copy_g.clearRect(0, end_y - begin_y, 600, 600);
                }
            }

        });



        canvas.setOnMousePressed(e -> {
            flag = false;

            if(!radio_copy.isSelected() && is_not_first_copy){
                real_g.clearRect(0,0,600,600);
                g.clearRect(0,0,600,600);

                SnapshotParameters backup_params = new SnapshotParameters();
                backup_params.setFill(Color.TRANSPARENT);
                WritableImage backup_image = backup_canvas.snapshot(backup_params, null);
                real_canvas.getGraphicsContext2D().drawImage(backup_image, 0, 0);

                SnapshotParameters copy_params = new SnapshotParameters();
                copy_params.setFill(Color.TRANSPARENT);
                WritableImage copy_image = real_canvas.snapshot(copy_params, null);
                canvas.getGraphicsContext2D().drawImage(copy_image, 0, 0);

                is_not_first_copy = false;


            }else{
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);
                WritableImage image = canvas.snapshot(params, null);
                real_canvas.getGraphicsContext2D().drawImage(image, 0, 0);
            }

            if (radio_paste.isSelected()){
                double beg_x = e.getX();
                double beg_y = e.getY();

                SnapshotParameters cpy_params = new SnapshotParameters();
                cpy_params.setFill(Color.TRANSPARENT);
                WritableImage cpy_image = copy_canvas.snapshot(cpy_params, null);
                canvas.getGraphicsContext2D().drawImage(cpy_image, beg_x, beg_y);

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
