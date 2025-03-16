package schedulers;


import entities.Processes;
import structures.queue.QueueList;
import algorithms.MergeSort;

public class SJF implements Scheduler{

   public QueueList<Processes> scheduler(Processes[] processes) throws Exception {
      // lista de tempo dos processos
      int[] burstTime = new int[processes.length];
      for (int i = 0; i < processes.length; i++) {
         burstTime[i] = processes[i].getBurstTime();
      }

      // ordenando os processos pelo tempo de execução
      MergeSort.mergeMain(processes, "burstTime");

      // criando a fila de processos prontos
      QueueList<Processes> queue = new QueueList<Processes>(processes.length);
      for (int i = 0; i < processes.length; i++) {
         queue.add(processes[i]);
      }

      return queue;
   }

}
