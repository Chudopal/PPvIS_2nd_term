package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**This class allows draw lines*/
public class DrawLine extends DrawFigure{
    private ColorPicker colorPicker;
    private TextField textField;
    private RadioButton radio_line;
    private double beginX;
    private double beginY;

    /**The constructor of line class.
     * @param mainContext is Graphics context of the visible main canvas,
     * @param buffContext is Graphics context of the invisible buff canvas,
     * @param colorPicker is where from the rectangle get a color,
     * @param textField is where from the rectangle get a size,
     * @param radio_line if it is clicked, the rectangle will be drawn.
     * */
    public DrawLine(GraphicsContext mainContext, GraphicsContext buffContext,
                    ColorPicker colorPicker, TextField textField, RadioButton radio_line){
        super(mainContext, buffContext);
        this.colorPicker = colorPicker;
        this.textField = textField;
        this.radio_line = radio_line;
        this.draw();
    }

    /**This method draws the rectangle with animation.*/
    private void draw(){
        mainContext.getCanvas().setOnMousePressed(e->{
            if(radio_line.isSelected()) {
                this.beginX = e.getX();
                this.beginY = e.getY();
                this.mainContext.setStroke(this.colorPicker.getValue());
                this.mainContext.setLineWidth(Double.parseDouble(this.textField.getText()));
                this.copyMainToBuf();
            }
        });
        mainContext.getCanvas().setOnMouseDragged(e->{
            if(radio_line.isSelected()) {
                this.clearCanvas();
                this.copyBufToMain();
                this.mainContext.strokeLine(this.beginX, this.beginY, e.getX(), e.getY());
            }
        });
        mainContext.getCanvas().setOnMouseReleased(e->{
            if(radio_line.isSelected()) {
                this.copyMainToBuf();
            }
        });
    }
}
