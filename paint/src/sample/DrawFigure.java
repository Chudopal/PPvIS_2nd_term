package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class DrawFigure {
    protected GraphicsContext mainContext;
    protected Canvas bufferCanvas = new Canvas();
    protected GraphicsContext bufferContext = bufferCanvas.getGraphicsContext2D();

    public DrawFigure(GraphicsContext mainContext){
        this.mainContext = mainContext;
        this.bufferCanvas.setHeight(this.mainContext.getCanvas().getHeight());
        this.bufferCanvas.setWidth(this.mainContext.getCanvas().getWidth());
    }

    protected void copyBufToMain(){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = bufferCanvas.snapshot(params, null);
        mainContext.drawImage(image, 0, 0);
    }

    protected void copyMainToBuf(){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = mainContext.getCanvas().snapshot(params, null);
        bufferContext.drawImage(image, 0, 0);
    }

    protected void clearCanvas(){
        mainContext.clearRect(0, 0, bufferCanvas.getHeight(), bufferCanvas.getWidth());
    }
}
