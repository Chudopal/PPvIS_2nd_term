package view;

import controller.FootballerController;
import model.Footballer;

public class DeleteWindow extends ChildWindow {
    DeleteWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.add();
    }

    private void add(){
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
