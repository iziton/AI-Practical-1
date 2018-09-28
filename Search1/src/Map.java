import java.util.ArrayList;
import java.util.List;

public class Map {
    private int[][] matrix;
    private List<Point> points;

    public List<Point> getPoints() {
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
               Point currentPoint =  points.get(i);
               switch (matrix[j][i]){
                   case 2:currentPoint.setInitial(true);
                       break;
                   case 5:currentPoint.getConnectedPoints().add(points.get(j));
                       break;
                   case 8:currentPoint.setGoal(true);
                       break;
               }
            }
        }
    }

    private void nameMatrixIndices(){
        char name = 'a';
        for (int i = 0; i < matrix.length ; i++) {
            Point point = new Point((char)(name+i));
            points.add(point);
        }
    }

    public static void main(String[] args) {
        int[][] map0 = new int[][]{
                {2, 5, 5, 10},
                {5, 0, 5, 10},
                {5, 5, 0, 5},
                {10, 10, 5, 8}
        };

        Map map = new Map(map0);
        map.getPoints();

        for (int i = 0; i <map.getPoints().size() ; i++) {
            Point current = map.getPoints().get(i);
            System.out.println("name "+current.getName());
            System.out.println("is goal "+ current.isGoal());
            System.out.println("is initial "+current.isInitial());
            System.out.println("Connected points "+current.getConnectedPoints().size());

        }
    }
}