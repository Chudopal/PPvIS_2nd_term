package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**This class is drawing a rectangle onto the canvas with animation.*/
public class DrawRectangle extends DrawFigure {
    protected ColorPicker colorPicker;
    protected TextField textField;
    private Figure rectangle;
    protected double beginX;
    protected double beginY;
    private RadioButton radio_rect;

    /**This is rectangle's constructor. It initialises the DrawFigure class and calls the
    * method draw.
    * @param mainContext is Graphics context of the visible main canvas,
    * @param buffContext is Graphics context of the invisible buff canvas,
    * @param colorPicker is where from the rectangle get a color,
    * @param textField is where from the rectangle get a size,
    * @param radio_rect if it is clicked, the rectangle will be drawn.*/
    public DrawRectangle(GraphicsContext mainContext, GraphicsContext buffContext,
                         ColorPicker colorPicker, TextField textField, RadioButton radio_rect){
        super(mainContext, buffContext);
        this.colorPicker = colorPicker;
        this.radio_rect = radio_rect;
        this.textField = textField;
        this.draw();
    }

    /**This method draws the rectangle.
     * When a user clicked, the program save a location of his click
     * and use it like a begin point of a figure.*/
    private void draw(){
        mainContext.getCanvas().setOnMousePressed(e->{
            if (radio_rect.isSelected()) {
                this.beginX = e.getX();
                this.beginY = e.getY();
                this.mainContext.setStroke(this.colorPicker.getValue());
                this.mainContext.setLineWidth(Double.parseDouble(this.textField.getText()));
                this.copyMainToBuf();
            }
        });

        mainContext.getCanvas().setOnMouseDragged(e->{
            if (radio_rect.isSelected()) {
                this.clearCanvas();
                this.copyBufToMain();
                rectangle = new Figure(this.beginX, this.beginY, e.getX(), e.getY());
                this.mainContext.strokeRect(rectangle.getBeginX(), rectangle.getBeginY(),
                        rectangle.getXSide(), rectangle.getYSide());
            }
        });

        mainContext.getCanvas().setOnMouseReleased(e->{
            if (radio_rect.isSelected()) {
                this.copyMainToBuf();
            }
        });
    }

    public double getBeginX(){ return this.beginX; }

    public double getBeginY(){ return this.beginY; }

    public double getXSide(){return rectangle.getXSide(); }

    public double getYSide(){return rectangle.getYSide(); }
}
