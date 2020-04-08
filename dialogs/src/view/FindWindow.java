package view;

import controller.FootballerController;
import model.Footballer;

import java.util.ArrayList;
import java.util.List;

/** Window for find record in list of footballers
 */
public class FindWindow extends ChildWindow {
    List<Footballer> footballers = new ArrayList<>();

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
            for(Footballer footballer: footballerController.getFootballers()){
                boolean equal = false;
                if(this.dateOfBirth.getValue() != null){
                    if(this.dateOfBirth.equals(footballer.getBirthDate())){
                        equal = true;
                    }
                }
                if(!this.surName.getText().equals("")){
                    if(this.surName.getText().equals(footballer.getSurName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.firstName.getText().equals("")){
                    if(this.firstName.getText().equals(footballer.getFirstName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.middleName.getText().equals("")){
                    if(this.middleName.getText().equals(footballer.getMiddleName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.homeCity.getText().equals("")){
                    if(this.homeCity.getText().equals(footballer.getHomeCity())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.structure.getText().equals("")){
                    if(this.structure.getText().equals(footballer.getCommandStructure())){
                        equal = true;
                    }else{
                        equal = false;
                    }

                }
                if(!this.team.getText().equals("")){
                    if(this.team.getText().equals(footballer.getTeam())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.position.getText().equals("")){
                    if(this.position.getText().equals(footballer.getPosition())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(equal){
                    footballers.add(footballer);
                }
            }
            this.table.setFootballers(footballers);
        });
    }
}
