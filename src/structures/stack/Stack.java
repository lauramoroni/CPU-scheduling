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

   public void push(T value) throws Exception {
      if (!isFull()) {
         stack[++top] = value;
      } else {
         throw new Exception("Error: Stack overflow");
      }
   }

   @SuppressWarnings("unchecked")
   public T pop() throws Exception {
      if (!isEmpty()) {
         return (T) stack[top--];
      } else {
         throw new Exception("Error: Stack underflow");
      }
   }

   @SuppressWarnings("unchecked")
   public T peek() throws Exception {
      if (!isEmpty()) {
         return (T) stack[top];
      } else {
         throw new Exception("Error: Stack underflow");
      }
   }

   public boolean isEmpty() {
      return top == -1;
   }

   public boolean isFull() {
      return top == size - 1;
   }

   public void show() {
      for (int i = 0; i <= top; i++) {
         System.out.println(stack[i].toString());
      }
   }

}
