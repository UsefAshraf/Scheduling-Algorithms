import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Process {
    int processID;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}


class ShortestJobFirst {
    public void scheduleProcesses(List<Process> processes) {
        int currentTime = 0;
        int completed = 0;
        int n = processes.size();

        // Sort processes by arrival time initially
        processes.sort(Comparator.comparingInt(p -> p.burstTime));

        while (completed < n) {
            // Find process with the shortest burst time that has arrived
            Process shortest = null;
            for (Process process : processes) {
                if (process.arrivalTime <= currentTime && process.completionTime == 0) {
                    if (shortest == null || process.burstTime < shortest.burstTime) {
                        shortest = process;
                    }
                }
            }

            // If no process is ready, increment the current time
            if (shortest == null) {
                currentTime++;
                continue;
            }

            // Schedule the shortest job
            currentTime += shortest.burstTime;
            shortest.completionTime = currentTime;
            shortest.turnaroundTime = shortest.completionTime - shortest.arrivalTime;
            shortest.waitingTime = shortest.turnaroundTime - shortest.burstTime;
            completed++;
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

        double totalTurnaroundTime = processes.stream().mapToDouble(p -> p.turnaroundTime).sum();
        double totalWaitingTime = processes.stream().mapToDouble(p -> p.waitingTime).sum();
        double avgTurnaroundTime = totalTurnaroundTime / processes.size();
        double avgWaitingTime = totalWaitingTime / processes.size();

        int maxCompletionTime = processes.stream().mapToInt(p -> p.completionTime).max().orElse(0);
        int totalBurstTime = processes.stream().mapToInt(p -> p.burstTime).sum();
        double cpuUtilization = (double) totalBurstTime / maxCompletionTime * 100;

        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}
