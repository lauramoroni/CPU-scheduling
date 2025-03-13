package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entities.Processes;
import structures.queue.QueueList;

public class FileHandler {

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
