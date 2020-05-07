package view;


import controller.FootballerController;
import model.Footballer;

/** The window for adding footballers
 * to main list.
 */
public class AddWindow extends ChildWindow {
    /** The constructor of class
     * @param sizeX - x-coordinate size of window,
     * @param sizeY - y-coordinate size of window,
     * @param footballerController - controller of footballers.
     */
    AddWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.add();
    }

    /** The method for addition
     * footballers to main list.
     */
    private void add(){
        this.button.setText("Add");
        this.handler();
    }

    /** If click on "add"-button, footballers will
     * be added.
     */
    private void handler(){
        this.button.setOnAction(e -> {
            footballerController.add(new Footballer(
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
