package main.java;

import main.java.datatype.Line;
import main.java.datatype.Node;
import main.java.exception.UnregisteredItemException;

import java.util.ArrayList;

/**
 * This is the main class of this library. An instance of this class is
 * required for registering all the required components to calculate a path.
 */
public class ShortestPath {

    public final ArrayList<Node> nodes;
    public final ArrayList<Line> lines;

    public ShortestPath() {
        nodes = new ArrayList<>();
        lines = new ArrayList<>();
    }

    public void addLine(Line line) {}

    public void addLines(ArrayList<Line> lines) {}

    public void addNode(Node node) {}

    public void addNodes(ArrayList<Node> nodes) {}

}