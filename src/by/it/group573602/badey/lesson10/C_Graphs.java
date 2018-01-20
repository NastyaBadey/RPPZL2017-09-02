package by.it.group573602.badey.lesson10;

import java.util.*;

/**
 * Created by User on 09.01.2018.
 */
public class C_Graphs {

    static class Mark {
        public int pre;
        public int post;

        public Mark(int pre, int post) {
            this.pre = pre;
            this.post = post;
        }
    }

    static DirectedGraph graph;
    static Map<String, C_Graphs.Mark> visitedVertices = new LinkedHashMap<>();
    static int count = 1;

    public static void main(String[] args) {
        graph = new DirectedGraph();
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "G");
        graph.addEdge("F", "H");

        Map<String, List<String>> vm = graph.getVertexMap();

        List<String> vertexList = new ArrayList<String>(vm.size());
        vertexList.addAll(vm.keySet());
        Collections.sort(vertexList);

        for (String v : vertexList) {
            dfs(v);
        }

        for (Map.Entry<String, C_Graphs.Mark> entry : visitedVertices.entrySet()) {
            C_Graphs.Mark m = entry.getValue();
            System.out.format("%1$s : (%2$d, %3$d)\n", entry.getKey(), m.pre, m.post);
        }

        for (int i = 0; i < graph.letters.size(); i++) {
            if (graph.istoks_stok.get(graph.letters.get(i))[0] == 0)
                System.out.println(graph.letters.get(i) + " - Исток");
            if (graph.istoks_stok.get(graph.letters.get(i))[1] == 0) {
                System.out.println(graph.letters.get(i) + " - Сток");
            }

        }


    }

    static void dfs(String vertexName) {
        if (visitedVertices.containsKey(vertexName)) return;

        visitedVertices.put(vertexName, new C_Graphs.Mark(count, -1));
        count++;

        Map<String, List<String>> vm = graph.getVertexMap();
        List<String> adjacentVertices = vm.get(vertexName);

        for (String v : adjacentVertices) {
            if (visitedVertices.containsKey(v)) continue;
            dfs(v);
        }

        C_Graphs.Mark m = visitedVertices.get(vertexName);
        m.post = count++;
    }
}
