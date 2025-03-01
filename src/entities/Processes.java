package entities;

public class Processes {
   private int id;
   private String name;
   private int arrivalTime;
   private int burstTime;
   private int priority;

   public Processes(int id, String name, int arrivalTime, int burstTime, int priority) {
      this.id = id;
      this.name = name;
      this.arrivalTime = arrivalTime;
      this.burstTime = burstTime;
      this.priority = priority;
  }


   public int getPriority() {
      return priority;
   }

   public void setPriority(int priority) {
      this.priority = priority;
   }

   public int getBurstTime() {
      return burstTime;
   }

   public void setBurstTime(int burstTime) {
      this.burstTime = burstTime;
   }

   public int getArrivalTime() {
      return arrivalTime;
   }

   public void setArrivalTime(int arrivalTime) {
      this.arrivalTime = arrivalTime;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
}
