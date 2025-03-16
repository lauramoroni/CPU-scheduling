import java.util.Scanner;

import entities.Processes;
import schedulers.RoundRobin;
import schedulers.SJF;
import structures.queue.QueueList;
import utils.Color;
import utils.FileHandler;

public class SchedulerSimulator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(Color.ANSI_BLUE + "===== CPU Scheduler Simulator =====" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLUE + "Starting program..." + Color.ANSI_RESET);
        
        System.out.println("Path to input file: ");
        String path = sc.nextLine(); // "tests\\input\\input.txt"
        
        System.out.println(Color.ANSI_PURPLE + "Reading file..." + Color.ANSI_RESET);
        Processes[] processes = FileHandler.readFile(path);
        
        System.out.println(Color.ANSI_PURPLE + "Loading processes..." + Color.ANSI_RESET);
        QueueList readyProcesses = new QueueList(processes.length);
        System.out.println(Color.ANSI_GREEN + "Processes loaded successfully!" + Color.ANSI_RESET);
        
        System.out.println(Color.ANSI_BLUE + "Starting scheduler..." + Color.ANSI_RESET);

        int option = 0;
        
        while (option != 5) {
            
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
                    System.out.println(Color.ANSI_PURPLE + "Writing to file..." + Color.ANSI_RESET);
                    try {
                        FileHandler.writeFile("tests\\output\\SJF.txt", readyProcesses, "SJF");
                        System.out.println(Color.ANSI_GREEN + "File written successfully!" + Color.ANSI_RESET);
                    } catch (Exception e) {
                        System.out.println(Color.ANSI_RED + "Error writing file: " + e.getMessage() + Color.ANSI_RESET);
                    } 
                    break;
                case 3:
                    System.out.println("Round Robin");
                    RoundRobin rr = new RoundRobin(2);
                    readyProcesses = rr.scheduler(processes);
                    System.out.println(Color.ANSI_PURPLE + "Writing to file..." + Color.ANSI_RESET);
                    try {
                        FileHandler.writeFile("tests\\output\\RoundRobin.txt", readyProcesses, "Round Robin");
                        System.out.println(Color.ANSI_GREEN + "File written successfully!" + Color.ANSI_RESET);
                    } catch (Exception e) {
                        System.out.println(Color.ANSI_RED + "Error writing file: " + e.getMessage() + Color.ANSI_RESET);
                    }
                    break;
                    case 4:
                    System.out.println("Priority");
                    break;
                    case 5:
                    System.out.println(Color.ANSI_RED + "Exit the program" + Color.ANSI_RESET);
                    break;
                    default:
                    System.out.println("Invalid option");
                    break;
            }
            
            readyProcesses.show();
        }


        sc.close();
    }
}
