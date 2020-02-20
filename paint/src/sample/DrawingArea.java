package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;

public class DrawingArea extends WorkingArea {

    protected GraphicsContext mainContext = mainCanvas.getGraphicsContext2D();
    protected GraphicsContext buffContext = buffCanvas.getGraphicsContext2D();
    private double size = 0;
    private Copy copy;


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
                Erase erase = new Erase(this.mainContext, this.buffContext,
                        this.size, brushSize);
            });

            radio_line.setOnAction(e->{
                Line line = new Line(this.mainContext, this.buffContext, this.colorPicker, this.brushSize);

            });

            radio_rectangle.setOnAction(e->{
                Rectangle rectangle = new Rectangle(this.mainContext, this.buffContext, this.colorPicker, this.brushSize);
            });

            radio_oval.setOnAction(e->{
                Oval oval = new Oval(this.mainContext, this.buffContext, this.colorPicker, this.brushSize);
            });

            radio_copy.setOnAction(e-> {
                this.copy = new Copy(this.mainContext, this.buffContext);
            });

            radio_paste.setOnAction(e-> {
               // Paste paste = new Paste();
            });
    }
}
