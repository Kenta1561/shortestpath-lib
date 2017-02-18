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

    //TODO add option to add reversed connection at the same time with boolean parameter "addReverseConnection"

    //TODO attention: connection works only in one direction

    /**
     * This HashSet stores all nodes in a network
     */
    public final HashSet<Node> nodes;

    /**
     * This HashSet stores all lines in a network
     */
    public final HashSet<Line> lines;

    /**
     * This HashSet stores all connections in a network
     */
    public final HashSet<Connection> connections;

    /**
     * Instance of {@link PathCreator} for background calculating
     */
    private final PathCreator pathCreator;

    /**
     * Basic constructor, initializes HashSets
     */
    public ShortestPath() {
        nodes = new HashSet<>();
        lines = new HashSet<>();
        connections = new HashSet<>();
        pathCreator = new PathCreator(this);
    }

    /**
     * Register a line in the network
     * @param line Requires a {@link Line} object
     */
    public void registerLine(Line line) {
        if(!lines.add(line)) {
            throw new ItemDuplicationException("You have already registered this instance of Line.");
        }
    }

    /**
     * Register lines in the network
     * @param lines Requires a HashSet with {@link Line} objects
     */
    public void registerLines(HashSet<Line> lines) {
        for(Line line : lines) {
            registerLine(line);
        }
    }

    /**
     * Register a node in the network
     * @param node Requires a {@link Node} object
     */
    public void registerNode(Node node) {
        if(!nodes.add(node)) {
            throw new ItemDuplicationException("You have already registered this instance of Node.");
        }
    }

    /**
     * Register nodes in the network
     * @param nodes Requires a HashSet with {@link Node} objects
     */
    public void registerNodes(HashSet<Node> nodes) {
        for(Node node : nodes) {
            registerNode(node);
        }
    }

    /**
     * Register a connection in the network
     * @param connection Requires a {@link Connection} object
     */
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

    /**
     * Register connections in the network
     * @param connections Requires a HashSet with {@link Connection} objects
     */
    public void registerConnections(HashSet<Connection> connections) {
        for(Connection connection : connections) {
            registerConnection(connection);
        }
    }

    /**
     * Method for retrieving path form A to B in the most efficient way (Least line changes)
     * @param from Requires the starting point
     * @param to Requires the ending point
     * @return Returns an ArrayList with {@link Path} objects representing the whole path
     */
    public ArrayList<Path> getPath(Node from, Node to) {
        return null;
    }

    /**
     * Method for retrieving raw path from A to B as an ArrayList with {@link Node} objects
     * @param from Requires the starting point
     * @param to Requires the ending point
     * @return Returns an ArrayList with {@link Node} objects representing the path as multiple {@link Node} objects
     */
    public ArrayList<Node> getRawPath(Node from, Node to) {
        //Passing request to PathCreator class as it is responsible for background calculation
        return pathCreator.getRawPath(from, to);
    }

    /**
     * Getter for HashSet of {@link Line} objects
     * @return Returns lines HashSet
     */
    HashSet<Line> getLines() {
        return lines;
    }

    /**
     * Getter for HashSet of {@link Node} objects
     * @return Returns nodes HashSet
     */
    HashSet<Node> getNodes() {
        return nodes;
    }

    HashSet<Connection> getConnections() {
        return connections;
    }

}