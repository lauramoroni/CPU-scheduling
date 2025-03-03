package schedulers;

import java.util.List;

import entities.Processes;
import structures.queue.QueueList;
import algorithms.MergeSort;

public class SJF implements Scheduler{

   public QueueList scheduler(List<Processes> processes) throws Exception {
      // lista de tempo dos processos
      int[] burstTime = new int[processes.size()];
      for (int i = 0; i < processes.size(); i++) {
         burstTime[i] = processes.get(i).getBurstTime();
      }

      // ordenando os processos pelo tempo de execução
      MergeSort.mergeSort(burstTime, 0, burstTime.length - 1);

      // criando a fila de processos prontos
      QueueList queue = new QueueList(processes.size());
      for (int i = 0; i < burstTime.length; i++) {
         for (int j = 0; j < processes.size(); j++) {
            if (burstTime[i] == processes.get(j).getBurstTime()) {
               queue.add(processes.get(j));
            }
         }
      }

      return queue;
   }

}
