package main.java;

import main.java.datatype.Line;
import main.java.datatype.Node;
import main.java.exception.UnregisteredItemException;

import java.util.ArrayList;

/**
 * This is the main class of this library. An instance of this class is
 * required for registering all the required components to calculate a path.
 */
public class ShortestPath {

    public final ArrayList<Node> nodes;
    public final ArrayList<Line> lines;

    public ShortestPath() {
        nodes = new ArrayList<>();
        lines = new ArrayList<>();
    }

    public void registerLine(Line line) {
        lines.add(line);
    }

    public void registerLines(ArrayList<Line> lines) {
        this.lines.addAll(lines);
    }

    public void registerNode(double code, String name, ArrayList<Line> nodeLines) {
        if(lineInstanceNotExisting(nodeLines)) {
            throw new UnregisteredItemException("A line/multiple lines that were not registered before " +
                    "was/were registered. Please register all lines before you register nodes.");
        } else {
            nodes.add(new Node(code, name, nodeLines));
        }
    }

    public void registerConnection(Node from, Node to, double rawTime) {
        if(nodeInstanceNotExisting(from) || nodeInstanceNotExisting(to)) {
            throw new UnregisteredItemException("A node/multiple nodes that were not registered before " +
                    "was/were registered. Please register all nodes before you register connections.");
        }
    }

    private boolean lineInstanceNotExisting(ArrayList<Line> nodeLines) {
        for(Line nodeLine : nodeLines) {
            if(!lines.contains(nodeLine)) {
                return true;
            }
        }
        return false;
    }

    private boolean nodeInstanceNotExisting(Node connectionNode) {
        return !nodes.contains(connectionNode);
    }

}