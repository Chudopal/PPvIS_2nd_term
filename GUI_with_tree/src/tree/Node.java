package tree;

public class Node implements Cloneable {
    private String value;
    private Node left;
    private Node right;

    public Node(String value){
        this.value = value;
        right = null;
        left = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    public Node clone() throws CloneNotSupportedException{
        Node newNode = (Node) super.clone();
        if(left != null || right != null){
            newNode.setLeft(left.clone());
            newNode.setRight(right.clone());
        }
        return newNode;
    }
}
