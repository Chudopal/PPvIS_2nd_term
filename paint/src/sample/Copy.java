package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Copy{
    private CopyRectangle copyRectangle;
    private Canvas copyCanvas;
    private Canvas reserveCanvas;

    public Copy(GraphicsContext mainContext, GraphicsContext buffContext) {
        mainContext.getCanvas().setOnMouseClicked(event-> {
            this.reserveCanvas = new Canvas(mainContext.getCanvas().getWidth(),
                    mainContext.getCanvas().getHeight());
            this.copyCanvas = new Canvas(mainContext.getCanvas().getWidth(),
                    mainContext.getCanvas().getHeight());
            this.copyCanvases(mainContext.getCanvas(), buffContext.getCanvas());
            this.copyCanvases(buffContext.getCanvas(), this.reserveCanvas);
            this.copyRectangle = new CopyRectangle(mainContext, buffContext, Color.BLACK, 1);
        });
            mainContext.getCanvas().setOnMouseReleased(event -> {
                this.copyPartOfMainCanvasOntoCopyCanvas();
                mainContext.clearRect(0, 0, mainContext.getCanvas().getWidth(),
                        mainContext.getCanvas().getHeight());
                buffContext.clearRect(0, 0, buffContext.getCanvas().getWidth(),
                        buffContext.getCanvas().getHeight());
                this.copyCanvases(reserveCanvas, mainContext.getCanvas());
                this.copyCanvases(reserveCanvas, buffContext.getCanvas());
            });
    }

    private void copyPartOfMainCanvasOntoCopyCanvas(){
        this.copyCanvasWithShift();
        copyCanvas.getGraphicsContext2D().clearRect(copyRectangle.getXSide(), 0,
                this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
        System.out.println(copyRectangle.getXSide());
        copyCanvas.getGraphicsContext2D().clearRect(0, copyRectangle.getYSide(),
                this.copyCanvas.getWidth(), this.copyCanvas.getHeight());
        System.out.println(copyRectangle.getYSide());
    }

    private void copyCanvasWithShift(){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = this.reserveCanvas.snapshot(params, null);
        this.copyCanvas.getGraphicsContext2D().drawImage(image, -copyRectangle.getBeginX(), -copyRectangle.getBeginY());
    }

    private void copyCanvases(Canvas firstCanvas, Canvas secondCanvas){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = firstCanvas.snapshot(params, null);
        secondCanvas.getGraphicsContext2D().drawImage(image, 0, 0);
    }

    public Canvas getCopyCanvas(){
        System.out.println("Here");
        return this.copyCanvas; }
}
