package main.java.datatype;

public class Path {

    private final Line line;
    private final Node to;

    public Path(Line line, Node to) {
        this.line = line;
        this.to = to;
    }

    public Line getLine() {
        return line;
    }

    public Node getTo() {
        return to;
    }

}