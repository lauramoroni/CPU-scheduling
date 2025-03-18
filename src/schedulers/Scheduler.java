package schedulers;

import entities.Processes;
import structures.queue.QueueList;

public interface Scheduler {
   QueueList<Processes> scheduler(Processes[] processes) throws Exception;
}
