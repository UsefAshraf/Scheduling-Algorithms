import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Test processes
        processes.add(new Process(1, 0, 10));
        processes.add(new Process(2, 0, 1));
        processes.add(new Process(3, 0, 2));
        processes.add(new Process(4, 0, 1));
        processes.add(new Process(5, 0, 5));

        // Create an instance of ShortestJobFirst class
        ShortestJobFirst sjf = new ShortestJobFirst();

        // Schedule the processes
        sjf.scheduleProcesses(processes);

        // Display the results
        sjf.displayResults(processes);
    }
}
