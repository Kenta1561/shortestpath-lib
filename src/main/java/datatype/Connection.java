package main.java.datatype;

public class Connection {

    private final Node from;
    private final Node to;
    private final double rawTime;

    public Connection(Node from, Node to, double rawTime) {
        this.from = from;
        this.to = to;
        this.rawTime = rawTime;
        setValidation();
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

    private void setValidation() {
        from.validate();
        to.validate();
    }

}