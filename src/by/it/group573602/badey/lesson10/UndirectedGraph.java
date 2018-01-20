package by.it.group573602.badey.lesson10;

import java.util.*;

/**
 * Created by User on 08.01.2018.
 */
public class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;
    public HashMap<String, Integer[]> effluents = new HashMap<String, Integer[]>();
    public ArrayList<String> letters = new ArrayList<>();

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public boolean hasVertex(String vertexName){
        return adjacencyList.containsKey(vertexName);
    }

    public boolean hasEdge(String parentVertex, String childVertex){
        if (!hasVertex(parentVertex))
            return false;
        List<String> edges = adjacencyList.get(parentVertex);
        return Collections.binarySearch(edges, childVertex) != -1;
    }

    public void addVertex(String vertexName){
        if (!hasVertex(vertexName))
            adjacencyList.put(vertexName, new ArrayList<>());
    }

    public void addEdge(String parentVertex, String childVertex){
        int istoks = 0;
        int stoks = 0;
        if (!hasVertex(parentVertex)) {
            addVertex(parentVertex);
            stoks = 1;
            effluents.put(parentVertex, new Integer[]{istoks, stoks});
            letters.add(parentVertex);
        } else if (hasVertex(parentVertex)) {
            effluents.replace(parentVertex, effluents.get(parentVertex),
                    new Integer[]{effluents.get(parentVertex)[0],
                            effluents.get(parentVertex)[1] + 1});
        }
        if (!hasVertex(childVertex)) {
            istoks = 1;
            addVertex(childVertex);

            effluents.put(childVertex, new Integer[]{istoks, stoks});
            letters.add(childVertex);
        } else if (hasVertex(childVertex)) {
            effluents.replace(childVertex, effluents.get(childVertex),
                    new Integer[]{effluents.get(childVertex)[0] + 1,
                            effluents.get(childVertex)[1]});
        }
        List<String> firstEdge = adjacencyList.get(parentVertex);
        List<String> secondEdge = adjacencyList.get(childVertex);
        firstEdge.add(childVertex);
        secondEdge.add(parentVertex);
        Collections.sort(firstEdge);
        Collections.sort(secondEdge);
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }
}
