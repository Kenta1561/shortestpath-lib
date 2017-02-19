package main.java;

import main.java.datatype.Connection;
import main.java.datatype.Node;
import main.java.datatype.Path;
import main.java.exception.InvalidNetworkException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Kenta1561
 * This class calculates the path from point A to B.
 */
class PathCreator {

    /**
     * Requires an instance of the main class
     */
    private final ShortestPath shortestPath;

    /**
     * Requires an instance of queue class
     */
    private final Queue queue;

    /**
     * This HashSet stores all registered nodes
     */
    private HashSet<Node> nodes;

    /**
     * This HashSet stores all registered connections
     */
    private HashSet<Connection> connections;

    /**
     * Basic constructor with a parameter
     * @param shortestPath Requires the instance of the main class
     */
    PathCreator(ShortestPath shortestPath) {
        this.shortestPath = shortestPath;
        queue = new Queue();
    }

    /**
     * Initializes private HashSets of this class by using getter methods in main class
     */
    private void setData() {
        nodes = shortestPath.getNodes();
        connections = shortestPath.getConnections();
    }

    /**
     * Initializes all nodes by setting the travel time from the origin node and by adding them
     * to the queue
     * @param from Requires the starting point
     */
    private void initializeNodes(Node from) {
        for(Node node : nodes) {
            if(node.equals(from)) {
                node.setTime(Double.MAX_VALUE);
            } else {
                node.setTime(0.0);
            }
            queue.addNode(node);
        }
    }

    /**
     * Checks if the connectivity of every single node is validated
     * @return
     */
    private boolean connectivityValidationCheck() {
        for(Node node : nodes) {
            if(!node.isConnectivityValidated()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the raw path from point A to B
     * @param from Requires the origin node
     * @param to Requires the destination node
     * @return Returns the raw path in an ArrayList of nodes
     */
    ArrayList<Node> getRawPath(Node from, Node to) {
        ArrayList<Node> rawPath = new ArrayList<>();    //ArrayList for returning
        if(!connectivityValidationCheck()) {
            throw new InvalidNetworkException("The provided network is invalid. One or multiple nodes are not connected " +
                    "to the rest of the network. Please make sure that all nodes have at least one connection.");
        } else {
            //Set data
            setData();
            //Initialize all nodes
            initializeNodes(from);
            //Inifinite loop but definitely breakable as network is already validated (safe infinite loop ;D)
            parentLoop: {
                while(true) {
                    //Get the instance of the first node in queue
                    Node currentNode = queue.getFirstNode();
                    //Get all connections of the first node
                    ArrayList<Connection> currentConnections = getConnections(currentNode);
                    for(Connection currentConnection : currentConnections) {
                        Node currentDestination = currentConnection.getTo();
                        if(currentDestination.equals(to)) {
                            //Add final destination to ArrayList
                            rawPath.add(to);
                            //Backtrack path
                            while(currentNode.getPrevious() != null) {
                                rawPath.add(currentNode.getPrevious());
                                currentNode = currentNode.getPrevious();
                            }
                            //TODO Check: is it required to add start node as well? (to rawPath)
                            break parentLoop;
                        } else {
                            //Check if it is necessary to update the distance
                            if (currentDestination.getTime() > (currentNode.getTime() + currentConnection.getRawTime())) {
                                //Distance update
                                currentDestination.setTime(currentNode.getTime() + currentConnection.getRawTime());
                                //Sort queue by distance (influenced by distance update)
                                queue.sortQueue();
                                //Set its previous node to current node
                                currentDestination.setPrevious(currentNode);
                            }
                        }
                    }
                    //Remove first node from queue
                    queue.removeFirstNode();
                }
            }
        }
        return rawPath;
    }

    /**
     * Searches for connections from the given node
     * @param node Requires a node
     * @return Returns an ArrayList with connections
     */
    private ArrayList<Connection> getConnections(Node node) {
        ArrayList<Connection> nodeConnections = new ArrayList<>();  //ArrayList for returning
        for(Connection connection : connections) {  //Loop through all provided connections
            if(connection.getFrom().equals(node)) { //If the origin is the parameter node, add it to ArrayList
                nodeConnections.add(connection);
            }
        }
        return nodeConnections; //Return ArrayList
    }

    /**
     * Calculates a path with the least line changes
     * @param from Requires the origin node
     * @param to Requires the destination node
     * @return Returns the path as an ArrayList with {@link Path} objects
     */
    ArrayList<Path> getPath(Node from, Node to) {
        ArrayList<Path> path = new ArrayList<>();
        ArrayList<Node> rawPath = getRawPath(from, to);
        //Reverse rawPath as it is reversed
        Collections.reverse(rawPath);
        while(true) {
            //Get first node from raw path
            Node currentNode = rawPath.get(0);
            //Stores the length of the longest trail
            int maxTrailSize = 0;
            //Stores the line name of the longest trail
            String maxTrailLine = null;
            //Loop through all lines of the node that are being served by
            for(String line : currentNode.getLines()) {
                //Temporal trail size counter
                int trailSizeCounter = 0;
                for(Node node : rawPath) {
                    if(node.getLines().contains(line)) {
                        trailSizeCounter++;
                    } else {
                        break;
                    }
                }
                //Update max trail size counter and max trail line if necessary
                if(trailSizeCounter > maxTrailSize) {
                    maxTrailSize = trailSizeCounter;
                    maxTrailLine = line;
                }
            }
            //Add path
            path.add(new Path(maxTrailLine, rawPath.get(0), rawPath.get(maxTrailSize - 1)));
            //Removal of unnecessary nodes in raw path as they are already checked
            for(int x = 0; x < maxTrailSize - 1; x++) {
                //Remove first node
                rawPath.remove(0);
            }
            //Break check
            if(rawPath.size() == 1) {
                //Break infinite loop
                break;
            }
        }
        //Return path
        return path;
    }

}