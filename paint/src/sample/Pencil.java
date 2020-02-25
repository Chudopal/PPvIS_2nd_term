package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**The class allows drawing like a pencil*/
public class Pencil {
    private GraphicsContext mainContext;
    private ColorPicker colorPicker;
    private TextField sizeBrush;
    private RadioButton radio_pencil;

    /**The constructor of the Pencil class.
     * @param mainContext is Graphics context of the visible main canvas,
     * @param colorPicker allows change color of the brush,
     * @param sizeBrush is a size of brush,
     * @param radio_pencil if it is clicked, the pencil will draw.*/
    public Pencil(GraphicsContext mainContext, ColorPicker colorPicker,
                  TextField sizeBrush, RadioButton radio_pencil){
        this.mainContext = mainContext;
        this.sizeBrush = sizeBrush;
        this.colorPicker = colorPicker;
        this.radio_pencil = radio_pencil;
        draw();
    }

    /**This method is showing the picture on the canvas*/
    private void draw(){
        this.mainContext.getCanvas().setOnMouseDragged(e -> {
            if(radio_pencil.isSelected()) {
                double size = Double.parseDouble(this.sizeBrush.getText());
                double xEvent = e.getX() - size / 2;
                double yEvent = e.getY() - size / 2;
                mainContext.setFill(this.colorPicker.getValue());
                mainContext.fillRect(xEvent, yEvent, size, size);
            }
        });
    }
}
