package tree;

public class Tree {

    private Node root;

    public Tree(String root){
        this.root = new Node(root);
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addNode(String node){

    }
}
