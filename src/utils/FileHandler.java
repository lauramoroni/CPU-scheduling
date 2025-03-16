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
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int arrivalTime = Integer.parseInt(data[2]);
                int burstTime = Integer.parseInt(data[3]);
                int priority = Integer.parseInt(data[4]);
                processes[id] = new Processes(id, name, arrivalTime, burstTime, priority);
            }
            return processes;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
        return null;
    }

    public static void writeFile(String path, QueueList processes, String scheduler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Scheduler: " + scheduler);
            writer.newLine();

            while (!processes.isEmpty()) {
                Processes process = processes.remove();
                writer.write(process.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing stack: " + e.getMessage());
        }
    }
}
