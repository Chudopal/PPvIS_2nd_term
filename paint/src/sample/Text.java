package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import javax.swing.*;

public class Text {
    private GraphicsContext mainContext;
    private GraphicsContext buffContext;
    private RadioButton radio_text;
    private ColorPicker colorPicker;
    private TextField textPrint;
    private TextField brushSize;

    public Text(GraphicsContext mainContext, GraphicsContext buffContext, RadioButton radio_text,
                ColorPicker colorPicker, TextField textPrint, TextField brushSize){
        this.mainContext = mainContext;
        this.buffContext = buffContext;
        this.radio_text = radio_text;
        this.colorPicker = colorPicker;
        this.textPrint = textPrint;
        this.brushSize = brushSize;
        this.putOntoTheScreen();
    }

    private void putOntoTheScreen(){
        mainContext.getCanvas().setOnMouseClicked(e->{
            if(radio_text.isSelected()){
                mainContext.setStroke(this.colorPicker.getValue());
                mainContext.setLineWidth(1);
                //Affine affine = mainContext.getTransform();
                //mainContext.setTransform(1, 0, 0, 1, 0, 0);
                //mainContext.clearRect(0, 0, mainContext.getCanvas().getWidth(), mainContext.getCanvas().getHeight());
                //mainContext.setTransform(affine);

                double w = mainContext.getCanvas().getWidth();
                double h = mainContext.getCanvas().getHeight();
                mainContext.setTransform(1, 0, 0, 1, 0, 0);
                //mainContext.clearRect(0, 0, w, h);

                double z = Double.parseDouble(brushSize.getText());

                // Масштабирование в левый верхний угол:
                //gc.setTransform(z, 0, 0, z, 0, 0);

                // Масштабирование в центр canvas:
                mainContext.setTransform(z, 0, 0, z, (w - w * z) / 2.0, (h - h * z) / 2.0);


                //mainContext.setTransform(1, 0, 0, 1, 0, 0);
                //buffContext.setTransform(1, 0, 0, 1, 0, 0);
                //mainContext.setTransform(z, 0, 0, z, (w - w * z) / 2.0, (h - h * z) / 2.0);
                this.printText(textPrint.getText(), e.getX(), e.getY());
            }
        });
    }

    private void printText(String str, double beginX, double beginY){
        mainContext.strokeText(str, beginX, beginY, 400);

    }
}
