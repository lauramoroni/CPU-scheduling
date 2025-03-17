package structures.queue;

public class QueueList<T> implements QueueInterface<T> {
    class Node{ // intern node class to implement linked list
        T data;
        Node next;

        public Node(T data){
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
    public T getNext(T p) {
        Node current = head;

        //
        while( current.next != null )
        {
            if( current.data.equals(p) ) {
                return current.next.data;
            }
            current = current.next;
        }

        return null; // Retorna null se o elemento não for encontrado
    }
    @Override
    public void add(T p) throws Exception{
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
    public T remove() throws Exception {
        // storing the head node
        Node p = head;

        if (isEmpty()){
            throw new Exception("The queue is empty");
        }

        // storing the data
        T removeData = head.data;

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
    public T peek() throws Exception {
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
