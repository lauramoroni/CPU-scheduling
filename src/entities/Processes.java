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

   public int getId() {
      return id;
   }

   public int getArrivalTime() {
      return arrivalTime;
   }

   public void setArrivalTime(int arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   public int getBurstTime() {
      return burstTime;
   }

   public void setBurstTime(int burstTime) {
      this.burstTime = burstTime;
   }

   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }
  
}
