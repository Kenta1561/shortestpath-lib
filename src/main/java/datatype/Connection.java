package main.java.datatype;

public class Connection {

    private Node from;
    private Node to;
    private double rawTime;

    public Connection(Node from, Node to, double rawTime) {
        this.from = from;
        this.to = to;
        this.rawTime = rawTime;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public double getRawTime() {
        return rawTime;
    }

}