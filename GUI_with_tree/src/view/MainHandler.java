package view;

import javafx.stage.Stage;

public class MainHandler extends MainWindow {

    private String strOfDigits = "";

    public MainHandler(Stage primaryStage){
        super(primaryStage);
        this.setHandlerForCalculatorDisplay();
    }

    private void setHandlerForCalculatorDisplay(){
        this.buttonDigitList.forEach(button -> {
            button.setOnAction(e->{
                strOfDigits = viewStr.getText();
                strOfDigits += button.getText();
                viewStr.setText(strOfDigits);
            });
        });
        this.buttonActionList.forEach(button -> {
            button.setOnAction(e->{
                strOfDigits = viewStr.getText();
                strOfDigits += button.getText();
                viewStr.setText(strOfDigits);
            });
        });
        this.isPowerMode.setOnAction(e->{
            if(isPowerMode.isSelected()){
                buttons.add(powerBtn, 0, 4);
            }else{
                buttons.getChildren().remove(powerBtn);
            }
        });
    }

}
