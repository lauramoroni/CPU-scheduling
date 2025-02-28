package structures.stack;

public class Stack<T> implements StackInterface<T>{
   private Object[] stack;
   private int top;
   private int size;

   public Stack(int size) {
      this.size = size;
      this.stack = new Object[size];
      this.top = -1;
   }

   public void push(T value) {
      if (!isFull()) {
         stack[++top] = value;
      } else {
         System.out.println("Error: Stack overflow");
      }
   }

   @SuppressWarnings("unchecked")
   public T pop() {
      if (!isEmpty()) {
         return (T) stack[top--];
      } else {
         System.out.println("Error: Stack underflow");
      }
      return null;
   }

   @SuppressWarnings("unchecked")
   public T peek() {
      if (!isEmpty()) {
         return (T) stack[top];
      } else {
         System.out.println("Error: Stack underflow");
      }
      return null;
   }

   public boolean isEmpty() {
      return top == -1;
   }

   public boolean isFull() {
      return top == size - 1;
   }

}
