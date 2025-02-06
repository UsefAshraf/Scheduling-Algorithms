import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("***** Round Robin Scheduling *****\n");

        List<Process> processes = new ArrayList<>();

        // Test processes
        processes.add(new Process(1, 0, 10));
        processes.add(new Process(2, 0, 1));
        processes.add(new Process(3, 0, 2));
        processes.add(new Process(4, 0, 1));
        processes.add(new Process(5, 0, 5));

        // Time quantum for Round Robin
        int timeQuantum = 1;

        // Create an instance of RoundRobin class
        RoundRobin rr = new RoundRobin(timeQuantum);

        // Schedule the processes
        rr.scheduleProcesses(processes);
    }
}
