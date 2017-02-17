package main.java;

import main.java.datatype.Node;

import java.util.ArrayList;

class Queue {

    private final ArrayList<Node> queue;

    Queue() {
        queue = new ArrayList<>();
    }

    void addNode(Node node) {
        queue.add(node);
        sortQueue();
    }

    void removeFirstNode() {
        queue.remove(0);
        sortQueue();
    }

    Node getFirstNode() {
        return queue.get(0);
    }

    int getQueueLength() {
        return queue.size();
    }

    private void sortQueue() {
        queue.sort(Node::compareTo);
    }

}
