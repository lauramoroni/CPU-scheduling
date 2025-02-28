package entities;

public class Processes {
   public int id;
   public String name;
   public int arrivalTime;
   public int burstTime;
   public int priority;

   public Processes(int id, String name, int arrivalTime, int burstTime, int priority) {
      this.id = id;
      this.name = name;
      this.arrivalTime = arrivalTime;
      this.burstTime = burstTime;
      this.priority = priority;
  }
}
