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

class FirstComeFirstServe {
    public void scheduleProcesses(List<Process> processes) {
        int currentTime = 0;

        // Sort processes by arrival time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        for (Process process : processes) {
            // Ensure no process starts before its arrival time
            if (currentTime < process.arrivalTime) {
                currentTime = process.arrivalTime; // CPU is idle until the process arrives
            }
            process.completionTime = currentTime + process.burstTime;
            process.turnaroundTime = process.completionTime - process.arrivalTime;
            process.waitingTime = process.turnaroundTime - process.burstTime;
            currentTime = process.completionTime; // Update current time
        }
    }

    public void displayResults(List<Process> processes) {
        System.out.println("ProcessID\tArrivalTime\tBurstTime\tCompletionTime\tTurnaroundTime\tWaitingTime");
        int totalBurstTime = 0; // To calculate total CPU active time
        for (Process process : processes) {
            System.out.println(process.processID + "\t\t\t\t" +
                    process.arrivalTime + "\t\t\t" +
                    process.burstTime + "\t\t\t" +
                    process.completionTime + "\t\t\t\t" +
                    process.turnaroundTime + "\t\t\t\t" +
                    process.waitingTime);
            totalBurstTime += process.burstTime; // Sum up all burst times
        }

        double avgTurnaroundTime = processes.stream().mapToDouble(p -> p.turnaroundTime).average().orElse(0);
        double avgWaitingTime = processes.stream().mapToDouble(p -> p.waitingTime).average().orElse(0);
        //double avgBurstTime = processes.stream().mapToDouble(p -> p.burstTime).sum();
        // Calculate total completion time (last process's completion time)
        int totalCompletionTime = processes.get(processes.size() - 1).completionTime;

        // Calculate CPU Utilization
        double cpuUtilization = ((double) totalBurstTime / totalCompletionTime) * 100;

        // Print results
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}
