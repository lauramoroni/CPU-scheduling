package schedulers;

import entities.ProcessControlBlock;
import entities.ProcessState;
import entities.Processes;
import structures.queue.QueueList;
import utils.Color;

public class RoundRobin implements Scheduler {

   public int quantum;
   public int time = 0;

   public RoundRobin(int quantum) {
      this.quantum = quantum;
   }

   @Override
   public QueueList<Processes> scheduler(Processes[] processes) throws Exception {
      QueueList<ProcessControlBlock> queue = new QueueList<>(processes.length);
      QueueList<Processes> readyQueue = new QueueList<>(processes.length);

      ProcessControlBlock[] pcb = new ProcessControlBlock[processes.length];
      for (int i = 0; i < processes.length; i++) {
         pcb[i] = new ProcessControlBlock(processes[i], processes[i].getBurstTime());
         queue.add(pcb[i]);
      }

      int totalTime = 0;
      for (Processes p : processes) {
         totalTime += p.getBurstTime();
      }

      String[][] diagram = new String[processes.length][totalTime];
      for (int i = 0; i < processes.length; i++) {
         for (int j = 0; j < totalTime; j++) {
            diagram[i][j] = " ";
         }
      }

      int currentTime = 0;

      while (!queue.isEmpty()) {
         ProcessControlBlock p = queue.remove();
         p.setState(ProcessState.RUNNING);
         int processIndex = p.getProcess().getId() - 1;
         int executionTime = Math.min(p.getRemainingTime(), quantum);

         for (int j = 0; j < executionTime; j++) {
            diagram[processIndex][currentTime + j] = Color.ANSI_PURPLE_BACKGROUND+" "+Color.ANSI_RESET;
         }

         currentTime += executionTime;
         p.setRemainingTime(p.getRemainingTime() - executionTime);

         if (p.getRemainingTime() > 0) {
            p.setState(ProcessState.READY);
            queue.add(p); 
         } else {
            p.setState(ProcessState.TERMINATED);
            readyQueue.add(p.getProcess());
         }
      }

      showDiagram(diagram, currentTime);
      return readyQueue;
   }

   public void showDiagram(String[][] diagram, int totalTime) {
      System.out.println("Diagrama de Gantt:");

      // Imprimir linha do tempo
      System.out.print("Tempo  | ");
      for (int j = 0; j < totalTime; j++) {
         System.out.printf("%2d ", j);
      }
      System.out.println();
      System.out.println("--------" + "-".repeat(totalTime * 3));

      // Imprimir cada linha do diagrama associada ao processo
      for (int i = 0; i < diagram.length; i++) {
         System.out.print("P" + (i + 1) + "     | ");
         for (int j = 0; j < totalTime; j++) {
            System.out.print(diagram[i][j] + "  ");
         }
         System.out.println();
      }
   }
}
