package main.java;

import main.java.datatype.Connection;
import main.java.datatype.Line;
import main.java.datatype.Node;
import main.java.datatype.Path;
import main.java.exception.ItemDuplicationException;
import main.java.exception.ItemNotExistingException;

import java.util.ArrayList;
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

    public final HashSet<Connection> connections;

    private final NetworkManager networkManager;

    /**
     * Basic constructor, initializes both ArrayLists
     */
    public ShortestPath() {
        nodes = new HashSet<>();
        lines = new HashSet<>();
        connections = new HashSet<>();
        networkManager = new NetworkManager(this);
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
            registerLine(line);
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
            registerNode(node);
        }
    }

    public void registerConnection(Connection connection) {
        if(!nodes.contains(connection.getFrom()) && !nodes.contains(connection.getTo())) {
            throw new ItemNotExistingException("One or both nodes included in this connection was/were not registered " +
                    "before. Please register all nodes before you register connections.");
        } else {
            if(!connections.add(connection)) {
                throw new ItemDuplicationException("You have already registered this instance of Connection.");
            }
        }
    }

    public void registerConnections(HashSet<Connection> connections) {
        for(Connection connection : connections) {
            registerConnection(connection);
        }
    }

    public ArrayList<Path> getPath(Node from, Node to) {
        return null;
    }

    public ArrayList<Node> getRawPath(Node from, Node to) {
        //Initialize nodes
        networkManager.initializeNodes(from);
        return null;
    }

    HashSet<Line> getLines() {
        return lines;
    }

    HashSet<Node> getNodes() {
        return nodes;
    }

}