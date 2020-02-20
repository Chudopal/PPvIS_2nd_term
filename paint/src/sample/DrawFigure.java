package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class DrawFigure {
    protected GraphicsContext mainContext;
    protected GraphicsContext bufferContext;

    public DrawFigure(GraphicsContext mainContext, GraphicsContext bufferContext){
        this.mainContext = mainContext;
        this.bufferContext = bufferContext;
    }

    protected void copyBufToMain(){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = bufferContext.getCanvas().snapshot(params, null);
        mainContext.drawImage(image, 0, 0);
    }

    protected void copyMainToBuf(){
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        WritableImage image = mainContext.getCanvas().snapshot(params, null);
        bufferContext.drawImage(image, 0, 0);
    }

    protected void clearCanvas(){
        mainContext.clearRect(0, 0, bufferContext.getCanvas().getHeight(),
                bufferContext.getCanvas().getWidth());
    }
}
