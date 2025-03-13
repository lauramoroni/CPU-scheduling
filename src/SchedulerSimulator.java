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

        int option = 0;

        System.out.println("CPU Scheduler Simulator");
        System.out.println("[1] First Come First Serve");
        System.out.println("[2] Shortest Job First");
        System.out.println("[3] Round Robin");
        System.out.println("[4] Priority");
        System.out.println("[5] Exit");
        System.out.print("Choose an scheduler: ");
        option = Integer.parseInt(System.console().readLine());
        switch (option) {
            case 1:
                System.out.println("First Come First Serve");
                break;
            case 2:
                System.out.println("Shortest Job First");
                SJF sjf = new SJF();
                readyProcesses = sjf.scheduler(processes);
                break;
            case 3:
                System.out.println("Round Robin");
                break;
            case 4:
                System.out.println("Priority");
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        
        readyProcesses.show();

        // escreve no arquivo
        FileHandler fileHandler = new FileHandler();
        FileHandler.writeFile("tests\\output\\output2.txt", readyProcesses, "SJF");
    }
}
