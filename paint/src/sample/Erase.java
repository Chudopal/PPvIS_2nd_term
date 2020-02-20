package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Erase {
    private GraphicsContext mainContext;
    private GraphicsContext buffContext;
    private TextField sizeBrush;

    public Erase(GraphicsContext mainContext, GraphicsContext buffContext,
                 double size, TextField sizeBrush){
        this.mainContext = mainContext;
        this.buffContext = buffContext;
        this.sizeBrush = sizeBrush;
        draw();
    }

    private void draw(){
        this.mainContext.getCanvas().setOnMouseDragged(e -> {
            double size = Double.parseDouble(this.sizeBrush.getText());
            double xEvent = e.getX() - size / 2;
            double yEvent = e.getY() - size / 2;
            this.mainContext.clearRect(xEvent, yEvent, size, size);
            this.buffContext.clearRect(xEvent, yEvent, size, size);
        });
    }
}
