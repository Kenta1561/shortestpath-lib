package main.java.datatype;

class Path {

    private final Line line;
    private final Node to;

    Path(Line line, Node to) {
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