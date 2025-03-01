package structures.stack;

public interface StackInterface<T> {
   void push(T value) throws Exception;
   T pop() throws Exception;
   T peek() throws Exception;
   boolean isEmpty();
   boolean isFull();
   void show();
}
