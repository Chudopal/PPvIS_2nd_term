package sample;

import com.sun.prism.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;

public class DrawingArea extends WorkingArea {

    private Canvas bufferCanvas = new Canvas();
    private GraphicsContext bufferContext = bufferCanvas.getGraphicsContext2D();
    protected GraphicsContext mainContext = mainCanvas.getGraphicsContext2D();

    private double xEvent = 0;
    private double yEvent = 0;
    private double size = 0;

    public DrawingArea(BorderPane borderPane,
                       double sizeX,
                       double sizeY) {
        super(borderPane, sizeX, sizeY);
        this.bufferCanvas.setWidth(sizeX);
        this.bufferCanvas.setHeight(sizeY);
        handler();
    }

    private void handler(){
        mainCanvas.setOnMouseDragged(e -> {
            this.size = Double.parseDouble(brushSize.getText());
            this.xEvent = e.getX() - size / 2;
            this.yEvent = e.getY() - size / 2;
            if(radio_pencil.isSelected()) {
                pencilEvent();
            }
            if(radio_erase.isSelected()){
                eraseEvent();
            }
        });
    }

    private void pencilEvent(){
        mainContext.setFill(colorPicker.getValue());
        mainContext.fillRect(xEvent, yEvent, size, size);
    }

    private void eraseEvent(){
        mainContext.clearRect(xEvent, yEvent, size, size);
    }
}
