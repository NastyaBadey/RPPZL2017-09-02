package by.it.group573602.badey.lesson10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by User on 09.01.2018.
 */
public class B_Graphs {
    private int vertexAmount;
    private LinkedList<Integer> adjacencyList[];

    B_Graphs(int vertex) {
        this.vertexAmount = vertex;
        adjacencyList = new LinkedList[vertex];
        for (int i = 0; i < vertex; ++i)
            adjacencyList[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    void topologicalSort(int v, boolean visited[],
                         Stack stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adjacencyList[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSort(i, visited, stack);
        }

        stack.push(new Integer(v));
    }

    void topologicalSort() {
        Stack stack = new Stack();

        boolean visited[] = new boolean[vertexAmount];
        for (int i = 0; i < vertexAmount; i++)
            visited[i] = false;

        for (int i = 0; i < vertexAmount; i++)
            if (visited[i] == false)
                topologicalSort(i, visited, stack);

        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        B_Graphs graph = new B_Graphs(8);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.topologicalSort();
    }
}
