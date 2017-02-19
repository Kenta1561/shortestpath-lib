package main.java.datatype;

import main.java.exception.InvalidNetworkException;

import java.util.HashSet;

/**
 * @author Kenta1561
 * Objects of this class represent a node/station in a network.
 */
public class Node implements Comparable<Node> {

    /**
     * The name of the node
     */
    private final String name;

    /**
     * The time from the starting node, will change during various calculations
     */
    private double time;

    /**
     * HashSet with lines that stops at this node
     */
    private final HashSet<String> lines;

    /**
     * The previous node in a path, made for calculation purposes
     */
    private Node previous;

    /**
     * Shows whether the connectivity of this node is granted in the provided network
     */
    private boolean validatedConnectivity = false;

    /**
     * Basic constructor with all required parameters
     * @param name Requires the name of the node
     * @param lines Requires all lines that stops at this node
     */
    public Node(String name, HashSet<String> lines) {
        this.name = name;
        if((lines != null) && (!lines.isEmpty())) {
            this.lines = lines;
        } else {
            throw new InvalidNetworkException("This network is invalid. No lines existing for this node.");
        }
    }

    /**
     * Setter for the travel time from the starting node
     * @param time Requires the time as a double
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Sets the connectivity validation boolean to true
     */
    void validateConnectivity() {
        validatedConnectivity = true;
    }

    /**
     * Setter for the previous node
     * @param previous
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * Getter for the name of the node
     * @return
     */
    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    /**
     * Getter for the travel time from the starting node
     * @return Returns the travel time
     */
    public double getTime() {
        return time;
    }

    /**
     * Getter for the connecting lines
     * @return Returns a HashSet with lines stopping at this node
     */
    public HashSet<String> getLines() {
        return lines;
    }

    /**
     * Getter for the previous node
     * @return Returns the previous node in the current path
     */
    public Node getPrevious() {
        return previous;
    }

    /**
     * Returns whether the connectivity is validated
     * @return Returns true when the connectivity is validated
     */
    public boolean isConnectivityValidated() {
        return validatedConnectivity;
    }

    /**
     * Implements {@link Comparable#compareTo(Object)}, checks which node has the shorter travel time
     * @param node Requires the node to be compared to
     * @return Returns comparing result
     */
    @Override
    public int compareTo(Node node) {
        if(time < node.getTime()) {
            return -1;
        } else if(time > node.getTime()) {
            return 1;
        } else {
            return 0;
        }
    }

}
