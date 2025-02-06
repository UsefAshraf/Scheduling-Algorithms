import java.util.ArrayList;
import java.util.List;

public class TestCases {
    public static void main(String[] args) {
        testShortestRemainingTime();
    }

    public static void testShortestRemainingTime() {
        System.out.println("***** Shortest Remaining Time (SRT) Scheduling *****\n");

        // Test Case 1: Standard Input
        System.out.println("Test Case 1: Standard Input");
        List<Process> processes1 = new ArrayList<>();
        processes1.add(new Process(1, 0, 7));
        processes1.add(new Process(2, 2, 4));
        processes1.add(new Process(3, 4, 1));
        processes1.add(new Process(4, 5, 4));

        ShortestRemainingTime srt1 = new ShortestRemainingTime();
        srt1.scheduleProcesses(processes1);
        srt1.displayResults(processes1);
        System.out.println("---------------------------");

        // Test Case 2: All Processes Arrive at the Same Time
        System.out.println("Test Case 2: All Processes Arrive at the Same Time");
        List<Process> processes2 = new ArrayList<>();
        processes2.add(new Process(1, 0, 6));
        processes2.add(new Process(2, 0, 2));
        processes2.add(new Process(3, 0, 8));
        processes2.add(new Process(4, 0, 3));

        ShortestRemainingTime srt2 = new ShortestRemainingTime();
        srt2.scheduleProcesses(processes2);
        srt2.displayResults(processes2);
        System.out.println("---------------------------");

        // Test Case 3: CPU Idle Time
        System.out.println("Test Case 3: CPU Idle Time");
        List<Process> processes3 = new ArrayList<>();
        processes3.add(new Process(1, 0, 3));
        processes3.add(new Process(2, 5, 4));
        processes3.add(new Process(3, 10, 2));
        processes3.add(new Process(4, 12, 6));

        ShortestRemainingTime srt3 = new ShortestRemainingTime();
        srt3.scheduleProcesses(processes3);
        srt3.displayResults(processes3);
        System.out.println("---------------------------");

        // Test Case 4: Single Process
        System.out.println("Test Case 4: Single Process");
        List<Process> processes4 = new ArrayList<>();
        processes4.add(new Process(1, 0, 5));

        ShortestRemainingTime srt4 = new ShortestRemainingTime();
        srt4.scheduleProcesses(processes4);
        srt4.displayResults(processes4);
        System.out.println("---------------------------");

        // Test Case 5: Processes with Different Arrival Times and Burst Times
        System.out.println("Test Case 5: Different Arrival and Burst Times");
        List<Process> processes5 = new ArrayList<>();
        processes5.add(new Process(1, 0, 8));
        processes5.add(new Process(2, 1, 4));
        processes5.add(new Process(3, 2, 9));
        processes5.add(new Process(4, 3, 5));

        ShortestRemainingTime srt5 = new ShortestRemainingTime();
        srt5.scheduleProcesses(processes5);
        srt5.displayResults(processes5);
        System.out.println("---------------------------");
    }
}
