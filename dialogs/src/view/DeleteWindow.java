package view;

import controller.FootballerController;
import model.Footballer;

/** Class for creating delete window.
 */
public class DeleteWindow extends ChildWindow {

    /** This is constructor of class
     * @param sizeX - x-coordinate size of window,
     * @param sizeY - y-coordinate size of window,
     * @param footballerController - controller of footballers.
     */
    DeleteWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.del();
    }

    /** Method for delete object from list.
     */
    private void del(){
        this.button.setText("Delete");
        this.button.setOnAction(e -> {
            footballerController.delete(new Footballer(
                    this.surName.getText(),
                    this.firstName.getText(),
                    this.middleName.getText(),
                    this.dateOfBirth.getValue(),
                    this.team.getText(),
                    this.homeCity.getText(),
                    this.structure.getText(),
                    this.position.getText()
            ));
        });
    }
}
