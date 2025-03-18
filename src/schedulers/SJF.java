package schedulers;

import entities.Processes;
import structures.queue.QueueList;
import algorithms.MergeSort;

import static utils.GanttDiagram.diagram;

public class SJF implements Scheduler {

   public QueueList<Processes> scheduler(Processes[] processes) throws Exception {
      int size = processes.length;
      int totalTime = 0;

      // Criando array para armazenar tempos de burst
      int[] burstTime = new int[size];
      for (int i = 0; i < size; i++) {
         burstTime[i] = processes[i].getBurstTime();
      }

      // Ordenando os processos pelo tempo de execução (SJF - menor primeiro)
      MergeSort.mergeMain(processes, "burstTime");

      // Criando a fila de processos prontos
      QueueList<Processes> queue = new QueueList<>(size);
      for (int i = 0; i < size; i++) {
         queue.add(processes[i]);
         totalTime += processes[i].getBurstTime();
      }

      // Criando e imprimindo o diagrama de Gantt
      diagram(queue, totalTime, size);

      return queue;
   }


}
