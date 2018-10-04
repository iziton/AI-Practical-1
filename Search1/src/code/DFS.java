package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    private Node startNode;
    private Node goalNode;
    private Stack<Node> stack;
    private LinkedList<Node> visitedNodes;



    public DFS(Map map) {
        this.startNode = map.getStartPoint();
        this.goalNode = map.getGoalPoint();
        this.stack = new Stack<>();
        this.visitedNodes = new LinkedList<>();


        if (execute()) {
            System.out.println("Path found!");
            printPath();
        } else {
            System.out.println("Couldn't find a frontier!");
        }
    }

    public boolean execute() {
        stack.push(startNode);
        visitedNodes.add(startNode);
        if (startNode == goalNode) {
            return true;
        }

        while (!stack.isEmpty()) {
            Node currentNode = stack.peek();
            ArrayList<Node> unvisitedChildren = getUnvisitedChildren(currentNode);

            if (unvisitedChildren.size() != 0) {
                Node currentChild = unvisitedChildren.get(0);
                stack.push(currentChild);
                visitedNodes.add(currentChild);

                if (currentChild == goalNode) {
                    return true;
                }
            } else {
                stack.pop();
            }
        }
        return false;
    }

    private ArrayList<Node> getUnvisitedChildren(Node node) {
        ArrayList<Node> unvisitedChildren = new ArrayList<>();
        for (Node child : node.getConnectedNodes()) {

            if (!visitedNodes.contains(child)) {
                unvisitedChildren.add(child);
            }
        }

        return unvisitedChildren;
    }

    private void printPath() {
        System.out.println("Path: ");
        for (Node node : stack) {
            System.out.println(node.getName() + " ");
        }
    }
}
