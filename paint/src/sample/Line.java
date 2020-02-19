package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class Line extends DrawFigure{

    private Figure line;
    private ColorPicker colorPicker;
    private TextField textField;
    private double beginX;
    private double beginY;

    public Line(GraphicsContext mainContext, ColorPicker colorPicker, TextField textField){
        super(mainContext);
        this.colorPicker = colorPicker;
        this.textField = textField;
        this.draw();
    }

    private void draw(){
        mainContext.getCanvas().setOnMousePressed(e->{
            //this.line.setBeginX(e.getX());
            //this.line.setBeginY(e.getY());
            beginX = e.getX();
            beginY = e.getY();
            this.bufferContext.setStroke(this.colorPicker.getValue());
            this.bufferContext.setLineWidth(Double.parseDouble(textField.getText()));
        });
        mainContext.getCanvas().setOnMouseDragged(e->{
            this.clearCanvas();
            this.copyBufToMain();
            this.mainContext.strokeLine(beginX, beginY, e.getX(), e.getY());
        });
        mainContext.getCanvas().setOnMouseReleased(e->{
            System.out.println("w");
            this.copyMainToBuf();
        });

    }

}
