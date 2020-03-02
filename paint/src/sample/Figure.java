package sample;

/**The parent class for each figure on the canvas*/

public class Figure implements FigureInterface {
    private double beginX = 0;
    private double beginY = 0;
    private double endX = 0;
    private double endY = 0;

    /**The constructor of figure's class. Also this method
     * make begin in the top left pint of the figure.
     * @param beginX  the first point on the x-coordinate of figure,
     * @param beginY the first point on the y-coordinate of figure,
     * @param endX the last point on the x-coordinate of figure,
     * @param endY the last point on the y-coordinate of figure.
     */
    public Figure(double beginX, double beginY,
                  double endX, double endY) {
        this.beginX = beginX > endX ? endX : beginX;
        this.beginY = beginY > endY ? endY : beginY;
        this.endX = endX < beginX ? beginX : endX;
        this.endY = endY < beginY ? beginY : endY;
    }

    public double getBeginX(){
        return this.beginX;
    }

    public double getBeginY() {
        return this.beginY;
    }

    /**This method is calculating length of figure's x-side.
     * @return length of the x-side.
     */
    public double getXSide(){
        return Math.abs(this.endX - this.beginX);
    }

    /**This method is calculating length of figure's y-side.
     * @return length of the y-side.
     */
    public double getYSide(){
        return Math.abs(endY - this.beginY);
    }

    @Override
    public String log() {
        return endX+", "+endY;
    }
}