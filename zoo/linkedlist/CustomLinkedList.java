package zoo.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {

    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private CustomNode<T> head;

    public CustomLinkedList() {

        this.head = null;

    }

    public void addNode(CustomNode<T> node) {

        if (this.head == null) {

            this.head = node;
        }

        else {
            CustomNode<T> currentNode = this.head;
            while (currentNode.next != null) {

                currentNode = currentNode.next;
            }
            currentNode.next = node;

        }

        LOGGER.info("Node added");
    }

    public void removeNode(CustomNode<T> node) {

        CustomNode<T> previousNode = null;
        CustomNode<T> currentNode = this.head;
        CustomNode<T> nextNode = null;

        if (this.head == node) {

            if (node.next == null) {

                this.head = null;
            }

            else {

                this.head.next = node.next;
            }
        }

        while (currentNode != node && currentNode != null) {

            previousNode = currentNode;
            currentNode = currentNode.next;
            if (currentNode.next != null) {

                nextNode = currentNode.next;
            }
        }

        if (previousNode != null) {

            if (currentNode.next == null) {

                previousNode.next = null;
            }

            else {

                previousNode.next = nextNode;
            }
        }

        else {

            if (nextNode != null) {

                this.head = nextNode;
            }

            else {

                this.head = null;
            }
        }

        LOGGER.info("Removed node");

    }
}
