package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entities.Processes;
import structures.stack.Stack;

public class FileHandler {

    public static void writeFile(String path, Stack<Processes> processes, String scheduler) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Scheduler: " + scheduler);
            writer.newLine();

            while (!processes.isEmpty()) {
                Processes process = processes.pop();
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
