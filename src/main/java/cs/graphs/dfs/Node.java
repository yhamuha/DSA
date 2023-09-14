package cs.graphs.dfs;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

class Node {
    public int value;
    public LinkedHashSet<Edge> edges = new LinkedHashSet<>();
    public LinkedHashMap<Node, Edge> parents = new LinkedHashMap<>();
    public Node(int value) { this.value = value; }
}
