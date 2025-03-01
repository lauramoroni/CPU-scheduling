package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;

import entities.Processes;
import structures.stack.Stack;

public class FileHandler {
      public static void writeFile(String path, Stack<Processes> processes, String scheduler) throws Exception {
         BufferedWriter writer = new BufferedWriter(new FileWriter(path));
         
         writer.write("Scheduler: " + scheduler);
         writer.newLine();

         while (!processes.isEmpty()) {
             Processes process = processes.pop();
             writer.write(process.toString());
             writer.newLine();
         }

         writer.close();
      }
}
