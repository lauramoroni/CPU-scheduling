package schedulers;


import entities.Processes;
import structures.queue.QueueList;
import algorithms.MergeSort;

public class SJF implements Scheduler{

   public QueueList scheduler(Processes[] processes) throws Exception {
      // lista de tempo dos processos
      int[] burstTime = new int[processes.length];
      for (int i = 0; i < processes.length; i++) {
         burstTime[i] = processes[i].getBurstTime();
      }

      // ordenando os processos pelo tempo de execução
      MergeSort.mergeSort(burstTime, 0, burstTime.length - 1);

      // criando a fila de processos prontos
      QueueList queue = new QueueList(processes.length);
      for (int i = 0; i < burstTime.length; i++) {
         for (int j = 0; j < processes.length; j++) {
            if (burstTime[i] == processes[i].getBurstTime()) {
               queue.add(processes[i]);
            }
         }
      }

      return queue;
   }

}
