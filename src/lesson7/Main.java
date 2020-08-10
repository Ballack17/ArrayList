package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,4);
        graph.addEdge(1,5);
        graph.addEdge(5,7);
        graph.addEdge(5,8);
        graph.addEdge(7,9);
        graph.addEdge(8,9);
        graph.addEdge(1,6);
        graph.addEdge(0,8);
        graph.addEdge(2,7);
        graph.addEdge(5,6);

//        System.out.println(graph.getAdjList(1));
//
//        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2 );
//        System.out.println(dfp.hasPathTo(0));
//        System.out.println(dfp.pathTo(0));
//        System.out.println(dfp.hasPathTo(3));


        BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(9));
        System.out.println(bfp.pathTo(9));
        System.out.println(bfp.hasPathTo(3));

    }
}
