package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Oval extends DrawFigure {
    private ColorPicker colorPicker = new ColorPicker();
    private TextField textField = new TextField();
    private double beginX;
    private double beginY;

    public Oval(GraphicsContext mainContext, GraphicsContext buffContext,
                     ColorPicker colorPicker, TextField textField){
        super(mainContext, buffContext);
        this.colorPicker = colorPicker;
        this.textField = textField;
        this.draw();
    }

    private void draw(){
        mainContext.getCanvas().setOnMousePressed(e->{
            this.beginX = e.getX();
            this.beginY = e.getY();
            this.mainContext.setStroke(this.colorPicker.getValue());
            this.mainContext.setLineWidth(Double.parseDouble(this.textField.getText()));
            this.copyMainToBuf();
        });

        mainContext.getCanvas().setOnMouseDragged(e->{
            this.clearCanvas();
            this.copyBufToMain();
            Figure rectangle = new Figure(this.beginX, this.beginY, e.getX(), e.getY());
            this.mainContext.strokeOval(rectangle.getBeginX(), rectangle.getBeginY(),
                    rectangle.getXSide(), rectangle.getYSide());
        });

        mainContext.getCanvas().setOnMouseReleased(e->{
            this.copyMainToBuf();
        });
    }
}
