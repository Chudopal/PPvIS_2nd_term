package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;


public class Pencil {
    private GraphicsContext mainContext;
    private ColorPicker colorPicker;
    private TextField sizeBrush;

    public Pencil(GraphicsContext mainContext, ColorPicker colorPicker,
                  TextField sizeBrush){
        this.mainContext = mainContext;
        this.sizeBrush = sizeBrush;
        this.colorPicker = colorPicker;
        draw();
    }

    private void draw(){
        this.mainContext.getCanvas().setOnMouseDragged(e -> {
            double size = Double.parseDouble(this.sizeBrush.getText());
            double xEvent = e.getX() - size / 2;
            double yEvent = e.getY() - size / 2;
            mainContext.setFill(this.colorPicker.getValue());
            mainContext.fillRect(xEvent, yEvent, size, size);
        });
    }
}
