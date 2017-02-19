package main.java.datatype;

import main.java.exception.InvalidNetworkException;

import java.util.HashSet;

public class Node implements Comparable<Node> {

    private final String name;
    private double time;
    private final HashSet<String> lines;
    private Node previous;

    private boolean validatedConnectivity = false;

    public Node(String name, HashSet<String> lines) {
        this.name = name;
        if((lines != null) && (!lines.isEmpty())) {
            this.lines = lines;
        } else {
            throw new InvalidNetworkException("This network is invalid. No lines existing for this node.");
        }
    }

    public void setTime(double time) {
        this.time = time;
    }

    void validateConnectivity() {
        validatedConnectivity = true;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public HashSet<String> getLines() {
        return lines;
    }

    public Node getPrevious() {
        return previous;
    }

    public boolean isConnectivityValidated() {
        return validatedConnectivity;
    }

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
