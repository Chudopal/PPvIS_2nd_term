package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Rectangle extends DrawFigure {
    protected ColorPicker colorPicker = new ColorPicker();
    protected TextField textField = new TextField();
    private Figure rectangle;
    protected double beginX;
    protected double beginY;
    protected double endX;
    protected double endY;

    public Rectangle(GraphicsContext mainContext, GraphicsContext buffContext,
                     ColorPicker colorPicker, TextField textField){
        super(mainContext, buffContext);
        this.colorPicker = colorPicker;
        this.textField = textField;
        this.draw();
    }

    public Rectangle(GraphicsContext mainContext, GraphicsContext buffContext,
                     Color color, double size){
        super(mainContext, buffContext);
        this.copyRect(color, size);
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
            rectangle = new Figure(this.beginX, this.beginY, e.getX(), e.getY());
            this.mainContext.strokeRect(rectangle.getBeginX(), rectangle.getBeginY(),
                    rectangle.getXSide(), rectangle.getYSide());
        });

        mainContext.getCanvas().setOnMouseReleased(e->{
            this.copyMainToBuf();
            this.endX = e.getX();
            this.endY = e.getY();
        });
    }

    private void copyRect(Color color, double size){
        mainContext.getCanvas().setOnMousePressed(e->{
            this.beginX = e.getX();
            this.beginY = e.getY();
            this.mainContext.setStroke(color);
            this.mainContext.setLineWidth(size);
            this.copyMainToBuf();
        });

        mainContext.getCanvas().setOnMouseDragged(e->{
            this.clearCanvas();
            this.copyBufToMain();
            rectangle = new Figure(this.beginX, this.beginY, e.getX(), e.getY());
            this.mainContext.strokeRect(rectangle.getBeginX(), rectangle.getBeginY(),
                    rectangle.getXSide(), rectangle.getYSide());
        });

        mainContext.getCanvas().setOnMouseReleased(e->{
            this.copyMainToBuf();
            this.endX = e.getX();
            this.endY = e.getY();
        });
    }

    public double getBeginX(){ return this.beginX; }

    public double getBeginY(){ return this.beginY; }

    public double getXSide(){return Math.abs(endX - beginX); }

    public double getYSide(){return Math.abs(endY - beginY); }

}
