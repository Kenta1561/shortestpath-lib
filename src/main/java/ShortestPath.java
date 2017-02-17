package main.java;

import main.java.datatype.Line;
import main.java.datatype.Node;

import java.util.ArrayList;

/**
 * This is the main class of this library. An instance of this class is
 * required for registering all the required components to calculate a path.
 */
public class ShortestPath {

    /**
     * This ArrayList stores all nodes in a network
     */
    public final ArrayList<Node> nodes;

    /**
     * This ArrayList stores all lines in a network
     */
    public final ArrayList<Line> lines;

    /**
     * Basic constructor, initializes both ArrayLists
     */
    public ShortestPath() {
        nodes = new ArrayList<>();
        lines = new ArrayList<>();
    }

    /**
     * Add a line in the network
     * @param line Requires a {@link Line} object
     */
    public void addLine(Line line) {}

    /**
     * Add lines in the network
     * @param lines Requires an ArrayList with {@link Line} objects
     */
    public void addLines(ArrayList<Line> lines) {}

    /**
     * Add a node in the network
     * @param node Requires a {@link Node} object
     */
    public void addNode(Node node) {}

    /**
     * Add nodes in the network
     * @param nodes Requires an ArrayList with {@link Node} objects
     */
    public void addNodes(ArrayList<Node> nodes) {}

}