package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    private Node startNode;
    private Node goalNode;
    private Queue<Node> queue;
    private LinkedList<Node> visitedNodes;


    public BFS(Map map) {
        this.startNode = map.getStartPoint();
        this.goalNode = map.getGoalPoint();
        this.queue = new LinkedList<>();
        this.visitedNodes = new LinkedList<>();

        if (execute()) {
            System.out.println("Path found!");
            printPath();
        } else {
            System.out.println("Couldn't find a path!");
        }
    }

    public boolean execute() {
        queue.add(startNode);
        visitedNodes.add(startNode);
        if (startNode == goalNode) {
            return true;
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            ArrayList<Node> unvisitedChildren = getUnvisitedChildren(currentNode);

            for (Node currentChild : unvisitedChildren) {
                queue.add(currentChild);
                visitedNodes.add(currentChild);

                if (currentChild == goalNode) {
                    return true;
                }
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
        for (Node node : queue) {
            System.out.println(node.getName() + " ");
        }
    }
}


