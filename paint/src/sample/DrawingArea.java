package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;

public class DrawingArea extends WorkingArea {

    protected GraphicsContext mainContext = mainCanvas.getGraphicsContext2D();
    private double xEvent = 0;
    private double yEvent = 0;
    private double size = 0;

    public DrawingArea(BorderPane borderPane,
                       double sizeX,
                       double sizeY) {
        super(borderPane, sizeX, sizeY);
        this.handler();
    }

    private void handler(){
            radio_pencil.setOnAction(e ->{
                Pencil pencil = new Pencil(this.mainContext,
                        this.size, colorPicker, brushSize);
            });

            radio_erase.setOnAction(e->{
                Erase erase = new Erase(this.mainContext,
                        this.size, brushSize);
            });

            radio_line.setOnAction(e->{
                Line line = new Line(this.mainContext, this.colorPicker, this.brushSize);

            });

    }


}
