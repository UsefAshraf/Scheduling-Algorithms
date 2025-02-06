import java.util.*;

public class TestCases {
    public static void main(String[] args) {
        testRoundRobin();
    }

    public static void testRoundRobin() {
        System.out.println("***** Round Robin Scheduling *****\n");

        // Test Case 1: Standard Input
        System.out.println("Test Case 1: Standard Input");
        List<Process> processes1 = new ArrayList<>();
        processes1.add(new Process(1, 0, 5));
        processes1.add(new Process(2, 1, 3));
        processes1.add(new Process(3, 2, 6));
        processes1.add(new Process(4, 3, 1));

        RoundRobin rr1 = new RoundRobin(2);
        rr1.scheduleProcesses(processes1);
        System.out.println("---------------------------");

        // Test Case 2: All Processes Arrive at the Same Time
        System.out.println("Test Case 2: All Processes Arrive at the Same Time");
        List<Process> processes2 = new ArrayList<>();
        processes2.add(new Process(1, 0, 4));
        processes2.add(new Process(2, 0, 5));
        processes2.add(new Process(3, 0, 6));

        RoundRobin rr2 = new RoundRobin(3);
        rr2.scheduleProcesses(processes2);
        System.out.println("---------------------------");

        // Test Case 3: Idle CPU Time
        System.out.println("Test Case 3: Idle CPU Time");
        List<Process> processes3 = new ArrayList<>();
        processes3.add(new Process(1, 0, 3));
        processes3.add(new Process(2, 5, 4));
        processes3.add(new Process(3, 10, 2));

        RoundRobin rr3 = new RoundRobin(2);
        rr3.scheduleProcesses(processes3);
        System.out.println("---------------------------");

        // Test Case 4: Single Process
        System.out.println("Test Case 4: Single Process");
        List<Process> processes4 = new ArrayList<>();
        processes4.add(new Process(1, 0, 8));

        RoundRobin rr4 = new RoundRobin(4);
        rr4.scheduleProcesses(processes4);
        System.out.println("---------------------------");

        // Test Case 5: Varying Arrival and Burst Times
        System.out.println("Test Case 5: Varying Arrival and Burst Times");
        List<Process> processes5 = new ArrayList<>();
        processes5.add(new Process(1, 0, 7));
        processes5.add(new Process(2, 2, 4));
        processes5.add(new Process(3, 4, 1));
        processes5.add(new Process(4, 5, 2));

        RoundRobin rr5 = new RoundRobin(2);
        rr5.scheduleProcesses(processes5);
        System.out.println("---------------------------");
    }
}