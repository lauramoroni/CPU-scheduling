package schedulers;

import algorithms.MergeSort;
import entities.Processes;
import structures.queue.QueueList;

import static utils.GanttDiagram.diagram;

public class Priority implements Scheduler {
   int totalTime = 0;

   @Override
   public QueueList<Processes> scheduler(Processes[] processes) throws Exception {
      // ordenando os processos pela prioridade
      MergeSort.mergeMain(processes, "priority");

      // criando a fila de processos prontos
      QueueList<Processes> queue = new QueueList<Processes>(processes.length);
      for (int i = 0; i < processes.length; i++) {
         queue.add(processes[i]);
         totalTime += processes[i].getBurstTime();
      }
      diagram(queue, totalTime, processes.length);
      return queue;
   }
}
