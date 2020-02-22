package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Paste {
    public Paste(GraphicsContext buffContext, GraphicsContext mainContext, GraphicsContext copyContext){
            mainContext.getCanvas().setOnMouseClicked(event -> {
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.TRANSPARENT);
                WritableImage image = copyContext.getCanvas().snapshot(params, null);
                mainContext.drawImage(image, event.getX(), event.getY());
                //buffContext.drawImage(image, e.getX(), e.getY());
            });
    }

}
