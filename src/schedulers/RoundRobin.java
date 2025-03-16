package schedulers;

import entities.ProcessControlBlock;
import entities.Processes;
import structures.queue.QueueList;

public class RoundRobin implements Scheduler {
   public int quantum;

   public RoundRobin(int quantum) {
      this.quantum = quantum;
   }

   @Override
   public QueueList<Processes> scheduler(Processes[] processes) throws Exception {
      QueueList<ProcessControlBlock> queue = new QueueList<ProcessControlBlock>(processes.length);
      QueueList<Processes> readyQueue = new QueueList<Processes>(processes.length);

      ProcessControlBlock[] pcb = new ProcessControlBlock[processes.length];
      for (int i = 0; i < processes.length; i++) {
         pcb[i] = new ProcessControlBlock(processes[i], processes[i].getBurstTime());
         queue.add(pcb[i]);
      }

      

      return readyQueue;
   }  
}

