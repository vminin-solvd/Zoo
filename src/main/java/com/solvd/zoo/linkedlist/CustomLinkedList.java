package com.solvd.zoo.linkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> {

    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private CustomNode<T> head;

    public CustomLinkedList() {
        this.head = null;
    }

    public void add(T data) {
        CustomNode<T> nextNode = null;
        CustomNode<T> newNode = new CustomNode<>(data, nextNode);
        if (this.head == null) {
            this.head = newNode;
        } else {
            CustomNode<T> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        LOGGER.info("Node with data " + data + " added");
    }

    public void remove(T data) {
        CustomNode<T> currentNode = this.head;
        CustomNode<T> previousNode = null;

        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                if (previousNode == null) {
                    this.head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                LOGGER.info("Node with data " + data + " removed");
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        LOGGER.info("Node with data " + data + " not found");
    }

    public List<T> getAll() {
        List<T> dataList = new ArrayList<>();
        CustomNode<T> currentNode = this.head;
        while (currentNode != null) {
            dataList.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return dataList;
    }

    public T get(int index) {
        CustomNode<T> currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            if (currentIndex == index) {
                LOGGER.info("Data at index {}: {}", index, currentNode.data);
                return currentNode.data;
            }
            currentIndex++;
            currentNode = currentNode.next;
        }
        return null;
    }
}
