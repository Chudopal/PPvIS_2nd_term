package tree;

public class Tree implements Cloneable {

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

    public Tree clone() throws CloneNotSupportedException{
        Tree newTree = (Tree) super.clone();
        newTree.root = (Node) root.clone();
        return newTree;
    }

    public void printTree(Node node){
        System.out.println(node.getValue());
        if(node.getLeft() != null || node.getRight() != null){
            if(node.getLeft() != null){
                printTree(node.getLeft());
            }
            if(node.getRight() != null){
                printTree(node.getRight());
            }
        }
    }
}
