package schedulers;

import algorithms.MergeSort;
import entities.Processes;
import structures.queue.QueueList;

public class Priority implements Scheduler {
   public Priority() {
   }

   @Override
   public QueueList scheduler(Processes[] processes) throws Exception {
      // ordenando os processos pela prioridade
      MergeSort.mergeMain(processes, "priority");

      // criando a fila de processos prontos
      QueueList queue = new QueueList(processes.length);
      for (int i = 0; i < processes.length; i++) {
         queue.add(processes[i]);
      }

      return queue;
   }
}
