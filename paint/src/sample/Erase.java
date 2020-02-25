package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;

/**This class allows to clear the main and buffer canvas*/
public class Erase {
    private GraphicsContext mainContext;
    private GraphicsContext buffContext;
    private TextField sizeBrush;

    /**The constructor of erase class.
     * @param mainContext is Graphics context of the visible main canvas,
     * @param buffContext is Graphics context of the invisible buff canvas,
     * @param sizeBrush is a size of brush.*/
    public Erase(GraphicsContext mainContext, GraphicsContext buffContext,
                 TextField sizeBrush){
        this.mainContext = mainContext;
        this.buffContext = buffContext;
        this.sizeBrush = sizeBrush;
        clear();
    }

    /**Allow to make clear the main and buffer canvas.*/
    private void clear(){
        this.mainContext.getCanvas().setOnMouseDragged(e -> {
            double size = Double.parseDouble(this.sizeBrush.getText());
            double xEvent = e.getX() - size / 2;
            double yEvent = e.getY() - size / 2;
            this.mainContext.clearRect(xEvent, yEvent, size, size);
            this.buffContext.clearRect(xEvent, yEvent, size, size);
        });
    }
}
