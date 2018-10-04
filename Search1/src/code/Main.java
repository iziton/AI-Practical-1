package code;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MapsGenerator mapsGenerator = new MapsGenerator();
        List<Map> maps = mapsGenerator.getMaps();

        Map testMap = maps.get(6);

//        System.out.println("Map: ");
//        System.out.println("Strarting: " + testMap.getStartPoint().getName());
//        System.out.println("Goal: " + testMap.getGoalPoint().getName());
//
//        for (Node node : testMap.getPoints()
//             ) {
//            System.out.println("Node "+node.getName() );
//            System.out.println("connected to: ");
//
//            for (Node child:node.getConnectedNodes()
//                 ) {
//                System.out.print(child.getName()+ " " );
//            }
//            System.out.println();
//        }

        System.out.println();

        System.out.println("BFS: ");

        BFS bfs = new BFS(testMap);
        System.out.println();

        System.out.println("DFS: ");
        DFS dfs = new DFS(testMap);





    }
}
