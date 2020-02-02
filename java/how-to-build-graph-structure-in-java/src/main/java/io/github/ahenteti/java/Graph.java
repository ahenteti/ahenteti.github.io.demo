package io.github.ahenteti.java;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
public class Graph {

    private Map<Vertex, Set<Vertex>> adjVertices = new HashMap<>();

    void addVertex(int id, int value, Color color) {
        adjVertices.putIfAbsent(new Vertex(id, value, color), new HashSet<>());
    }

    void addEdge(int vertexId1, int vertexId2) {
        Vertex v1 = adjVertices.keySet().stream().filter(v -> v.getId() == vertexId1).findFirst()
                .orElseThrow(getNotFoundVertexException(vertexId1));
        Vertex v2 = adjVertices.keySet().stream().filter(v -> v.getId() == vertexId2).findFirst()
                .orElseThrow(getNotFoundVertexException(vertexId2));
        adjVertices.computeIfAbsent(v1, x -> new HashSet<>()).add(v2);
        adjVertices.computeIfAbsent(v2, x -> new HashSet<>()).add(v1);
    }

    public void print() {
        boolean[] isVisited = new boolean[adjVertices.size()];
        System.out.println("graph vertexes: ");
        print(adjVertices.keySet().iterator().next(), 0, isVisited);
    }

    private void print(Vertex currentVertex, int depth, boolean[] isVisited) {
        isVisited[currentVertex.getId() - 1] = true;
        System.out.println(calcGraphPrintPrefix(depth) + currentVertex.getValue());
        for (Vertex vertex : adjVertices.get(currentVertex)) {
            if (!isVisited[vertex.getId() - 1]) {
                print(vertex, depth + 1, isVisited);
            }
        }
    }

    private String calcGraphPrintPrefix(int depth) {
        if (depth == 0) {
            return "";
        }
        String padding = new String(new char[depth * 4]).replace('\0', ' ');
        padding = padding.substring(0, padding.length() - 4) + "└── ";
        return padding;
    }

    private Supplier<RuntimeException> getNotFoundVertexException(int vertexId) {
        return () -> new RuntimeException(String.format("Vertex with id %s not found", vertexId));
    }
}
