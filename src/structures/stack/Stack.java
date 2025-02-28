package structures.stack;

public class Stack implements StackInterface{
   private int[] stack;
   private int top;
   private int size;

   public Stack(int size) {
      this.size = size;
      this.stack = new int[size];
      this.top = -1;
   }

   public void push(int value) {
      if (!isFull()) {
         stack[++top] = value;
      }
   }

   public int pop() {
      if (!isEmpty()) {
         return stack[top--];
      }
      return -1;
   }

   public int peek() {
      if (!isEmpty()) {
         return stack[top];
      }
      return -1;
   }

   public boolean isEmpty() {
      return top == -1;
   }

   public boolean isFull() {
      return top == size - 1;
   }

}
