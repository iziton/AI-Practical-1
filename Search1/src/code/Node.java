package code;

import java.util.ArrayList;

public class Node {
    private char name;
    private ArrayList<Node> connectedNodes;


    public Node(char name) {
        this.name = name;
        this.connectedNodes = new ArrayList<>();
    }


    public char getName() {
        return name;
    }

    public ArrayList<Node> getConnectedNodes() {
        return connectedNodes;
    }


}
