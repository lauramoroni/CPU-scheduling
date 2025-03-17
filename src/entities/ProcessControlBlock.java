package entities;

public class ProcessControlBlock {
   private Processes process;
   private int remainingTime;
   private ProcessState state;

   public ProcessControlBlock(Processes process, int remainingTime) {
      this.process = process;
      this.remainingTime = remainingTime;
      this.state = ProcessState.READY;
   }

   public Processes getProcess() {
      return process;
   }

   public void setProcess(Processes process) {
      this.process = process;
   }

   public int getRemainingTime() {
      return remainingTime;
   }

   public void setRemainingTime(int remainingTime) {
      this.remainingTime = remainingTime;
   }

   public ProcessState getState() {
      return state;
   }

   public void setState(ProcessState state) {
      this.state = state;
   }

   public String toString() {
      return "ProcessControlBlock{" + "process=" + process + ", remainingTime=" + remainingTime + ", state=" + state + '}';
   }
}
