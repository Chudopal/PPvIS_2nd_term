package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**This class allows to create text*/
public class Text {
    private GraphicsContext mainContext;
    private RadioButton radio_text;
    private ColorPicker colorPicker;
    private TextField textPrint;
    private TextField brushSize;

    /**The constructor.
     * @param mainContext is Graphics context of the visible main canvas,
     * @param colorPicker is a color of text,
     * @param textPrint is a text,
     * @param brushSize is a size of text,
     * @param radio_text if it is clicked, the text will be drawn.*/
    public Text(GraphicsContext mainContext, RadioButton radio_text,
                ColorPicker colorPicker, TextField textPrint, TextField brushSize){
        this.mainContext = mainContext;
        this.radio_text = radio_text;
        this.colorPicker = colorPicker;
        this.textPrint = textPrint;
        this.brushSize = brushSize;
        this.putOntoTheScreen();
    }

    /**Allows to put the text onto the main canvas*/
    private void putOntoTheScreen(){
        mainContext.getCanvas().setOnMouseClicked(e->{
            if(radio_text.isSelected()){
                Canvas timeCanvas = new Canvas(mainContext.getCanvas().getWidth(), mainContext.getCanvas().getHeight());
                Canvas textCanvas = new Canvas(mainContext.getCanvas().getWidth(),mainContext.getCanvas().getHeight());
                timeCanvas.getGraphicsContext2D().setStroke(this.colorPicker.getValue());
                double z = Double.parseDouble(brushSize.getText());
                timeCanvas.getGraphicsContext2D().clearRect(0,0,timeCanvas.getWidth(), timeCanvas.getHeight());
                timeCanvas.getGraphicsContext2D().setTransform(z, 0, 0, z, 0, 0);
                timeCanvas.setWidth(mainContext.getCanvas().getWidth()*z);
                timeCanvas.setHeight(mainContext.getCanvas().getHeight()*z);
                timeCanvas.getGraphicsContext2D().strokeText(textPrint.getText(), e.getX(), e.getY(), 400);
                DrawingArea.copyFirstCanvasOntoSecondCanvas(timeCanvas, textCanvas, -e.getX() * z, -e.getY() * z + z*10);
                DrawingArea.copyFirstCanvasOntoSecondCanvas(textCanvas, mainContext.getCanvas(), e.getX(), e.getY());
            }
        });
    }
}
