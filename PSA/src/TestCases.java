import java.util.ArrayList;
import java.util.List;


public class TestCases {
    public static void main(String[] args) {
        testPriorityScheduling();
    }

    public static void testPriorityScheduling() {
        System.out.println("***** Priority Scheduling *****\n");

        // Test Case 1: Standard Input with Different Priorities
        System.out.println("Test Case 1: Standard Input with Different Priorities");
        List<Process> processes1 = new ArrayList<>();
        processes1.add(new Process(1, 0, 5, 2));
        processes1.add(new Process(2, 1, 3, 1));
        processes1.add(new Process(3, 2, 4, 3));
        processes1.add(new Process(4, 3, 2, 4));

        PriorityScheduling ps1 = new PriorityScheduling();
        ps1.scheduleProcesses(processes1);
        System.out.println("---------------------------");

        // Test Case 2: All Processes Arrive at the Same Time
        System.out.println("Test Case 2: All Processes Arrive at the Same Time");
        List<Process> processes2 = new ArrayList<>();
        processes2.add(new Process(1, 0, 6, 1));
        processes2.add(new Process(2, 0, 3, 2));
        processes2.add(new Process(3, 0, 4, 3));

        PriorityScheduling ps2 = new PriorityScheduling();
        ps2.scheduleProcesses(processes2);
        System.out.println("---------------------------");

        // Test Case 3: Idle CPU Time Between Processes
        System.out.println("Test Case 3: Idle CPU Time Between Processes");
        List<Process> processes3 = new ArrayList<>();
        processes3.add(new Process(1, 0, 4, 3));
        processes3.add(new Process(2, 5, 5, 2));
        processes3.add(new Process(3, 10, 2, 1));

        PriorityScheduling ps3 = new PriorityScheduling();
        ps3.scheduleProcesses(processes3);
        System.out.println("---------------------------");

        // Test Case 4: Single Process
        System.out.println("Test Case 4: Single Process");
        List<Process> processes4 = new ArrayList<>();
        processes4.add(new Process(1, 0, 8, 1));

        PriorityScheduling ps4 = new PriorityScheduling();
        ps4.scheduleProcesses(processes4);
        System.out.println("---------------------------");

        // Test Case 5: Processes with Same Arrival Time and Same Priority
        System.out.println("Test Case 5: Same Arrival Time and Same Priority");
        List<Process> processes5 = new ArrayList<>();
        processes5.add(new Process(1, 0, 5, 1));
        processes5.add(new Process(2, 0, 3, 1));
        processes5.add(new Process(3, 0, 4, 1));

        PriorityScheduling ps5 = new PriorityScheduling();
        ps5.scheduleProcesses(processes5);
        System.out.println("---------------------------");

        // Test Case 6: Processes with Same Priority but Different Arrival Times
        System.out.println("Test Case 6: Same Priority, Different Arrival Times");
        List<Process> processes6 = new ArrayList<>();
        processes6.add(new Process(1, 0, 3, 2));
        processes6.add(new Process(2, 2, 4, 2));
        processes6.add(new Process(3, 4, 2, 2));

        PriorityScheduling ps6 = new PriorityScheduling();
        ps6.scheduleProcesses(processes6);
        System.out.println("---------------------------");
    }
}

