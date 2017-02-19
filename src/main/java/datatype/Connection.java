package main.java.datatype;

/**
 * @author Kenta1561
 * Objects of this class represent a connection from one node to another.
 */
public class Connection {

    /**
     * The origin node
     */
    private final Node from;

    /**
     * The destination node
     */
    private final Node to;

    /**
     * The raw travel time between the two nodes
     */
    private final double rawTime;

    /**
     * Basic constructor with all parameters given
     * @param from Requires the origin node
     * @param to Requires the destinatio node
     * @param rawTime Requires the raw travel time between the two nodes
     */
    public Connection(Node from, Node to, double rawTime) {
        this.from = from;
        this.to = to;
        this.rawTime = rawTime;
        setConnectivityValidation();
    }

    /**
     * Getter for origin node
     * @return Returns the origin node
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Getter for destination node
     * @return Returns the destination node
     */
    public Node getTo() {
        return to;
    }

    /**
     * Getter for raw travel time
     * @return Returns the raw travel time
     */
    public double getRawTime() {
        return rawTime;
    }

    /**
     * Private method for validate connectivity of both nodes
     */
    private void setConnectivityValidation() {
        from.validateConnectivity();
        to.validateConnectivity();
    }

}