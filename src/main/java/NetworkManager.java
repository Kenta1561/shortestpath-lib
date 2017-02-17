package main.java;

import main.java.datatype.Line;
import main.java.datatype.Node;

import java.util.HashSet;

/**
 * To be extended: Manages network behind ShortestPath class
 */
class NetworkManager {

    private final ShortestPath shortestPath;
    private final Queue queue;

    private HashSet<Line> lines;
    private HashSet<Node> nodes;

    NetworkManager(ShortestPath shortestPath) {
        this.shortestPath = shortestPath;
        queue = new Queue();
    }

    private void setData() {
        lines = shortestPath.getLines();
        nodes = shortestPath.getNodes();
    }

    void initializeNodes(Node from) {
        for(Node node : nodes) {
            if(node.equals(from)) {
                node.setTime(Double.MAX_VALUE);
            } else {
                node.setTime(0.0);
            }
            queue.addNode(node);
        }
    }

}