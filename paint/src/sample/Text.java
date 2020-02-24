package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Text {
    private GraphicsContext mainContext;
    private RadioButton radio_text;
    private ColorPicker colorPicker;
    private TextField textPrint;
    private TextField brushSize;

    public Text(GraphicsContext mainContext, RadioButton radio_text,
                ColorPicker colorPicker, TextField textPrint, TextField brushSize){
        this.mainContext = mainContext;
        this.radio_text = radio_text;
        this.colorPicker = colorPicker;
        this.textPrint = textPrint;
        this.brushSize = brushSize;
        this.putOntoTheScreen();
    }

    private void putOntoTheScreen(){
        mainContext.getCanvas().setOnMouseClicked(e->{
            if(radio_text.isSelected()){
                Canvas timeCanvas = new Canvas(mainContext.getCanvas().getWidth(), mainContext.getCanvas().getHeight());
                Canvas textCanvas = new Canvas(mainContext.getCanvas().getWidth(),mainContext.getCanvas().getHeight());
                timeCanvas.getGraphicsContext2D().setStroke(this.colorPicker.getValue());
                //timeCanvas.getGraphicsContext2D().setTransform(1, 0, 0, 1, 0, 0);
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
