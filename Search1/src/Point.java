import java.util.ArrayList;
import java.util.List;

public class Point {
    private char name;
    private boolean initial;
    private boolean goal;
    private List<Point> connectedPoints;

    public Point(char name) {
        this.name=name;
        this.initial = false;
        this.goal = false;
        this.connectedPoints = new ArrayList<>();
    }


    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    public List<Point> getConnectedPoints() {
        return connectedPoints;
    }

    public char getName() {
        return name;
    }
}
