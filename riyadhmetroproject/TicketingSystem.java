package riyadhmetroproject;

public class TicketingSystem {

    private ArrayQueue<Passenger>[] machines;   

    public TicketingSystem() {
        machines = new ArrayQueue[3]; 
        for (int i = 0; i < 3; i++)
            machines[i] = new ArrayQueue<>();
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    public void addPassenger(int id, String name, String destination, int machineNum) {

        if (machineNum < 1 || machineNum > 3) {
            System.out.println("Invalid machine number!");
            return;
        }

        Passenger p = new Passenger(id, name, destination);
        machines[machineNum - 1].enqueue(p);

        System.out.println("Passenger added to machine " + machineNum + ": " + p);
    }
//===============================================
    
    public void addVIPPassenger(int id, String name, String destination, int machineNum) {
        if (machineNum < 1 || machineNum > 3) {
            System.out.println("Invalid machine number!");
            return;
        }

        Passenger p = new Passenger(id, name, destination);
        ArrayQueue<Passenger> queue = machines[machineNum - 1];

        int n = queue.size();
        queue.enqueue(p); 
        for (int i = 0; i < n; i++)
            queue.enqueue(queue.dequeue()); 

        System.out.println("VIP Passenger added to machine " + machineNum + ": " + p);
    }
    //=============================================
    public void serveNextPassenger(int machineNum) {

        if (machineNum < 1 || machineNum > 3) {
            System.out.println("Invalid machine number!");
            return;
        }

        Passenger p = machines[machineNum - 1].dequeue();

        if (p == null)
            System.out.println("No passengers waiting in machine " + machineNum);
        else
            System.out.println("Serving from machine " + machineNum + " → " + p);
    }

   
    public void peekNextPassenger(int machineNum) {

        if (machineNum < 1 || machineNum > 3) {
            System.out.println("Invalid machine number!");
            return;
        }

        Passenger p = machines[machineNum - 1].first();

        if (p == null)
            System.out.println("Machine " + machineNum + " has no waiting passengers.");
        else
            System.out.println("Next passenger at machine " + machineNum + ": " + p);
    }

    
    public void displayAllWaitingPassengers() {

        System.out.println("\n--- Waiting Passengers in All Machines ---");

        for (int i = 0; i < 3; i++) {
            System.out.println("Machine " + (i + 1) + ":");

            if (machines[i].isEmpty()) {
                System.out.println("  (empty)");
                continue;
            }

            int count = machines[i].size();

            for (int j = 0; j < count; j++) {
                Passenger p = machines[i].dequeue();
                System.out.println("  " + p);
                machines[i].enqueue(p);
            }
        }
    }

  
    public void displayWaitingCounts() {
        System.out.println("\n--- Waiting Counts per Machine ---");

        for (int i = 0; i < 3; i++) {
            System.out.println("Machine " + (i + 1) +
                               ": " + machines[i].size() + " passengers waiting");
        }
    }
 
    public int averageWaitingTime() {
        int total = 0;
        for (int i = 0; i < 3; i++)
            total += machines[i].size();

        return total * 2/3;  
    }
    
  
public void estimateWaitingTime(int id, int machineNum) {
    if (machineNum < 1 || machineNum > 3) {
        System.out.println("Invalid machine number!");
        return;
    }

    ArrayQueue<Passenger> queue = machines[machineNum - 1];
    int n = queue.size();
    int position = -1;

    for (int i = 0; i < n; i++) {
        Passenger p = queue.dequeue();
        if (p.getTicketID() == id && position == -1) {
            position = i;
        }
        queue.enqueue(p);
    }

    if (position == -1)
        System.out.println("Passenger with ID " + id + " not found in machine " + machineNum);
    else
        System.out.println("Estimated waiting time for passenger ID " + id + " in machine " +
                machineNum + " is " + (position * 2) + " minutes.");
}


public void movePassenger(int id, int fromMachine, int toMachine) {
    if (fromMachine < 1 || fromMachine > 3 || toMachine < 1 || toMachine > 3) {
        System.out.println("Invalid machine number!");
        return;
    }

    ArrayQueue<Passenger> source = machines[fromMachine - 1];
    ArrayQueue<Passenger> target = machines[toMachine - 1];
    int n = source.size();
    boolean found = false;

    for (int i = 0; i < n; i++) {
        Passenger p = source.dequeue();
        if (p.getTicketID() == id && !found) {
            target.enqueue(p);
            found = true;
        } else {
            source.enqueue(p);
        }
    }

    if (found)
        System.out.println("Passenger ID " + id + " moved from machine " + fromMachine + " to " + toMachine);
    else
        System.out.println("Passenger ID " + id + " not found in machine " + fromMachine);
}

    
}
