import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Process {
    int processID;
    int arrivalTime;
    int burstTime;
    int priority;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(int processID, int arrivalTime, int burstTime, int priority) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

class PriorityScheduling {
    public void scheduleProcesses(List<Process> processes) {
        int currentTime = 0;
        int totalIdleTime = 0;

        // Sort processes by arrival time first, and then by priority
        processes.sort(Comparator.comparingInt((Process p) -> p.arrivalTime).thenComparingInt(p -> p.priority));

        for (Process process : processes) {
            if (currentTime < process.arrivalTime) {
                totalIdleTime += (process.arrivalTime - currentTime);
                currentTime = process.arrivalTime;
            }

            process.completionTime = currentTime + process.burstTime;
            process.turnaroundTime = process.completionTime - process.arrivalTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;

            currentTime = process.completionTime;
        }

        int totalBurstTime = processes.stream().mapToInt(p -> p.burstTime).sum();
        double cpuUtilization = ((double) totalBurstTime / (totalBurstTime + totalIdleTime)) * 100;
        displayResults(processes, cpuUtilization);
    }

    public void displayResults(List<Process> processes, double cpuUtilization) {
        System.out.println("ProcessID\tArrivalTime\tBurstTime\tPriority\tCompletionTime\tTurnaroundTime\tWaitingTime");
        for (Process process : processes) {
            System.out.println(process.processID + "\t\t\t\t" +
                    process.arrivalTime + "\t\t\t" +
                    process.burstTime + "\t\t\t" +
                    process.priority + "\t\t" +
                    process.completionTime + "\t\t\t\t" +
                    process.turnaroundTime + "\t\t\t\t" +
                    process.waitingTime);
        }

        double avgTurnaroundTime = processes.stream().mapToDouble(p -> p.turnaroundTime).average().orElse(0);
        double avgWaitingTime = processes.stream().mapToDouble(p -> p.waitingTime).average().orElse(0);

        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}