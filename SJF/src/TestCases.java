import java.util.ArrayList;
import java.util.List;

public class TestCases {
    public static void main(String[] args) {
        testShortestJobFirst();
    }

    public static void testShortestJobFirst() {
        System.out.println("***** Shortest Job First (SJF) Scheduling *****\n");

        // Test Case 1: Standard Input
        System.out.println("Test Case 1: Standard Input");
        List<Process> processes1 = new ArrayList<>();
        processes1.add(new Process(1, 0, 7));
        processes1.add(new Process(2, 2, 4));
        processes1.add(new Process(3, 4, 1));
        processes1.add(new Process(4, 5, 4));

        ShortestJobFirst sjf1 = new ShortestJobFirst();
        sjf1.scheduleProcesses(processes1);
        sjf1.displayResults(processes1);
        System.out.println("---------------------------");

        // Test Case 2: All Processes Arrive at the Same Time
        System.out.println("Test Case 2: All Processes Arrive at the Same Time");
        List<Process> processes2 = new ArrayList<>();
        processes2.add(new Process(1, 0, 6));
        processes2.add(new Process(2, 0, 2));
        processes2.add(new Process(3, 0, 8));
        processes2.add(new Process(4, 0, 3));

        ShortestJobFirst sjf2 = new ShortestJobFirst();
        sjf2.scheduleProcesses(processes2);
        sjf2.displayResults(processes2);
        System.out.println("---------------------------");

        // Test Case 3: CPU Idle Time
        System.out.println("Test Case 3: CPU Idle Time");
        List<Process> processes3 = new ArrayList<>();
        processes3.add(new Process(1, 0, 3));
        processes3.add(new Process(2, 5, 4));
        processes3.add(new Process(3, 10, 2));
        processes3.add(new Process(4, 12, 6));

        ShortestJobFirst sjf3 = new ShortestJobFirst();
        sjf3.scheduleProcesses(processes3);
        sjf3.displayResults(processes3);
        System.out.println("---------------------------");

        // Test Case 4: Single Process
        System.out.println("Test Case 4: Single Process");
        List<Process> processes4 = new ArrayList<>();
        processes4.add(new Process(1, 0, 5));

        ShortestJobFirst sjf4 = new ShortestJobFirst();
        sjf4.scheduleProcesses(processes4);
        sjf4.displayResults(processes4);
        System.out.println("---------------------------");

        // Test Case 5: Increasing Burst Times
        System.out.println("Test Case 5: Increasing Burst Times");
        List<Process> processes5 = new ArrayList<>();
        processes5.add(new Process(1, 0, 1));
        processes5.add(new Process(2, 1, 2));
        processes5.add(new Process(3, 2, 3));
        processes5.add(new Process(4, 3, 4));
        processes5.add(new Process(5, 4, 5));

        ShortestJobFirst sjf5 = new ShortestJobFirst();
        sjf5.scheduleProcesses(processes5);
        sjf5.displayResults(processes5);
        System.out.println("---------------------------");
    }
}
