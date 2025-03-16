import java.util.ArrayList;
import java.util.List;

import entities.Processes;
import schedulers.SJF;
import structures.queue.QueueList;
import utils.FileHandler;

public class SchedulerSimulator {
    public static void main(String[] args) throws Exception {
        List<Processes> processes = new ArrayList<Processes>();
        processes.add(new Processes(1, "P1", 0, 5, 3));
        processes.add(new Processes(2, "P2", 1, 3, 1));
        processes.add(new Processes(3, "P3", 2, 8, 4));
        processes.add(new Processes(4, "P4", 3, 6, 2));
        processes.add(new Processes(5, "P5", 4, 7, 5));

        QueueList readyProcesses = new QueueList(processes.size());
        SJF sjf = new SJF();
        readyProcesses = sjf.scheduler(processes);


        readyProcesses.show();

        // escreve no arquivo
        FileHandler fileHandler = new FileHandler();
        FileHandler.writeFile("tests\\output\\output2.txt", readyProcesses, "SJF");

    }
}
