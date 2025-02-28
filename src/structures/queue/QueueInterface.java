package structures.queue;

public interface QueueInterface <Processes>{
    void add(Processes p) throws Exception;

    Processes remove() throws Exception;

    Processes peek() throws Exception;

    boolean isEmpty();

    boolean isFull();

    void show() throws Exception;
}
