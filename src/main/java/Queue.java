package main.java;

import main.java.datatype.Node;

import java.util.ArrayList;

/**
 * @author Kenta1561
 * This class manages the queue that stores nodes awaiting for being processed.
 */
class Queue {

    /**
     * The queue with the nodes
     */
    private final ArrayList<Node> queue;

    /**
     * Basic constructor, initializes the queue ArrayList
     */
    Queue() {
        queue = new ArrayList<>();
    }

    /**
     * Adds a node to the queue and sorts it at the same time
     * @param node Requires the node to be added
     */
    void addNode(Node node) {
        queue.add(node);
        sortQueue();
    }

    /**
     * Remove the first node from the queue and sorts it at the same time
     */
    void removeFirstNode() {
        queue.remove(0);
        sortQueue();
    }

    /**
     * Returns the first {@link Node} instance from the queue
     * @return Returns the first {@link Node} instance from the queue
     */
    Node getFirstNode() {
        return queue.get(0);
    }

    /**
     * Sorts the queue by using {@link Node#compareTo(Node)} (sorts by travel time from starting node)
     */
    void sortQueue() {
        queue.sort(Node::compareTo);
    }

}
