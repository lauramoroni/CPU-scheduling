package structures.queue;

public interface QueueInterface <T> {
    void add(T p) throws Exception;

    T remove() throws Exception;

    T peek() throws Exception;

    boolean isEmpty();

    boolean isFull();

    void show() throws Exception;
}
