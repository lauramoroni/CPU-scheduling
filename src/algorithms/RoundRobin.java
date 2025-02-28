package algorithms;

import java.util.List;

import entities.Processes;

public class RoundRobin implements Scheduler {
   public int quantum;

   public RoundRobin(int quantum) {
      this.quantum = quantum;
   }

   @Override
   public void scheduler(List<Processes> processes) {
   }  
}

