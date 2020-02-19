package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Erase {
    private GraphicsContext mainContext;
    private TextField sizeBrush;

    public Erase(GraphicsContext mainContext, double size,
                      TextField sizeBrush){
        this.mainContext = mainContext;
        this.sizeBrush = sizeBrush;
        draw();
    }

    private void draw(){
        this.mainContext.getCanvas().setOnMouseDragged(e -> {
            double size = Double.parseDouble(this.sizeBrush.getText());
            double xEvent = e.getX() - size / 2;
            double yEvent = e.getY() - size / 2;
            mainContext.clearRect(xEvent, yEvent, size, size);
        });
    }
}
