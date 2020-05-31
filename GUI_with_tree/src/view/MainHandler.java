package view;

import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import treatment.TreatmentOfStr;
import tree.Node;
import tree.Tree;

public class MainHandler extends MainWindow {

    private String strOfDigits = "";
    private TreatmentOfStr treatmentOfStr;

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
        this.delBtn.setOnAction(e->{
            strOfDigits = "";
            viewStr.setText(strOfDigits);
        });
        this.resultBtn.setOnAction(e->{
            strOfDigits = viewStr.getText();
            treatmentOfStr = new TreatmentOfStr(strOfDigits);
            this.result.setText(Double.toString(treatmentOfStr.getResult()));
            TreeItem<String> parentItem = new TreeItem<>(treatmentOfStr.getTree().getRoot().getValue());
            createTreeView(treatmentOfStr.getTree().getRoot(), parentItem);
            this.tree.setRoot(parentItem);
        });
        this.leftTriangleBtn.setOnAction(e->{
            Tree currentTree = treatmentOfStr.coagulation();
            TreeItem<String> parentItem = new TreeItem<>(currentTree.getRoot().getValue());
            createTreeView(currentTree.getRoot(), parentItem);
            this.tree.setRoot(parentItem);
        });
        this.rightTriangleBtn.setOnAction(e->{
            Tree currentTree = treatmentOfStr.deployment();
            TreeItem<String> parentItem = new TreeItem<>(currentTree.getRoot().getValue());
            createTreeView(currentTree.getRoot(), parentItem);
            this.tree.setRoot(parentItem);
        });
    }

    private void createTreeView(Node node, TreeItem<String> parentItem){
        TreeItem<String> firstItem;
        TreeItem<String> secondItem;
        if (node.getLeft() != null || node.getRight() != null){
            if (node.getLeft() != null){
                firstItem = new TreeItem<>(node.getLeft().getValue());
                createTreeView(node.getLeft(), firstItem);
                parentItem.getChildren().add(firstItem);
            }
            if(node.getRight() != null){
                secondItem = new TreeItem<>(node.getRight().getValue());
                createTreeView(node.getRight(), secondItem);
                parentItem.getChildren().add(secondItem);
            }
        }
    }
}
