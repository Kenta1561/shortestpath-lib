package main.java;

import main.java.datatype.Connection;
import main.java.datatype.Node;
import main.java.datatype.Path;
import main.java.exception.ItemDuplicationException;
import main.java.exception.ItemNotExistingException;
import main.java.exception.MultipleRegistrationException;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This is the main class of this library. An instance of this class is
 * required for registering all the required components to calculate a path.
 */
public class ShortestPath {

    /**
     * This HashSet stores all nodes in a network
     */
    public final HashSet<Node> nodes;

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
        connections = new HashSet<>();
        pathCreator = new PathCreator(this);
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
    @SuppressWarnings("unused")
    public void registerNodes(HashSet<Node> nodes) {
        for(Node node : nodes) {
            registerNode(node);
        }
    }

    /**
     * Register a connection in the network
     * @param connection Requires a {@link Connection} object
     * @param addReverseConnection Set true if the reversed connection should be added as well
     */
    public void registerConnection(Connection connection, boolean addReverseConnection) {
        if(!nodes.contains(connection.getFrom()) && !nodes.contains(connection.getTo())) {
            throw new ItemNotExistingException("One or both nodes included in this connection was/were not registered " +
                    "before. Please register all nodes before you register connections.");
        } else {
            if(!isDuplicateConnection(connection)) {
                if(!connections.add(connection)) {
                    throw new ItemDuplicationException("You have already registered this instance of Connection.");
                } else {
                    addReverseConnection(connection);
                }
            } else {
                throw new MultipleRegistrationException("You have already registered a connection with the same origin " +
                        "and destination.");
            }
        }
    }

    /**
     * Adds a connection with the origin and destination being reversed.
     * Note: No ItemDuplicationException will be thrown because a new instance is created here
     * @param originalConnection Requires the original connection to be reversed
     */
    private void addReverseConnection(Connection originalConnection) {
        Connection reverseConnection = new Connection(originalConnection.getTo(), originalConnection.getFrom(),
                originalConnection.getRawTime());
        connections.add(reverseConnection);
    }

    /**
     * This method checks whether a connection with the same from and to node already exists.
     * It does NOT check if the same instance of Connection exists.
     */
    private boolean isDuplicateConnection(Connection checkingConnection) {
        for(Connection connection : connections) {
            if((connection.getFrom() == checkingConnection.getFrom()) && (connection.getTo() == checkingConnection.getTo())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Register connections in the network
     * @param connections Requires a HashSet with {@link Connection} objects
     * @param addReverseConnections Set true if for all connection a reversed connection should be added as well
     */
    @SuppressWarnings("unused")
    public void registerConnections(HashSet<Connection> connections, boolean addReverseConnections) {
        for(Connection connection : connections) {
            registerConnection(connection, addReverseConnections);
        }
    }

    /**
     * Method for retrieving path form A to B in the most efficient way (Least line changes)
     * @param from Requires the starting point
     * @param to Requires the ending point
     * @return Returns an ArrayList with {@link Path} objects representing the whole path
     */
    @SuppressWarnings("unused")
    public ArrayList<Path> getPath(Node from, Node to) {
        return null;
    }

    /**
     * Method for retrieving raw path from A to B as an ArrayList with {@link Node} objects
     * @param from Requires the starting point
     * @param to Requires the ending point
     * @return Returns an ArrayList with {@link Node} objects representing the path as multiple {@link Node} objects
     */
    @SuppressWarnings("unused")
    public ArrayList<Node> getRawPath(Node from, Node to) {
        //Passing request to PathCreator class as it is responsible for background calculation
        return pathCreator.getRawPath(from, to);
    }

    /**
     * Getter for HashSet of {@link Node} objects
     * @return Returns nodes HashSet
     */
    HashSet<Node> getNodes() {
        return nodes;
    }

    /**
     * Getter for HashSet of {@link Connection} objects
     * @return Returns connections HashSet
     */
    HashSet<Connection> getConnections() {
        return connections;
    }

}