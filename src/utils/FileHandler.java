package utils;

import java.io.*;

import entities.Processes;
import structures.queue.QueueList;

public class FileHandler {

    public static Processes[] readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            int n = 0;
            if ((line = reader.readLine()) != null) {
                n = Integer.parseInt(line);
            }
            Processes[] processes = new Processes[n]; // Implementando o vetor
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int arrivalTime = Integer.parseInt(data[2]);
                int burstTime = Integer.parseInt(data[3]);
                int priority = Integer.parseInt(data[4]);
                processes[index++] = new Processes(id, name, arrivalTime, burstTime, priority);
            }

            System.out.println(Color.ANSI_GREEN + "File read successfully!" + Color.ANSI_RESET);

            return processes;
        } catch (IOException e) {
            System.out.println(Color.ANSI_RED + "Error reading file: " + e.getMessage() + Color.ANSI_RESET);
            System.exit(1);
        } catch (Exception e) {
            System.out.println(Color.ANSI_RED + "Error processing file: " + e.getMessage() + Color.ANSI_RESET);
        }
        return null;
    }

    public static void writeFile(String path, QueueList<Processes> processes, String scheduler, int quantum) {
        if (path.endsWith(".txt")) {
            writeTxtFile(path, processes, scheduler, quantum);
        } else if (path.endsWith(".csv")) {
            writeCSVFile(path, processes, scheduler, quantum);
        } else if (path.endsWith(".dat")) {
            writeDatFile(path, processes, scheduler, quantum);
        } else {
            System.err.println(Color.ANSI_RED + "Invalid file format" + Color.ANSI_RESET);
        }
    }

    public static void writeTxtFile(String path, QueueList<Processes> processes, String scheduler, int quantum) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Scheduler: " + scheduler);

            if (scheduler.equals("Round Robin")) {
                writer.write(" - Quantum: " + quantum);
            }

            writer.newLine();

            while (!processes.isEmpty()) {
                Processes process = processes.remove();
                writer.write(process.toString());
                writer.newLine();

                System.out.println(Color.ANSI_PURPLE + "Reading process " + process.getId() + Color.ANSI_RESET);
                System.out.println(Color.ANSI_GREEN + "Process = " + process.getName() + " = written to file" + Color.ANSI_RESET);
            }
        } catch (IOException e) {
            System.err.println(Color.ANSI_RED + "Error writing to file: " + e.getMessage() + Color.ANSI_RESET);
        } catch (Exception e) {
            System.err.println(Color.ANSI_RED + "Error processing queue: " + e.getMessage() + Color.ANSI_RESET);
        }
    }

    public static void writeCSVFile(String path, QueueList<Processes> processes, String scheduler, int quantum) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("ID,Name,Arrival Time,Burst Time,Priority,Quantum");
            writer.newLine();

            while (!processes.isEmpty()) {
                Processes process = processes.remove();
                writer.write(process.toCSV() + "," + quantum);
                writer.newLine();

                System.out.println(Color.ANSI_PURPLE + "Reading process " + process.getId() + Color.ANSI_RESET);
                System.out.println(Color.ANSI_GREEN + "Process = " + process.getName() + " = written to file" + Color.ANSI_RESET);
            }
        } catch (IOException e) {
            System.err.println(Color.ANSI_RED + "Error writing to file: " + e.getMessage() + Color.ANSI_RESET);
        } catch (Exception e) {
            System.err.println(Color.ANSI_RED + "Error processing queue: " + e.getMessage() + Color.ANSI_RESET);
        }
    }

    public static void writeDatFile(String path, QueueList<Processes> processes, String scheduler, int quantum) {
        try (FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeUTF(scheduler); 
            
            if (scheduler.equals("Round Robin")) {
                objectOut.writeInt(quantum);   
            }

            while (!processes.isEmpty()) {
                Processes process = processes.remove(); 
                objectOut.writeObject(process);

                System.out.println(Color.ANSI_PURPLE + "Reading process " + process.getId() + Color.ANSI_RESET);
                System.out.println(Color.ANSI_GREEN + "Process = " + process.getName() + " = written to binary file" + Color.ANSI_RESET);
            }
        } catch (IOException e) {
            System.err.println(Color.ANSI_RED + "Error writing to binary file: " + e.getMessage() + Color.ANSI_RESET);
        } catch (Exception e) {
            System.err.println(Color.ANSI_RED + "Error processing queue: " + e.getMessage() + Color.ANSI_RESET);
        }
    }
}
