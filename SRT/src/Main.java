import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Test processes
        processes.add(new Process(1, 0, 8));
        processes.add(new Process(2, 1, 4));
        processes.add(new Process(3, 2, 9));
        processes.add(new Process(4, 3, 5));

        // Create an instance of ShortestRemainingTime class
        ShortestRemainingTime srt = new ShortestRemainingTime();

        // Schedule the processes
        srt.scheduleProcesses(processes);

        // Display the results
        srt.displayResults(processes);
    }
}
