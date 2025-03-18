package utils;

import entities.Processes;
import structures.queue.QueueList;

public class GanttDiagram {
    public static void diagram(QueueList<Processes> readyQueue, int totalTime, int size) throws Exception {
        System.out.println("Diagrama de Gantt:");

        // Imprimir linha do tempo
        System.out.print("Tempo  | ");
        for (int j = 0; j < totalTime; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();
        System.out.println("--------" + "-".repeat(totalTime * 3));

        // Criar e preencher a matriz do diagrama
        String[][] diagram = new String[size][totalTime];
        Processes p = readyQueue.peek();
        int currentTime = 0;
        for (int i = 0; i < size; i++) {
            int processIndex = p.getId() - 1;
            int burst = p.getBurstTime();
            for (int j = 0; j < burst; j++) {
                diagram[processIndex][currentTime + j] = Color.ANSI_PURPLE_BACKGROUND+" "+Color.ANSI_RESET;
            }
            p = readyQueue.getNext(p);
            currentTime += burst;
        }

        // Imprimir o diagrama formatado
        for (int i = 0; i < size; i++) {
            System.out.printf("P%d     | ", i + 1);
            for (int j = 0; j < totalTime; j++) {
                System.out.print((diagram[i][j] != null ? diagram[i][j] : ' ') + "  ");
            }
            System.out.println();
        }
    }
}
