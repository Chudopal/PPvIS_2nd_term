package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Copy{
    private Rectangle copyRectangle;
    private Canvas copyCanvas;
    private Canvas reserveCanvas;

    public Copy(GraphicsContext mainContext, GraphicsContext buffContext) {
        this.reserveCanvas = new Canvas(mainContext.getCanvas().getWidth(),
                mainContext.getCanvas().getHeight());
        this.copyCanvas = new Canvas(mainContext.getCanvas().getWidth(),
                mainContext.getCanvas().getHeight());
        this.copyCanvases(mainContext.getCanvas(), this.reserveCanvas);
        this.copyRectangle = new Rectangle(mainContext, buffContext, Color.BLACK, 1);
        this.copyPartOfMainCanvasOntoCopyCanvas();
        mainContext.clearRect(0,0, mainContext.getCanvas().getWidth(),
                mainContext.getCanvas().getHeight());
        buffContext.clearRect(0,0, buffContext.getCanvas().getWidth(),
                buffContext.getCanvas().getHeight());
        this.copyCanvases(reserveCanvas, mainContext.getCanvas());
    }

    private void copyPartOfMainCanvasOntoCopyCanvas(){
        this.copyCanvasWithShift(this.reserveCanvas, this.copyCanvas);
        copyCanvas.getGraphicsContext2D().clearRect(copyRectangle.getXSide(), 0,
                this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
        copyCanvas.getGraphicsContext2D().clearRect(0, copyRectangle.getYSide(),
                copyRectangle.getXSide(), this.copyCanvas.getHeight() - copyRectangle.getYSide());
    }

    private void copyCanvasWithShift(Canvas firstCanvas, Canvas secondCanvas){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = firstCanvas.snapshot(params, null);
        secondCanvas.getGraphicsContext2D().drawImage(image, -copyRectangle.getBeginX(), -copyRectangle.getBeginY());
    }

    private void copyCanvases(Canvas firstCanvas, Canvas secondCanvas){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = firstCanvas.snapshot(params, null);
        secondCanvas.getGraphicsContext2D().drawImage(image, 0, 0);
    }

    public Canvas getCopyCanvas(){ return this.copyCanvas; }
}
