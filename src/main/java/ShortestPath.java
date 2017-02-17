package main.java;

import main.java.datatype.Line;
import main.java.datatype.Node;
import main.java.exception.ItemDuplicationException;

import java.util.HashSet;

/**
 * This is the main class of this library. An instance of this class is
 * required for registering all the required components to calculate a path.
 */
public class ShortestPath {

    /**
     * This ArrayList stores all nodes in a network
     */
    public final HashSet<Node> nodes;

    /**
     * This ArrayList stores all lines in a network
     */
    public final HashSet<Line> lines;

    /**
     * Basic constructor, initializes both ArrayLists
     */
    public ShortestPath() {
        nodes = new HashSet<>();
        lines = new HashSet<>();
    }

    /**
     * Add a line in the network
     * @param line Requires a {@link Line} object
     */
    public void registerLine(Line line) {
        if(!lines.add(line)) {
            throw new ItemDuplicationException("You have already registered this instance of Line.");
        }
    }

    /**
     * Add lines in the network
     * @param lines Requires a HashSet with {@link Line} objects
     */
    public void registerLines(HashSet<Line> lines) {
        for(Line line : lines) {
            if(!this.lines.add(line)) {
                throw new ItemDuplicationException("You have already registered one or more instances of Line in the " +
                        "given HashSet.");
            }
        }
    }

    /**
     * Add a node in the network
     * @param node Requires a {@link Node} object
     */
    public void registerNode(Node node) {
        if(!nodes.add(node)) {
            throw new ItemDuplicationException("You have already registered this instance of Node.");
        }
    }

    /**
     * Add nodes in the network
     * @param nodes Requires a HashSet with {@link Node} objects
     */
    public void registerNodes(HashSet<Node> nodes) {
        for(Node node : nodes) {
            if(!this.nodes.add(node)) {
                throw new ItemDuplicationException("You have already registered one or more instances of Node in the " +
                        "given HashSet.");
            }
        }
    }

}