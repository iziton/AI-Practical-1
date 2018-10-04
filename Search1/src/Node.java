import java.util.ArrayList;
import java.util.List;

public class Node {
    Node parent;
    List<Node> children;
    Point location;
    int pathCost;
    int depth;
    List<Point> moves;

    public Node(Point location, Node parent) {
        this.parent = parent;
        this.location = location;
        children = new ArrayList<>();
        pathCost= parent.getPathCost()+1;
        depth = parent.getDepth()+1;
        moves = location.getConnectedPoints();
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
