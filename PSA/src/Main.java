import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        System.out.println("***** Priority Scheduling *****\n");

        // Test processes
        processes.add(new Process(1, 0, 10, 3));
        processes.add(new Process(2, 0, 1, 1));
        processes.add(new Process(3, 0, 2, 3));
        processes.add(new Process(4, 0, 1, 4));
        processes.add(new Process(5, 0, 5, 2));

        // Create an instance of PriorityScheduling class
        PriorityScheduling ps = new PriorityScheduling();

        // Schedule the processes
        ps.scheduleProcesses(processes);
    }
}

