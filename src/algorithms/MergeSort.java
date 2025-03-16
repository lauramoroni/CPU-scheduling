package algorithms;

import entities.Processes;

public class MergeSort {

   public static void mergeMain(Processes[] processes, String param) {
      if (param.equals("burstTime")) {
         int[] burstTime = new int[processes.length];
         for (int i = 0; i < processes.length; i++) {
            burstTime[i] = processes[i].getBurstTime();
         }
         mergeSort(burstTime, 0, burstTime.length - 1);
      } else if (param.equals("arrivalTime")) {
         int[] arrivalTime = new int[processes.length];
         for (int i = 0; i < processes.length; i++) {
            arrivalTime[i] = processes[i].getArrivalTime();
         }
         mergeSort(arrivalTime, 0, arrivalTime.length - 1);
      } else if (param.equals("priority")) {
         int[] priority = new int[processes.length];
         for (int i = 0; i < processes.length; i++) {
            priority[i] = processes[i].getPriority();
         }
         mergeSort(priority, 0, priority.length - 1);
      }
   }

   public static void merge(int[] param, int left, int middle, int right) {
      // transfere os elementos para um vetor auxiliar
      int[] aux = new int[param.length];

      for (int i = left; i <= right; i++) {
         aux[i] = param[i];
      }

      int i = left;
      int j = middle + 1;
      int k = left;

      // intercala entre as duas metades do vetor até que uma delas acabe
      while (i <= middle && j <= right) {
         if (aux[i] <= aux[j]) {
            param[k] = aux[i];
            i++;
         } else {
            param[k] = aux[j];
            j++;
         }
         k++;
      }

      // transfere os elementos restantes da primeira metade
      while (i <= middle) {
         param[k] = aux[i];
         i++;
         k++;
      }
   }

   public static void mergeSort(int[] param, int left, int right) {
      if (left >= right) {
         return;
      } else {
         int middle = (left + right) / 2;
         mergeSort(param, left, middle);
         mergeSort(param, middle + 1, right);
         merge(param, left, middle, right);
      }
   }
}
