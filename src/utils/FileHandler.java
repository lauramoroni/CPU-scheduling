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

    public static void writeFile(String path, QueueList<Processes> processes, String scheduler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Scheduler: " + scheduler);
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
}