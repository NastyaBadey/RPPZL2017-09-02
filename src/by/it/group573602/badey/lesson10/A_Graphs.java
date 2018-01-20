package by.it.group573602.badey.lesson10;

import java.util.*;

/**
 * Created by User on 08.01.2018.
 */
public class A_Graphs {
    static class Mark{
        public int pre;
        public int post;

        public Mark(int pre, int post) {
            this.pre = pre;
            this.post = post;
        }
    }

    static private UndirectedGraph graph;
    static private Map<String, Mark> visitedVertices = new LinkedHashMap<>();
    static int count = 1;

    public static void main(String[] args) {
        graph = new UndirectedGraph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "I");

        graph.addEdge("D", "G");
        graph.addEdge("D", "H");
        graph.addEdge("G", "H");

        Map<String, List<String>> adjacencyList = graph.getAdjacencyList();
        List<String> vertexes = new ArrayList<>(adjacencyList.size());
        vertexes.addAll(adjacencyList.keySet());
        Collections.sort(vertexes);

        for (String v : vertexes) {
            dfs(v);
        }

        for (Map.Entry<String, Mark> entry : visitedVertices.entrySet()) {
            Mark m = entry.getValue();
            System.out.format("%1$s : (%2$d, %3$d)\n", entry.getKey(), m.pre, m.post);
        }

        System.out.println();
        for (int i = 0; i < graph.letters.size(); i++) {
            if ((visitedVertices.get(graph.letters.get(i)).post -
                    visitedVertices.get(graph.letters.get(i)).pre == 1
                    && graph.effluents.get(graph.letters.get(i))[0] > 1)) {
                for (int j = 0; j < adjacencyList.get(graph.letters.get(i)).size(); j++) {
                    if (visitedVertices.get(adjacencyList.get(graph.letters.get(i)).get(j)).pre
                            - visitedVertices.get(graph.letters.get(i)).pre != -1) {
                        System.out.println(adjacencyList.get(graph.letters.get(i)).get(j) +
                                " " + graph.letters.get(i) + " обратная");
                    }
                }
            }
        }
    }

    static void dfs(String vertexName) {
        if (visitedVertices.containsKey(vertexName)) return;

        visitedVertices.put(vertexName, new Mark(count,-1));
        count++;

        Map<String, List<String>> vertexes = graph.getAdjacencyList();
        List<String> adjacentVertices = vertexes.get(vertexName);

        for (String v : adjacentVertices) {
            if (visitedVertices.containsKey(v)) continue;
            dfs(v);
        }

        Mark m = visitedVertices.get(vertexName);
        m.post = count++;
    }
}
