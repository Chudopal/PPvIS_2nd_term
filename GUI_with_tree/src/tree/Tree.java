package tree;

public class Tree {

    private Node root;
    private int power;

    public Tree(String root){
        this.root = new Node(root);
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
