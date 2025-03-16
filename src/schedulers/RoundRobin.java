package schedulers;

import entities.ProcessControlBlock;
import entities.Processes;
import structures.queue.QueueList;

public class RoundRobin implements Scheduler {
   public int quantum;
   public int time = 0;

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

      while (!queue.isEmpty()) {
         ProcessControlBlock p = queue.remove();
         if (p.getRemainingTime() > 0) {
            if (p.getRemainingTime() > quantum) {
               time += quantum;
               p.setRemainingTime(p.getRemainingTime() - quantum);
               System.out.println("Processo " + p.getProcess(null).getId() + " em " + time + "ms");
               queue.add(p);
            } else {
               time += p.getRemainingTime();
               p.setRemainingTime(0);
               System.out.println("Processo " + p.getProcess(null).getId() + " finalizado em " + time + "ms");
               readyQueue.add(p.getProcess(null));
            }
         }
      }

      return readyQueue;
   }  
}

