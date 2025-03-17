import java.util.Scanner;

import entities.Processes;
import schedulers.Priority;
import schedulers.RoundRobin;
import schedulers.SJF;
import structures.queue.QueueList;
import utils.Color;
import utils.FileHandler;

public class SchedulerSimulator {
@SuppressWarnings({ "unchecked", "unused" })
public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);

      System.out.println(Color.ANSI_BLUE + "===== CPU Scheduler Simulator =====" + Color.ANSI_RESET);

      System.out.println(Color.ANSI_BLUE + "Starting program..." + Color.ANSI_RESET);

      System.out.println("Path to input file: ");
      String path = sc.nextLine(); // "tests\\input\\input.txt"

      System.out.println(Color.ANSI_PURPLE + "Reading file..." + Color.ANSI_RESET);
      Processes[] processes = FileHandler.readFile(path);

      processes[0].toString();
      
      System.out.println(Color.ANSI_PURPLE + "Loading processes..." + Color.ANSI_RESET);
      QueueList<Processes> readyProcesses = new QueueList<Processes>(processes.length);

      System.out.println(Color.ANSI_GREEN + "Processes loaded successfully!" + Color.ANSI_RESET);

      System.out.println(Color.ANSI_BLUE + "Starting scheduler..." + Color.ANSI_RESET);

      int option = 0;

      while (option != 5) {

         System.out.println("[1] .txt");
         System.out.println("[2] .csv");
         System.out.println("Choose format output file:");

         int formatOption = Integer.parseInt(System.console().readLine());

         System.out.println("CPU Scheduler Simulator");
         System.out.println("[1] First Come First Serve");
         System.out.println("[2] Shortest Job First");
         System.out.println("[3] Round Robin");
         System.out.println("[4] Priority");
         System.out.println("[5] Exit");
         System.out.print("Choose an scheduler: ");

         option = Integer.parseInt(System.console().readLine());

         String format = "";
         if (formatOption == 1) {
            format = ".txt";
         } else if (formatOption == 2) {
            format = ".csv";
         } else {
            System.out.println(Color.ANSI_RED + "Invalid option" + Color.ANSI_RESET);
         }
         

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
                  FileHandler.writeFile("tests\\output\\SJF" + format, readyProcesses, "SJF", 0);
                  System.out.println(Color.ANSI_GREEN + "File written successfully!" + Color.ANSI_RESET);
               } catch (Exception e) {
                  System.out.println(Color.ANSI_RED + "Error writing file: " + e.getMessage() + Color.ANSI_RESET);
               } 
               break;
            case 3:
               System.out.println("Round Robin");

               System.out.println("Quantum: ");
               int quantum = sc.nextInt();

               RoundRobin rr = new RoundRobin(quantum);
               readyProcesses = rr.scheduler(processes);

               System.out.println(Color.ANSI_PURPLE + "Writing to file..." + Color.ANSI_RESET);

               try {
                  FileHandler.writeFile("tests\\output\\RoundRobin" + format, readyProcesses, "Round Robin", quantum);
                  System.out.println(Color.ANSI_GREEN + "File written successfully!" + Color.ANSI_RESET);
               } catch (Exception e) {
                  System.out.println(Color.ANSI_RED + "Error writing file: " + e.getMessage() + Color.ANSI_RESET);
               }
               break;
            case 4:
               System.out.println("Priority");

               Priority priority = new Priority();
               readyProcesses = priority.scheduler(processes);

               System.out.println(Color.ANSI_PURPLE + "Writing to file..." + Color.ANSI_RESET);

               try {
                  FileHandler.writeFile("tests\\output\\priority" + format, readyProcesses, "Priority", 0);
                  System.out.println(Color.ANSI_GREEN + "File written successfully!" + Color.ANSI_RESET);
               } catch (Exception e) {
                  System.out.println(Color.ANSI_RED + "Error writing file: " + e.getMessage() + Color.ANSI_RESET);
               }
               break;
            case 5:
               System.out.println(Color.ANSI_RED + "Exit the program" + Color.ANSI_RESET);
               break;
            default:
               System.out.println(Color.ANSI_RED + "Invalid option" + Color.ANSI_RED);
               break;
         }
         readyProcesses.show();
      }
      sc.close();
   }
}
