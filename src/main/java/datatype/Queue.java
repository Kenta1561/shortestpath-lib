package main.java.datatype;

import java.util.ArrayList;

public class Queue {

    private final ArrayList<Node> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void addNode(Node node) {
        queue.add(node);
        sortQueue();
    }

    public void removeFirstNode() {
        queue.remove(0);
        sortQueue();
    }

    public Node getFirstNode() {
        return queue.get(0);
    }

    public int getQueueLength() {
        return queue.size();
    }

    private void sortQueue() {
        queue.sort(Node::compareTo);
    }

}