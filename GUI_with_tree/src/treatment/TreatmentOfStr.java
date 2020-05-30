package treatment;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreatmentOfStr {

    private Tree tree;
    private int power;
    private String primaryCharacters = "*/";
    private String secondaryCharacters = "+-";
    private String thirdCharacters = "√^";
    //private ArrayList<String> set;

    public TreatmentOfStr(String str){
        tree = new Tree(str);
        this.createTree(tree.getRoot());
    }

    private void createTree(Node node){
        int numbOfBracket = 0;
        int i = 0;
        int findCharacter = 0;
        for(char character: node.getValue().toCharArray()){
            i++;
            if (character == '('){
                numbOfBracket++;
            }
            if (character == ')'){
                numbOfBracket--;
            }
            if (numbOfBracket == 0){
                if (thirdCharacters.indexOf(character) != -1){
                    findCharacter = i;
                    break;
                }
                if(findCharacter == 0 && secondaryCharacters.indexOf(character) != -1){
                    findCharacter = i;
                }
                if(primaryCharacters.indexOf(character) != -1){
                    findCharacter = i;
                }
            }
        }
        String firstPart = node.getValue().substring(0, findCharacter-1);
        String secondPart = node.getValue().substring(findCharacter);
        System.out.println(firstPart);
        System.out.println(node.getValue().toCharArray()[findCharacter-1]);
        System.out.println(secondPart);

    }



    public int getResult(){
        int result = 0;

        return result;
    }
}
