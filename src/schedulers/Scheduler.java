package schedulers;

import java.util.List;

import entities.Processes;
import structures.queue.QueueList;

public interface Scheduler {
   QueueList scheduler(List<Processes> processes) throws Exception;
}
