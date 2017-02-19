package main.java.datatype;

/**
 * @author Kenta1561
 * Objects of this class represent a section of a path from point A to B.
 */
public class Path {

    /**
     * The line that must be taken
     */
    private final String line;

    /**
     * The origin node
     */
    private final Node from;

    /**
     * The destination node
     */
    private final Node to;

    /**
     * Basic constructor with all parameters
     * @param line Requires the line that must be taken
     * @param from Requires the origin node
     * @param to Requires the destination node
     */
    public Path(String line, Node from, Node to) {
        this.line = line;
        this.from = from;
        this.to = to;
    }

    /**
     * Getter for the line that must be taken
     * @return Returns the line
     */
    public String getLine() {
        return line;
    }

    /**
     * Getter for the origin node
     * @return Returns the origin node
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Getter for the destination node
     * @return Returns the destination node
     */
    public Node getTo() {
        return to;
    }

}