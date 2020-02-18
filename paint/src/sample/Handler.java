package sample;

import com.sun.prism.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Handler {
    private Canvas bufferCanvas;
    private GraphicsContext bufferContext = bufferCanvas.getGraphicsContext2D();

    public Handler(GraphicsContext mainContext){
        double height = mainContext.getCanvas().getHeight();
        double width = mainContext.getCanvas().getWidth();
        bufferCanvas.setHeight(height);
        bufferCanvas.setWidth(width);
        event();
    }

    private void event(){

    }

    void copyCanvas(){

    }
}
