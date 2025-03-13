package algorithms;

public class MergeSort {
   public static void merge(int[] burstTime, int left, int middle, int right) {
      // transfere os elementos para um vetor auxiliar
      int[] aux = new int[burstTime.length];

      for (int i = left; i <= right; i++) {
         aux[i] = burstTime[i];
      }

      int i = left;
      int j = middle + 1;
      int k = left;

      // intercala entre as duas metades do vetor até que uma delas acabe
      while (i <= middle && j <= right) {
         if (aux[i] <= aux[j]) {
            burstTime[k] = aux[i];
            i++;
         } else {
            burstTime[k] = aux[j];
            j++;
         }
         k++;
      }

      // transfere os elementos restantes da primeira metade
      while (i <= middle) {
         burstTime[k] = aux[i];
         i++;
         k++;
      }
   }

   public static void mergeSort(int[] burstTime, int left, int right) {
      if (left >= right) {
         return;
      } else {
         int middle = (left + right) / 2;
         mergeSort(burstTime, left, middle);
         mergeSort(burstTime, middle + 1, right);
         merge(burstTime, left, middle, right);
      }
   }
}
