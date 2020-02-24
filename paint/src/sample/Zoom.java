package sample;

import com.sun.prism.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

import java.awt.*;


public class Zoom {
    private GraphicsContext mainContext;
    private GraphicsContext buffContext;
    private Canvas trashCanvas;
    private GraphicsContext trashContext;
    private Button zoom_btn;

    public Zoom(GraphicsContext mainContext, GraphicsContext buffContext, double beginSizeX, Button zoom_btn){
        this.mainContext = mainContext;
        this.buffContext = buffContext;
        this.zoom_btn = zoom_btn;
        this.trashCanvas = new Canvas(mainContext.getCanvas().getWidth(),
                mainContext.getCanvas().getHeight());
        this.trashContext = trashCanvas.getGraphicsContext2D();

        if(mainContext.getCanvas().getWidth() == beginSizeX){
            zoom_btn.setText("ZoomX2");
            this.makeZoom(1.44);
        }
        else if(mainContext.getCanvas().getWidth() == 1.44*beginSizeX){
            this.makeZoom((1.0/1.44));
            this.makeZoom(1.7);
            zoom_btn.setText("ZoomX3");
        }
        else if(mainContext.getCanvas().getWidth() == 1.7*beginSizeX){
            this.makeZoom((1.0/1.7));
            zoom_btn.setText("Zoom");
        }
    }

    private void makeZoom(double coefficient){
        if(coefficient > 1){
            this.makeBigger(coefficient);
            this.makeTransform(coefficient);
            this.makeTransform(coefficient);
        } else {
            this.makeTransform(coefficient);
            this.makeTransform(coefficient);
            this.makeBigger(coefficient);
        }
        this.mainContext.clearRect(0, 0, this.mainContext.getCanvas().getWidth(), this.mainContext.getCanvas().getHeight());
        this.buffContext.clearRect(0, 0, this.buffContext.getCanvas().getWidth(), this.buffContext.getCanvas().getHeight());
        DrawingArea.copyFirstCanvasOntoSecondCanvas(trashCanvas, this.mainContext.getCanvas(), 0, 0);
        DrawingArea.copyFirstCanvasOntoSecondCanvas(trashCanvas, this.buffContext.getCanvas(), 0, 0);
    }

    private void makeTransform(double coefficient){
        trashContext.clearRect(0,0, trashContext.getCanvas().getWidth(), trashContext.getCanvas().getHeight());
        DrawingArea.copyFirstCanvasOntoSecondCanvas(mainContext.getCanvas(), trashCanvas, 0,0);
        //trashContext.setTransform(coefficient, 0, 0, coefficient, 0, 0);
        trashContext.setTransform(coefficient, 0, 0, coefficient, 0, 0);
    }

    private void makeBigger(double coefficient){
        mainContext.getCanvas().setWidth(mainContext.getCanvas().getWidth()*coefficient);
        mainContext.getCanvas().setHeight(mainContext.getCanvas().getHeight()*coefficient);

        buffContext.getCanvas().setWidth(buffContext.getCanvas().getWidth()*coefficient);
        buffContext.getCanvas().setHeight(buffContext.getCanvas().getHeight()*coefficient);

        trashContext.getCanvas().setWidth(trashContext.getCanvas().getWidth()*coefficient);
        trashContext.getCanvas().setHeight(trashContext.getCanvas().getHeight()*coefficient);
    }
}
