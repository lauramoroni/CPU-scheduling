package schedulers;

import java.util.List;

import entities.Processes;
import structures.queue.QueueList;

public class RoundRobin implements Scheduler {
   public int quantum;

   public RoundRobin(int quantum) {
      this.quantum = quantum;
   }

   @Override
   public QueueList scheduler(Processes[] processes) {
      QueueList queue = new QueueList(processes.length);
      return queue;
   }  
}

