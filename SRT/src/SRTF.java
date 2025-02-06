import java.util.ArrayList;
import java.util.List;

class Process {
    int processID;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

class ShortestRemainingTime {
    private int idleTime = 0; // Tracks total idle time

    public void scheduleProcesses(List<Process> processes) {
        int currentTime = 0;
        int completed = 0;
        int n = processes.size();
        Process currentProcess = null;

        while (completed < n) {
            // Find process with shortest remaining time that has arrived
            Process shortest = null;
            for (Process process : processes) {
                if (process.arrivalTime <= currentTime && process.remainingTime > 0) {
                    if (shortest == null || process.remainingTime < shortest.remainingTime) {
                        shortest = process;
                    }
                }
            }

            if (shortest == null) {
                idleTime++; // CPU is idle
                currentTime++;
                continue;
            }

            currentProcess = shortest;
            currentTime++;
            currentProcess.remainingTime--;

            // Check if the current process is completed
            if (currentProcess.remainingTime == 0) {
                currentProcess.completionTime = currentTime;
                currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
                completed++;
            }
        }
    }

    public void displayResults(List<Process> processes) {
        System.out.println("ProcessID\tArrivalTime\tBurstTime\tCompletionTime\tTurnaroundTime\tWaitingTime");
        for (Process process : processes) {
            System.out.println(process.processID + "\t\t\t\t" +
                    process.arrivalTime + "\t\t\t" +
                    process.burstTime + "\t\t\t" +
                    process.completionTime + "\t\t\t\t" +
                    process.turnaroundTime + "\t\t\t\t" +
                    process.waitingTime);
        }

        double avgTurnaroundTime = processes.stream().mapToDouble(p -> p.turnaroundTime).average().orElse(0);
        double avgWaitingTime = processes.stream().mapToDouble(p -> p.waitingTime).average().orElse(0);

        int totalTime = processes.stream().mapToInt(p -> p.completionTime).max().orElse(0);
        int busyTime = totalTime - idleTime;

        double cpuUtilization = ((double) busyTime / totalTime) * 100;

        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}
