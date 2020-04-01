package sample;


public class AddWindow extends ChildWindow {
    AddWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.add();
    }

    private void add(){
        this.button.setText("Add");
        this.handler();
    }

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
