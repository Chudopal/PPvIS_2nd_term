package view;

import controller.FootballerController;

/** Window for find record in list of footballers
 */
public class FindWindow extends ChildWindow {

    /** This is constructor of class
     * @param sizeX - x-coordinate size of window,
     * @param sizeY - y-coordinate size of window,
     * @param footballerController - controller of footballers.
     */
    FindWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.find();
    }

    /** This is method for search records in maim list.
     */
    private void find(){
        this.button.setText("Find");
        this.button.setOnAction(e -> {
            String line = "";
            if (this.surName.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.surName.getText() + "} ";
            }
            if (this.firstName.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.firstName.getText() + "} ";
            }
            if (this.middleName.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.middleName.getText() + "} ";
            }
            if (this.dateOfBirth.getValue() == null) {
                line += "{} ";
            } else {
                line += "{" + this.dateOfBirth.getValue().toString() + "} ";
            }
            if (this.team.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.team.getText() + "} ";
            }
            if (this.homeCity.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.homeCity.getText() + "} ";
            }
            if (this.structure.getText().equals("")) {
                line += "{} ";
            } else {
                line += "{" + this.structure.getText() + "} ";
            }
            if (this.position.getText().equals("")) {
                line += "{}";
            } else {
                line += "{" + this.position.getText() + "}";
            }
            this.table.setFootballers(footballerController.find(line));
        });
    }
}
