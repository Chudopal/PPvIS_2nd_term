package treatment;

import tree.Node;
import tree.Tree;
import view.Main;


public class TreatmentOfStr {

    private Tree tree;
    private Tree currentTree;
    private int power;
    private final String primaryCharacters = "√^";
    private final String secondaryCharacters = "*/%";
    private final String thirdCharacters = "+-";

    public TreatmentOfStr(String str){
        tree = new Tree(str);
        this.createTree(tree.getRoot());
        currentTree = tree;
    }

    private void createTree(Node node){
        if (this.isSignInExpresion(node.getValue())){
            this.createNode(node);
            this.createTree(node.getLeft());
            this.createTree(node.getRight());
        }
    }

    private void createNode(Node node){
        if(isInBrackets(node.getValue())){
            node.setValue(node.getValue().substring(1,node.getValue().length() - 1));
        }
        System.out.println(node.getValue());
        int numbOfBracket = 0;
        int i = 0;
        int findCharacter = 0;
        boolean findPrimary = false;
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
                }
                if((findCharacter == 0 || findPrimary) && secondaryCharacters.indexOf(character) != -1){
                    findCharacter = i;
                }
                if(findCharacter == 0 && primaryCharacters.indexOf(character) != -1){
                    findPrimary = true;
                    findCharacter = i;
                }
            }
        }
        if(findCharacter != 0){
            String firstPart = node.getValue().substring(0, findCharacter-1);
            String secondPart = node.getValue().substring(findCharacter);

            node.setLeft(new Node(firstPart));
            node.setValue(Character.toString(node.getValue().toCharArray()[findCharacter-1]));
            node.setRight(new Node(secondPart));
        }
    }

    private boolean isInBrackets(String str){
        int insideCounter = 0;
        for (char character: str.toCharArray()){
            if(character == '('){
                insideCounter++;
            }
            if(insideCounter == 0){
                return false;
            }
            if(character == ')'){
                insideCounter--;
            }
        }
        return true;
    }

    private boolean isSignInExpresion(String str){
        String signs = primaryCharacters + secondaryCharacters + thirdCharacters;
        for (char character: str.toCharArray()){
            if (signs.indexOf(character) != -1){
                return true;
            }
        }
        return false;
    }

    public double getResult(){
        return findSum(tree.getRoot());
    }

    public double findSum(Node node){
        double result = 0;
        double firstEl = 0;
        double secondEl = 0;
        if (node.getLeft() != null || node.getRight() != null){
            if(node.getLeft() != null){
                firstEl = findSum(node.getLeft());
            }
            if(node.getRight() != null ){
                secondEl = findSum(node.getRight());
            }
            result = action(firstEl, secondEl, node.getValue());
        }else{
            result = Double.parseDouble(node.getValue());
        }
        return result;
    }

    private double action(double firstEl, double secondEl, String sign){
        switch (sign){
            case "+":
                return firstEl + secondEl;
            case "-":
                return firstEl - secondEl;
            case "*":
                return firstEl * secondEl;
            case "/":
                return firstEl / secondEl;
            case "^":
                return Math.pow(firstEl,secondEl);
            case "√":
                return Math.sqrt(secondEl);
            case "%":
                return firstEl * 0.01;
        }
        return 0;
    }

    public Tree getTree() {
        return tree;
    }

    private int calculatePower(Node node, int power){
        int leftPower = 0, rightPower = 0;
        if (node.getLeft() != null){
            power++;
            leftPower = this.calculatePower(node.getLeft(), power);
        }
        if (node.getRight() != null){
            power++;
            rightPower = this.calculatePower(node.getRight(), power);
        }
        if(node.getRight() == null && node.getLeft() == null){
            return power;
        }
        return Math.max(leftPower, rightPower);
    }

    private void calculateNode(Node node, int power){
        if (node.getLeft() != null || node.getRight() != null) {
            power++;
            if (node.getLeft() != null){
                this.calculateNode(node.getLeft(), power);
            }
            if (node.getRight() != null){
                this.calculateNode(node.getRight(), power);
            }

        }
        if (power == this.power - 1 && node.getLeft() != null){
            node.setValue(Double.toString(this.findSum(node)));
            System.out.println("HERE");
            System.out.println(node.getValue());
            node.setLeft(null);
            node.setRight(null);
        }
    }

    public Tree coagulation(){
        power = calculatePower(currentTree.getRoot(), 0);
        calculateNode(currentTree.getRoot(), 1);
        return currentTree;
    }


    public Tree deployment(){
        currentTree = tree;
        return currentTree;
    }
}
