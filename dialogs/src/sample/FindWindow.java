package sample;

import java.util.ArrayList;

public class FindWindow extends ChildWindow {
    ArrayList<Footballer> footballers = new ArrayList<>();

    FindWindow(double sizeX, double sizeY, FootballerController footballerController){
        super(sizeX, sizeY, footballerController);
        this.find();
    }

    private void find(){
        this.button.setText("Find");
        this.button.setOnAction(e -> {
            for(Footballer footballer: footballerController.getFootballers()){
                boolean equal = false;
                if(this.dateOfBirth != null){
                    if(this.dateOfBirth.equals(footballer.getBirthDate())){
                        equal = true;
                    }
                }
                if(!this.surName.equals("")){
                    if(this.surName.equals(footballer.getSurName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.firstName.equals("")){
                    if(this.firstName.equals(footballer.getFirstName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.middleName.equals("")){
                    if(this.middleName.equals(footballer.getMiddleName())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.homeCity.equals("")){
                    if(this.homeCity.equals(footballer.getHomeCity())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.structure.equals("")){
                    if(this.structure.equals(footballer.getCommandStructure())){
                        equal = true;
                    }else{
                        equal = false;
                    }

                }
                if(!this.team.equals("")){
                    if(this.team.equals(footballer.getTeam())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(!this.position.equals("")){
                    if(this.position.equals(footballer.getPosition())){
                        equal = true;
                    }else{
                        equal = false;
                    }
                }
                if(equal){
                    footballers.add(footballer);
                }
            }
            for(Footballer footballer: footballers){
                System.out.println(footballer.getSurName());
            }
        });
    }
}
