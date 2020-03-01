package sample;

import javafx.scene.canvas.GraphicsContext;

/**This class is the parent class for each figure on the canvas.
 * It copies the main canvas onto the buff canvas and buff canvas onto the
 * main canvas each time after drawing.*/
public class DrawFigure implements FigInterface {
    protected GraphicsContext mainContext;
    protected GraphicsContext bufferContext;

    /**The constructor.
     * @param mainContext is Graphics context of the visible main canvas,
     * @param bufferContext is Graphics context of the invisible buff canvas.*/
    public DrawFigure(GraphicsContext mainContext, GraphicsContext bufferContext){
        this.mainContext = mainContext;
        this.bufferContext = bufferContext;
    }

    public void copyBufToMain(){
        DrawingArea.copyFirstCanvasOntoSecondCanvas(bufferContext.getCanvas(), mainContext.getCanvas(), 0,0);
    }

    public void copyMainToBuf(){
        DrawingArea.copyFirstCanvasOntoSecondCanvas(mainContext.getCanvas(), bufferContext.getCanvas(), 0,0);
    }

    /**Clear the main canvas*/
    public void clearCanvas(){
        mainContext.clearRect(0, 0, bufferContext.getCanvas().getHeight(),
                bufferContext.getCanvas().getWidth());
    }
}
