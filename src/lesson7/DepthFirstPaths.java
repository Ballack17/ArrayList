package lesson7;

import java.util.LinkedList;

public class DepthFirstPaths extends Path{

    public DepthFirstPaths(Graph g, int source) {
        super(g, source);
    }

    @Override
    public void fs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                fs(g, w);
            }
        }
    }
}
