import java.util.ArrayList;
import java.util.List;

public class TestCases {
    public static void main(String[] args) {
        testFirstComeFirstServe();
    }

    public static void testFirstComeFirstServe() {
        System.out.println("***** First Come First Serve (FCFS) Scheduling *****\n");

        // Test Case 1: Standard Input
        System.out.println("Test Case 1: Standard Input");
        List<Process> processes1 = new ArrayList<>();
        processes1.add(new Process(1, 0, 5));
        processes1.add(new Process(2, 2, 3));
        processes1.add(new Process(3, 4, 2));
        processes1.add(new Process(4,6,10));

        FirstComeFirstServe fcfs1 = new FirstComeFirstServe();
        fcfs1.scheduleProcesses(processes1);
        fcfs1.displayResults(processes1);
        System.out.println("---------------------------");

        // Test Case 2: All Processes Arrive at the Same Time
        System.out.println("Test Case 2: All Processes Arrive at the Same Time");
        List<Process> processes2 = new ArrayList<>();
        processes2.add(new Process(1, 0, 6));
        processes2.add(new Process(2, 0, 4));
        processes2.add(new Process(3, 0, 5));

        FirstComeFirstServe fcfs2 = new FirstComeFirstServe();
        fcfs2.scheduleProcesses(processes2);
        fcfs2.displayResults(processes2);
        System.out.println("---------------------------");

        // Test Case 3: CPU Idle Time
        System.out.println("Test Case 3: CPU Idle Time");
        List<Process> processes3 = new ArrayList<>();
        processes3.add(new Process(1, 0, 4));
        processes3.add(new Process(2, 5, 3));
        processes3.add(new Process(3, 10, 2));

        FirstComeFirstServe fcfs3 = new FirstComeFirstServe();
        fcfs3.scheduleProcesses(processes3);
        fcfs3.displayResults(processes3);
        System.out.println("---------------------------");

        // Test Case 4: Single Process
        System.out.println("Test Case 4: Single Process");
        List<Process> processes4 = new ArrayList<>();
        processes4.add(new Process(1, 0, 7));

        FirstComeFirstServe fcfs4 = new FirstComeFirstServe();
        fcfs4.scheduleProcesses(processes4);
        fcfs4.displayResults(processes4);
        System.out.println("---------------------------");

        // Test Case 5: Processes with Increasing Arrival Times
        System.out.println("Test Case 5: Processes with Increasing Arrival Times");
        List<Process> processes5 = new ArrayList<>();
        processes5.add(new Process(1, 0, 2));
        processes5.add(new Process(2, 2, 3));
        processes5.add(new Process(3, 5, 4));
        processes5.add(new Process(4, 9, 5));

        FirstComeFirstServe fcfs5 = new FirstComeFirstServe();
        fcfs5.scheduleProcesses(processes5);
        fcfs5.displayResults(processes5);
        System.out.println("---------------------------");

    }
}
