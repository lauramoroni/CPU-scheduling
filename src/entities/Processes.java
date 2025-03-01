package entities;

public class Processes {
   public int id;
   public int arrivalTime;
   public int burstTime;
   public int priority;

   public Processes(int id, int arrivalTime, int burstTime, int priority) {
      this.id = id;
      this.arrivalTime = arrivalTime;
      this.burstTime = burstTime;
      this.priority = priority;
  }
  
}
