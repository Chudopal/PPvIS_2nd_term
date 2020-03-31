package sample;

import java.util.ArrayList;

public class DeleteWindow extends ChildWindow {
    DeleteWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.add();
    }

    private void add(){
        this.button.setText("Delete");
    }

}
