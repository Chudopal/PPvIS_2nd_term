package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**This class is drawing ovals with animation*/
public class DrawOval extends DrawFigure {
    private ColorPicker colorPicker;
    private TextField textField;
    private RadioButton radio_oval;
    private double beginX;
    private double beginY;

    /**The constructor of class
     * @param mainContext is Graphics context of the visible main canvas,
     * @param buffContext is Graphics context of the invisible buff canvas,
     * @param colorPicker is where from the oval get a color,
     * @param textField is where from the oval get a size,
     * @param radio_oval if it is clicked, the oval will be drawn.*/
    public DrawOval(GraphicsContext mainContext, GraphicsContext buffContext,
                    ColorPicker colorPicker, TextField textField, RadioButton radio_oval){
        super(mainContext, buffContext);
        this.colorPicker = colorPicker;
        this.textField = textField;
        this.radio_oval = radio_oval;
        this.draw();
    }

    /**Allows to draw oval onto the screen.
     * When a user clicked, the program save a location of his click
     * and use it like a begin point of a figure*/
    private void draw(){
        mainContext.getCanvas().setOnMousePressed(e->{
            if(radio_oval.isSelected()) {
                this.beginX = e.getX();
                this.beginY = e.getY();
                this.mainContext.setStroke(this.colorPicker.getValue());
                this.mainContext.setLineWidth(Double.parseDouble(this.textField.getText()));
                this.copyMainToBuf();
            }
        });

        mainContext.getCanvas().setOnMouseDragged(e->{
            if(radio_oval.isSelected()) {
                this.clearCanvas();
                this.copyBufToMain();
                Figure rectangle = new Figure(this.beginX, this.beginY, e.getX(), e.getY());
                this.mainContext.strokeOval(rectangle.getBeginX(), rectangle.getBeginY(),
                        rectangle.getXSide(), rectangle.getYSide());
            }
        });

        mainContext.getCanvas().setOnMouseReleased(e->{
            if(radio_oval.isSelected()) {
                this.copyMainToBuf();
            }
        });
    }
}
