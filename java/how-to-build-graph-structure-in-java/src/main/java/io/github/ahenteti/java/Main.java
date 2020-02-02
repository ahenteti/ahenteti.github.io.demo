package io.github.ahenteti.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] vertexValues = new int[n];
        Color[] vertexColors = new Color[n];
        for (int i = 0; i < n; i++) {
            vertexValues[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            vertexColors[i] = in.nextInt() == 0 ? Color.TRANSPARENT : Color.BLUE;
        }
        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            graph.addVertex(i + 1, vertexValues[i], vertexColors[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            graph.addEdge(u, v);
        }
        graph.print();
    }
}
