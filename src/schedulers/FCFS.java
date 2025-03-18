package schedulers;  

import java.util.Arrays;
import java.util.Comparator;
import entities.Processes;  
import structures.queue.QueueList;      


public class FCFS implements Scheduler {     

    @Override 
    public QueueList<Processes> scheduler(Processes[] processes) throws Exception {          
        // Criando a fila de processos prontos  
        QueueList<Processes> queue = new QueueList<>(processes.length);    
         
        // Ordenando os processos pela ordem de chegada 
        Arrays.sort(processes, Comparator.comparingInt(Processes::getArrivalTime));  

        // Adicionando os processos na fila
        for (Processes process : processes) { 
            queue.add(process); 
        }
        
        return queue;
    }
}
