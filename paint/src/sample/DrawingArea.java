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

/**This class is a background of all GUI.
 * Here is the functions for the each button.*/
public class DrawingArea extends WorkingArea {
    protected GraphicsContext mainContext = mainCanvas.getGraphicsContext2D();
    protected GraphicsContext buffContext = buffCanvas.getGraphicsContext2D();
    private Canvas copyCanvas = new Canvas(mainCanvas.getWidth(), mainCanvas.getHeight());

    /**The constructor
     * @param borderPane is the main pane of the app.
     * @param sizeX the size of the x-coord of the borderPane,
     * @param sizeY the size of the y-coord of the borderPane.*/
    public DrawingArea(BorderPane borderPane,
                       double sizeX,
                       double sizeY) {
        super(borderPane, sizeX, sizeY);
        this.handler();
    }

    /** Here is the decision of the each button.*/
    private void handler(){

        radio_cursor.setOnAction(e->{
            mainCanvas.getScene().setCursor(ImageCursor.DEFAULT);
        });

        radio_pencil.setOnAction(e ->{
            changeCursor("pencil.png");
            Pencil pencil = new Pencil(this.mainContext, colorPicker, brushSize, radio_pencil);
            copyFirstCanvasOntoSecondCanvas(mainCanvas, buffCanvas, 0 ,0);
        });

        radio_erase.setOnAction(e->{
            changeCursor("erase.png");
            Erase erase = new Erase(this.mainContext, this.buffContext, brushSize);
        });

        radio_line.setOnAction(e->{
            changeCursor("line.png");
            DrawLine drawLine = new DrawLine(this.mainContext, this.buffContext,
                    this.colorPicker, this.brushSize, radio_line);

        });

        radio_rectangle.setOnAction(e->{
            changeCursor("rectangle.png");
            DrawRectangle drawRectangle = new DrawRectangle(this.mainContext,
                    this.buffContext, this.colorPicker, this.brushSize, this.radio_rectangle);
        });

        radio_oval.setOnAction(e->{
            changeCursor("oval.png");
            DrawOval drawOval = new DrawOval(this.mainContext, this.buffContext,
                    this.colorPicker, this.brushSize, this.radio_oval);
        });

        radio_copy.setOnAction(e-> {
            changeCursor("copy.png");
            this.copy();
        });

        radio_paste.setOnAction(e-> {
            changeCursor("paste.png");
            this.paste();
        });

        radio_text.setOnAction(e->{
            changeCursor("text.png");
            Text text = new Text(mainContext, radio_text, colorPicker, textPrint, brushSize);
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

        zoom_btn.setOnAction(e->{
            Zoom zoom = new Zoom(mainContext, buffContext, this.sizeX, zoom_btn);
        });
    }

    /**Allows to copy a fragment of one canvas onto other canvas.
     * Save this fragment in copyCanvas*/
    private void copy(){
            copyCanvas.getGraphicsContext2D().clearRect(0, 0, copyCanvas.getWidth(), copyCanvas.getHeight());
            DrawRectangle copyDrawRectangle = new DrawRectangle(this.mainContext,
                    this.buffContext, this.colorPicker, this.brushSize, radio_copy);
            mainCanvas.setOnMouseReleased(event -> {
                if(radio_copy.isSelected()) {
                    double beginX = copyDrawRectangle.getBeginX();
                    double beginY = copyDrawRectangle.getBeginY();
                    double sideX = copyDrawRectangle.getXSide();
                    double sideY = copyDrawRectangle.getYSide();
                    Canvas reserveCanvas = new Canvas(mainCanvas.getWidth(), mainCanvas.getHeight());
                    copyFirstCanvasOntoSecondCanvas(buffCanvas, reserveCanvas, 0, 0);
                    copyFirstCanvasOntoSecondCanvas(reserveCanvas, copyCanvas, -beginX, -beginY);
                    copyCanvas.getGraphicsContext2D().clearRect(sideX, 0,
                            this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
                    copyCanvas.getGraphicsContext2D().clearRect(0, sideY,
                            this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
                    mainContext.clearRect(0, 0, mainContext.getCanvas().getWidth(),
                            mainContext.getCanvas().getHeight());
                    buffContext.clearRect(0, 0, buffContext.getCanvas().getWidth(),
                            buffContext.getCanvas().getHeight());
                    copyFirstCanvasOntoSecondCanvas(reserveCanvas, mainCanvas, 0, 0);
                }
            });

    }

    /**Allows to paste the fragment from the copyCanvas onto the mainCanvas*/
    private void paste(){
        mainCanvas.setOnMouseClicked(event -> {
            if(radio_paste.isSelected()) {
                copyFirstCanvasOntoSecondCanvas(copyCanvas, mainCanvas, event.getX(), event.getY());
            }
        });
    }

    /**Allows to copy the first canvas onto the second canvas.*/
    public static void copyFirstCanvasOntoSecondCanvas(Canvas firstCanvas, Canvas secondCanvas,
                                                 double shiftX, double shiftY){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = firstCanvas.snapshot(params, null);
        secondCanvas.getGraphicsContext2D().drawImage(image, shiftX, shiftY);

    }

    /**Allows to change the cursor*/
    private void changeCursor( String name){
        Scene scene = mainCanvas.getScene();
        Image img = new Image(getClass().getResourceAsStream("./icons/" + name));
        ImageCursor cursor = new ImageCursor(img, 30, 30);
        scene.setCursor(cursor);
    }

    /**Allows to save the picture onto the canvas in png-file.*/
    private void save(){
        try {
            Image snapshot = this.mainCanvas.snapshot((SnapshotParameters)null, (WritableImage)null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, (BufferedImage)null), "png", new File("paint.png"));
        } catch (Exception var2) {
            System.out.print("Failed to save image:" + var2);
        }
    }
}
