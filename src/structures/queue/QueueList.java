package structures.queue;

import entities.Processes;

public class QueueList implements QueueInterface {
    class Node{ // intern node class to implement linked list
        Processes data;
        Node next;

        public Node(Processes data){
            this.data = data;
            this.next = null;
        }
    }

    // control variables
    private Node head;
    private Node tail;
    private int size;
    private int capacity;


    public QueueList(int capacity){
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public void add(Processes p) throws Exception{
        Node newNode = new Node(p);

        // if the queue is full
        if (isFull()){
            throw new Exception("Queue is full");
        }

        // if the queue is empty
        if (head == null){
            head = newNode;
            tail = newNode;
        }

        tail.next = newNode; // conecting the new node in the end of the queue
        tail = newNode; // updating the tail
        size++;// updating the size
    }

    @Override
    public Processes remove() throws Exception {
        // storing the head node
        Node p = head;

        if (isEmpty()){
            throw new Exception("The queue is empty");
        }

        // storing the data
        Processes removeData = head.data;

        // removing the first element
        if (head == tail){
            // removing the conection with the node
            head = null;
            tail = null;
            size--;
            return removeData;
        }

        head = head.next; // indicating that the head of the queue will be the next node

        p.next = null; // removing the conection with the node

        size--;
        return removeData;
    }

    @Override
    public Processes peek() throws Exception {
        if (isEmpty()){
            throw new Exception("The queue is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else{
            return false;
        }
    }

    public boolean isFull(){
        if(size == capacity){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void show() throws Exception {
        Node p = head;
        while (p != null){
            System.out.println(p.data.toString());
            p = p.next;
        }
    }
}
