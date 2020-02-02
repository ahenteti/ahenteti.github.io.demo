package io.github.ahenteti.java.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // no action to do here
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private int modulo = 1000000007;
    
    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (Color.RED.equals(node.getColor())) {
            result = (result * node.getValue()) % modulo;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (Color.RED.equals(leaf.getColor())) {
            result = (result * leaf.getValue()) % modulo;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeavesSum = 0;
    private int greenLeavesSum = 0;
    public int getResult() {
        return Math.abs(evenDepthNonLeavesSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        evenDepthNonLeavesSum += (node.getDepth() % 2 == 0) ? node.getValue() : 0;
    }

    public void visitLeaf(TreeLeaf leaf) {
        greenLeavesSum += Color.GREEN.equals(leaf.getColor()) ? leaf.getValue() : 0;
    }
}


class JavaVisitorPatternSolutionMain {

    public static Tree solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nodeValues = new int[n];
        Color[] nodeColors = new Color[n];
        Map<Integer, Set<Integer>> nodesEdgesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeValues[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nodeColors[i] = in.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            Set<Integer> uEdges = nodesEdgesMap.get(u);
            if (uEdges == null) uEdges = new HashSet<>();
            uEdges.add(v);
            nodesEdgesMap.put(u, uEdges);

            Set<Integer> vEdges = nodesEdgesMap.get(v);
            if (vEdges == null) vEdges = new HashSet<>();
            vEdges.add(u);
            nodesEdgesMap.put(v, vEdges);
        }
        Tree root;
        if (n == 1) {
            root = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
        } else {
            root = new TreeNode(nodeValues[0], nodeColors[0], 0);
            Set<Integer> rootEdges = nodesEdgesMap.get(1);
            Iterator<Integer> rootEdgesIterator = rootEdges.iterator();
            while (rootEdgesIterator.hasNext()) {
                Integer nodeIdentifier = rootEdgesIterator.next();
                nodesEdgesMap.get(nodeIdentifier).remove(1);
                createEdge((TreeNode) root, nodeIdentifier, nodeValues, nodeColors, nodesEdgesMap);
            }
        }
        return root;
    }

    private static void createEdge(TreeNode parentNode, Integer nodeIdentifier, int[] nodeValues, Color[] nodeColors, Map<Integer, Set<Integer>> nodesEdgesMap) {
        Set<Integer> nodeEdges = nodesEdgesMap.get(nodeIdentifier);
        boolean hasChildren = nodeEdges != null && !nodeEdges.isEmpty();
        int nodeValue = nodeValues[nodeIdentifier - 1];
        Color nodeColor = nodeColors[nodeIdentifier - 1];
        int nodeDepth = parentNode.getDepth() + 1;
        if (hasChildren) {
            TreeNode node = new TreeNode(nodeValue, nodeColor, nodeDepth);
            parentNode.addChild(node);
            Iterator<Integer> nodeEdgesIterator = nodeEdges.iterator();
            while(nodeEdgesIterator.hasNext()) {
                Integer nextNodeIdentifier = nodeEdgesIterator.next();
                nodesEdgesMap.get(nextNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, nextNodeIdentifier, nodeValues, nodeColors, nodesEdgesMap);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(nodeValue, nodeColor, nodeDepth);
            parentNode.addChild(leaf);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
