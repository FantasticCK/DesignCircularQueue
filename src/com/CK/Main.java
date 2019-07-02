package com.CK;

import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(6); // set the size to be 3
        System.out.println(circularQueue.enQueue(6));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(5));

        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.isFull());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Front());

    }
}

class MyCircularQueue {
    private int fullSize = 0;
    private int currentSize = 0;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.fullSize = k;
        this.currentSize = 0;
        head = tail = null;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                currentSize++;
                head = tail = new Node(value);
            } else {
                currentSize++;
                Node newNode = new Node(value);
                tail.next = newNode;
                tail = newNode;
                if (isFull()) {
                    newNode.next = head;
                }
            }
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            if (isFull()) {
                currentSize--;
                head = head.next;
                tail.next = null;
            } else {
                currentSize--;
                head = head.next;
                if (isEmpty()) {
                    head = tail = null;
                }
            }
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        else return head.val;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        else return tail.val;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return currentSize == fullSize;
    }

    class Node {
        public int val;
        public Node next;

        public Node(int value) {
            this.val = value;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */