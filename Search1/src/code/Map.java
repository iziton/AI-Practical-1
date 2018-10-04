package code;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int[][] matrix;
    private List<Node> points;
    private Node startPoint;
    private Node goalPoint;

    public List<Node> getPoints() {
        return points;
    }

    public Map(int[][] matrix) {
        this.matrix = matrix;
        points=new ArrayList<>();
        translateMatrix();
    }

    private void translateMatrix() {
        nameMatrixIndices();

        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
               Node currentPoint =  points.get(i);
               switch (matrix[j][i]){
                   case 2:startPoint = currentPoint;
                       break;
                   case 5:
                       currentPoint.getConnectedNodes().add(points.get(j));
                       break;
                   case 8:goalPoint = currentPoint;
                       break;
               }
            }
        }
    }

    private void nameMatrixIndices(){
        char name = 'a';
        for (int i = 0; i < matrix.length ; i++) {
            Node point = new Node((char)(name+i));
            points.add(point);
        }
    }

    public Node getStartPoint() {
        return startPoint;
    }

    public Node getGoalPoint() {
        return goalPoint;
    }
}