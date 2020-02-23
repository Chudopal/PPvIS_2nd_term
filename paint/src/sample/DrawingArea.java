package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawingArea extends WorkingArea {

    protected GraphicsContext mainContext = mainCanvas.getGraphicsContext2D();
    protected GraphicsContext buffContext = buffCanvas.getGraphicsContext2D();
    private double size = 0;
    private Canvas copyCanvas = new Canvas(mainCanvas.getWidth(), mainCanvas.getHeight());


    public DrawingArea(BorderPane borderPane,
                       double sizeX,
                       double sizeY) {
        super(borderPane, sizeX, sizeY);
        this.handler();
    }

    private void handler(){

        radio_cursor.setOnAction(e->{
            mainCanvas.getScene().setCursor(ImageCursor.DEFAULT);
        });

        radio_pencil.setOnAction(e ->{
            changeCursor("pencil.png");
            Pencil pencil = new Pencil(this.mainContext, colorPicker, brushSize);
            this.copyFirstCanvasOntoSecondCanvas(mainCanvas, buffCanvas, 0 ,0);
        });

        radio_erase.setOnAction(e->{
            changeCursor("erase.png");
            Erase erase = new Erase(this.mainContext, this.buffContext,
                        this.size, brushSize);
        });

        radio_line.setOnAction(e->{
            changeCursor("line.png");
            Line line = new Line(this.mainContext, this.buffContext, this.colorPicker, this.brushSize);

        });

        radio_rectangle.setOnAction(e->{
            changeCursor("rectangle.png");
            Rectangle rectangle = new Rectangle(this.mainContext,
            this.buffContext, this.colorPicker, this.brushSize);
        });

        radio_oval.setOnAction(e->{
            changeCursor("oval.png");
            Oval oval = new Oval(this.mainContext, this.buffContext, this.colorPicker, this.brushSize);
        });

        radio_copy.setOnAction(e-> {
            changeCursor("copy.png");
            copy();
        });

        radio_paste.setOnAction(e-> {
            changeCursor("paste.png");
            paste();
        });

        radio_text.setOnAction(e->{
            changeCursor("text.png");
            Text text = new Text(mainContext, buffContext, radio_text, colorPicker, textPrint, brushSize);
        });

        save_btn.setOnAction(e->{
            this.save();
        });

        saveItem.setOnAction(e->{
            this.save();
        });

        exit_btn.setOnAction(e->{
            System.exit(0);
        });

        exitItem.setOnAction(e->{
            System.exit(0);
        });


    }

    private void copy(){

            copyCanvas.getGraphicsContext2D().clearRect(0, 0, copyCanvas.getWidth(), copyCanvas.getHeight());
            Rectangle copyRectangle = new Rectangle(this.mainContext,
                    this.buffContext, this.colorPicker, this.brushSize);
            mainCanvas.setOnMouseReleased(event -> {
                if(radio_copy.isSelected()) {
                    System.out.println("HERE");
                    double beginX = copyRectangle.getBeginX();
                    double beginY = copyRectangle.getBeginY();
                    double sideX = copyRectangle.getXSide();
                    double sideY = copyRectangle.getYSide();
                    Canvas reserveCanvas = new Canvas(mainCanvas.getWidth(), mainCanvas.getHeight());
                    this.copyFirstCanvasOntoSecondCanvas(buffCanvas, reserveCanvas, 0, 0);
                    this.copyFirstCanvasOntoSecondCanvas(reserveCanvas, copyCanvas, -beginX, -beginY);
                    copyCanvas.getGraphicsContext2D().clearRect(sideX, 0,
                            this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
                    copyCanvas.getGraphicsContext2D().clearRect(0, sideY,
                            this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
                    mainContext.clearRect(0, 0, mainContext.getCanvas().getWidth(),
                            mainContext.getCanvas().getHeight());
                    buffContext.clearRect(0, 0, buffContext.getCanvas().getWidth(),
                            buffContext.getCanvas().getHeight());
                    this.copyFirstCanvasOntoSecondCanvas(reserveCanvas, mainCanvas, 0, 0);
                }
            });

    }

    private void paste(){
        mainCanvas.setOnMouseClicked(event -> {
            if(radio_paste.isSelected()) {
                System.out.println("GER");
                copyFirstCanvasOntoSecondCanvas(copyCanvas, mainCanvas, event.getX(), event.getY());
            }
        });
    }

    static private void copyFirstCanvasOntoSecondCanvas(Canvas firstCanvas, Canvas secondCanvas,
                                                 double shiftX, double shiftY){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = firstCanvas.snapshot(params, null);
        secondCanvas.getGraphicsContext2D().drawImage(image, shiftX, shiftY);

    }

    private void changeCursor( String name){
        Scene scene = mainCanvas.getScene();
        Image img = new Image(getClass().getResourceAsStream("./icons/" + name));
        ImageCursor cursor = new ImageCursor(img, 30, 30);
        scene.setCursor(cursor);
    }

    private void save(){
        try {
            Image snapshot = this.mainCanvas.snapshot((SnapshotParameters)null, (WritableImage)null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, (BufferedImage)null), "png", new File("paint.png"));
        } catch (Exception var2) {
            System.out.print("Failed to save image:" + var2);
        }
    }
}
