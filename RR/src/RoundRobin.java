import java.util.*;

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

class RoundRobin {
    private final int timeQuantum;

    public RoundRobin(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void scheduleProcesses(List<Process> processes) {
        int currentTime = 0;
        Queue<Process> queue = new LinkedList<>();
        List<Process> arrivedProcesses = new ArrayList<>(processes);

        arrivedProcesses.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int totalBurstTime = 0;

        for (Process process : processes) {
            totalBurstTime += process.burstTime;
        }

        while (!arrivedProcesses.isEmpty() || !queue.isEmpty()) {
            // Add processes to queue that have arrived by the current time
            while (!arrivedProcesses.isEmpty() && arrivedProcesses.get(0).arrivalTime <= currentTime) {
                queue.add(arrivedProcesses.remove(0));
            }

            if (!queue.isEmpty()) {
                Process currentProcess = queue.poll();
                int timeSlice = Math.min(timeQuantum, currentProcess.remainingTime);

                currentTime += timeSlice;
                currentProcess.remainingTime -= timeSlice;

                // Check for newly arrived processes
                while (!arrivedProcesses.isEmpty() && arrivedProcesses.get(0).arrivalTime <= currentTime) {
                    queue.add(arrivedProcesses.remove(0));
                }

                // If the process is not finished, add it back to the queue
                if (currentProcess.remainingTime > 0) {
                    queue.add(currentProcess);
                } else {
                    // Process is complete
                    currentProcess.completionTime = currentTime;
                    currentProcess.turnaroundTime = currentProcess.completionTime - currentProcess.arrivalTime;
                    currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;
                }
            } else {
                currentTime++;
            }
        }

        displayResults(processes, totalBurstTime, currentTime);
    }

    public void displayResults(List<Process> processes, int totalBurstTime, int totalElapsedTime) {
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

        double cpuUtilization = ((double) totalBurstTime / totalElapsedTime) * 100;

        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnaroundTime);
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization);
    }
}
