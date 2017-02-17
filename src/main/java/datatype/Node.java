package main.java.datatype;

import main.java.ShortestPath;

import java.util.ArrayList;

public class Node implements Comparable<Node> {

    private final double code;
    private final String name;
    private double time;
    private final ArrayList<Line> lines;
    private Node previous;

    public Node(double code, String name, ArrayList<Line> lines) {
        this.code = code;
        this.name = name;
        this.lines = lines;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public double getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Node getPrevious() {
        return previous;
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
