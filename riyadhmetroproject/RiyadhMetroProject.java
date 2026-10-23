package riyadhmetroproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.ArrayList;

import riyadhmetroproject.MetroLines.Station;
import riyadhmetroproject.MetroLines.Node;
import riyadhmetroproject.MetroLines.CircularDoublyList;
import riyadhmetroproject.MetroLines.MetroNetwork;
import riyadhmetroproject.MetroLines.StationDirectory;

public class RiyadhMetroProject {

    static Scanner input = new Scanner(System.in);
    public static ArrayList<Station> Slist = new ArrayList<>();

    public static void read_data() {

        Slist.add(new Station("Makkah Road", 3, 2,
                "Parking, Restrooms", "Wheelchair access, Elevators",
                40000, "05:00 - 23:30", 1));
        Slist.add(new Station("Prince Turki", 4, 2,
                "Parking, Restrooms", "Elevators, Braille signs",
                35000, "05:00 - 23:30", 1));
        Slist.add(new Station("Education City", 5, 3,
                "Parking, Elevators, Prayer Room", "Wheelchair access",
                60000, "05:00 - 23:30", 1));
        Slist.add(new Station("Hittin", 4, 2,
                "Restrooms, Elevators", "Wheelchair access",
                28000, "05:00 - 23:30", 1));
        Slist.add(new Station("Khurais", 6, 3,
                "Parking, Restrooms, Elevators", "Elevators, Braille signs",
                50000, "05:00 - 23:30", 1));
        Slist.add(new Station("King Abdullah Road", 7, 2,
                "Parking, Restrooms", "Wheelchair access, Elevators",
                45000, "05:00 - 23:30", 2));
        Slist.add(new Station("Al Wurud", 8, 2,
                "Restrooms, Elevators", "Wheelchair access",
                30000, "05:00 - 23:30", 2));
        Slist.add(new Station("Olaya", 9, 3,
                "Parking, Restrooms, Elevators", "Elevators, Braille signs",
                65000, "05:00 - 23:30", 2));
        Slist.add(new Station("Malaz", 10, 2,
                "Restrooms", "Wheelchair access",
                32000, "05:00 - 23:30", 2));
        Slist.add(new Station("Al Faisaliah", 11, 3,
                "Parking, Restrooms, Prayer Room", "Wheelchair access, Elevators",
                55000, "05:00 - 23:30", 2));
        Slist.add(new Station("King Fahd Road", 12, 2,
                "Parking, Restrooms", "Wheelchair access, Elevators",
                48000, "05:00 - 23:30", 3));
        Slist.add(new Station("Al Murabba", 13, 2,
                "Restrooms, Elevators", "Wheelchair access",
                31000, "05:00 - 23:30", 3));
        Slist.add(new Station("Al Batha", 14, 3,
                "Parking, Restrooms, Elevators", "Elevators, Braille signs",
                67000, "05:00 - 23:30", 3));
        Slist.add(new Station("Manfuhah", 15, 2,
                "Restrooms", "Wheelchair access",
                29000, "05:00 - 23:30", 3));
        Slist.add(new Station("Al Shifa", 16, 3,
                "Parking, Restrooms, Prayer Room", "Wheelchair access, Elevators",
                52000, "05:00 - 23:30", 3));
    }

    private static void printMainScreen() {
        System.out.println("\n=====================================");
        System.out.println("      Riyadh Metro Management System");
        System.out.println("=====================================");
        System.out.println("1. Ticketing & Passenger Processing");
        System.out.println("2. Maintenance Management System");
        System.out.println("3. Metro Lines & Station Network");
        System.out.println("4. Station Directory System");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void ticketingMenu(TicketingSystem ticketing) {

        while (true) {
            System.out.println("\n--- Ticketing & Passenger Processing ---");
            System.out.println("1. Add new passenger to a machine");
            System.out.println("2. Serve next passenger at a machine");
            System.out.println("3. Who is next (peek)");
            System.out.println("4. Display all waiting passengers");
            System.out.println("5. Display waiting counts per machine");
            System.out.println("6. Average waiting time");
            System.out.println("7. Estimate waiting time for a passenger");
            System.out.println("8. Move a passenger between machines");

            System.out.println("9. Back");
            System.out.print("Choose: ");

            int c = input.nextInt();
            input.nextLine();

            int machine;

            switch (c) {
                case 1:
                    System.out.print("Enter Machine Number (1-3): ");
                    machine = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Ticket ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Destination: ");
                    String dest = input.nextLine();

                    System.out.print("Is this passenger VIP? (yes/no): ");

                    String vipInput = input.nextLine();

                    if (vipInput.equalsIgnoreCase("yes")) {
                        ticketing.addVIPPassenger(id, name, dest, machine);
                    } else {
                        ticketing.addPassenger(id, name, dest, machine);
                    }
                    break;

                case 2:
                    System.out.print("Enter Machine Number (1-3): ");
                    machine = input.nextInt();
                    input.nextLine();
                    ticketing.serveNextPassenger(machine);
                    break;

                case 3:
                    System.out.print("Enter Machine Number (1-3): ");
                    machine = input.nextInt();
                    input.nextLine();
                    ticketing.peekNextPassenger(machine);
                    break;

                case 4:
                    ticketing.displayAllWaitingPassengers();
                    break;

                case 5:
                    ticketing.displayWaitingCounts();
                    break;

                case 6:
                    System.out.println("Average Waiting Time = " + ticketing.averageWaitingTime() + " minutes");
                    break;
                case 7:
                    System.out.print("Enter passenger ID: ");
                    int estId = input.nextInt();
                    System.out.print("Enter machine number (1-3): ");
                    int estMachine = input.nextInt();
                    ticketing.estimateWaitingTime(estId, estMachine);
                    break;

                case 8:
                    System.out.print("Enter passenger ID: ");
                    int moveId = input.nextInt();
                    System.out.print("From machine number (1-3): ");
                    int from = input.nextInt();
                    System.out.print("To machine number (1-3): ");
                    int to = input.nextInt();
                    ticketing.movePassenger(moveId, from, to);
                    break;
                case 9:
                    return;
            }
        }
    }

    private static void maintenanceMenu(MaintenanceSystem maintenance) {

        while (true) {
            System.out.println("\n--- Maintenance Management ---");
            System.out.println("1. Submit new maintenance request");
            System.out.println("2. Assign next task");
            System.out.println("3. View highest priority task");
            System.out.println("4. Display all pending tasks");
            System.out.println("5. Update priority");
            System.out.println("6. Back");
            System.out.print("Choose: ");

            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = input.nextLine();

                    System.out.print("Enter Priority (1-4): ");
                    int p = input.nextInt();
                    input.nextLine();

                    maintenance.submitTask(id, desc, p);
                    break;

                case 2:
                    maintenance.assignNextTask();
                    break;

                case 3:
                    maintenance.viewMostCritical();
                    break;

                case 4:
                    maintenance.displayAllPendingTasks();
                    break;

                case 5:
                    System.out.print("Enter Task ID to update: ");
                    int uid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new priority: ");
                    int np = input.nextInt();
                    input.nextLine();

                    maintenance.updatePriority(uid, np);
                    break;

                case 6:
                    return;
            }
        }
    }

    private static void metroMenu(MetroNetwork metro) {

        while (true) {
            System.out.println("\n--- Metro Lines & Station Network ---");
            System.out.println("1- Line 1 (Orange)");
            System.out.println("2- Line 2 (Yellow)");
            System.out.println("3- Line 3 (Green)");
            System.out.println("4- Exit");
            System.out.print("Choose a line: ");

            int choice = input.nextInt();

            if (choice == 4) {
                break;
            }

            CircularDoublyList line = metro.getLine(choice);
            String lineName = "";

            switch (choice) {
                case 1:
                    lineName = "Line 1 (Orange)";
                    break;
                case 2:
                    lineName = "Line 2 (Yellow)";
                    break;
                case 3:
                    lineName = "Line 3 (Green)";
                    break;
            }

            while (true) {
                System.out.println("\n--- " + lineName + " Operations ---");
                System.out.println("1- Add First Station");
                System.out.println("2- Add Last Station");
                System.out.println("3- Insert Between Stations");
                System.out.println("4- Remove Station");
                System.out.println("5- Find Station");
                System.out.println("6- Display Forward");
                System.out.println("7- Display Backward");
                System.out.println("8- Count Stations");
                System.out.println("9- Shortest Route");
                System.out.println("10- Duration & Station Count");
                System.out.println("11- Back to Lines");
                System.out.print("Choose an operation: ");

                int op = input.nextInt();
                input.nextLine();
                if (op == 11) {
                    break;
                }

                String a, b, name, fac, acc, opt;
                int t, travelTime, platforms, avg;
                Station s = null;
                switch (op) {

                    case 1:
                        System.out.print("Station name: ");
                        name = input.nextLine();
                        System.out.print("Travel time: ");
                        travelTime = input.nextInt();
                        input.nextLine();
                        System.out.print("Number of Platforms: ");
                        platforms = input.nextInt();
                        input.nextLine();
                        System.out.print("Facilities: ");
                        fac = input.nextLine();
                        System.out.print("Accessibility: ");
                        acc = input.nextLine();
                        System.out.print("Average daily passengers: ");
                        avg = input.nextInt();
                        input.nextLine();
                        System.out.print("Operating hours: ");
                        opt = input.nextLine();

                        s = new Station(name, travelTime, platforms, fac, acc, avg, opt, choice);
                        line.addFirst(s);

                        break;

                    case 2:
                        System.out.print("Station name: ");
                        name = input.nextLine();
                        System.out.print("Travel time: ");
                        travelTime = input.nextInt();
                        input.nextLine();
                        System.out.print("Number of Platforms: ");
                        platforms = input.nextInt();
                        input.nextLine();
                        System.out.print("Facilities: ");
                        fac = input.nextLine();
                        System.out.print("Accessibility: ");
                        acc = input.nextLine();
                        System.out.print("Average daily passengers: ");
                        avg = input.nextInt();
                        input.nextLine();
                        System.out.print("Operating hours: ");
                        opt = input.nextLine();

                        s = new Station(name, travelTime, platforms, fac, acc, avg, opt, choice);
                        line.addLast(s);

                        break;
                    case 3:
                        System.out.println("enter station before");
                        String before = input.nextLine();
                        System.out.println("enter station after");
                        String after = input.nextLine();
                        System.out.println("enter new station data");

                        System.out.print("Station name: ");
                        name = input.nextLine();
                        System.out.print("Travel time: ");
                        travelTime = input.nextInt();
                        input.nextLine();
                        System.out.print("Number of Platforms: ");
                        platforms = input.nextInt();
                        input.nextLine();
                        System.out.print("Facilities: ");
                        fac = input.nextLine();
                        System.out.print("Accessibility: ");
                        acc = input.nextLine();
                        System.out.print("Average daily passengers: ");
                        avg = input.nextInt();
                        input.nextLine();
                        System.out.print("Operating hours: ");
                        opt = input.nextLine();
                        s = new Station(name, travelTime, platforms, fac, acc, avg, opt, choice);

                        line.insertBetween(before, after, s);
                        break;
                    case 4:
                        System.out.println("Enter station name to remove");
                        a = input.nextLine();
                        line.remove(a);
                        break;
                    case 5:
                        System.out.println("enter station name to search");
                        a = input.nextLine();
                        Node n = line.find(a);
                        if (n == null) {
                            System.out.println("Not Found");
                        } else {
                            System.out.println("Found");
                        }
                        break;
                    case 6:
                        line.displayForward();
                        break;
                    case 7:
                        line.displayBackward();
                        break;
                    case 8:
                        System.out.println(line.count());
                        break;
                    case 9:
                        a = input.nextLine();
                        b = input.nextLine();
                        line.printShortestRoute(a, b);
                        break;
                    case 10:
                        a = input.nextLine();
                        b = input.nextLine();
                        line.durationAndCount(a, b);
                        break;
                }
            }
        }
    }

    private static void directoryMenu(StationDirectory dir) {
        String name, fac, acc, opt;
        int travelTime, platforms, avg, lineNmber;
        Station s = null;
        while (true) {

            System.out.println("\n--- Station Directory ---");

            System.out.println("1- Add Station");
            System.out.println("2- Search Station by ID");
            System.out.println("3- Find Stations in Range");
            System.out.println("4- Update Station");
            System.out.println("5- Remove Station");
            System.out.println("6- Display All Stations");
            System.out.println("7- Find Station with MIN ID");
            System.out.println("8- Find Station with MAX ID");
            System.out.println("9- Check if Station Exists");
            System.out.println("10- Back to Main Menu");
            System.out.println(" enter your choice");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 10) {
                return;
            }
            switch (choice) {

                case 1:
                    System.out.print("Station name: ");
                    name = input.nextLine();

                    System.out.print("Travel time: ");
                    travelTime = input.nextInt();
                    input.nextLine();

                    System.out.print("Number of Platforms: ");
                    platforms = input.nextInt();
                    input.nextLine();

                    System.out.print("Facilities: ");
                    fac = input.nextLine();

                    System.out.print("Accessibility: ");
                    acc = input.nextLine();

                    System.out.print("Average daily passengers: ");
                    avg = input.nextInt();
                    input.nextLine();

                    System.out.print("Operating hours: ");
                    opt = input.nextLine();

                    System.out.print("Enter line number: ");
                    lineNmber = input.nextInt();
                    input.nextLine();

                    s = new Station(name, travelTime, platforms, fac, acc, avg, opt, lineNmber);
                    dir.addNewStation(s);

                    break;

                case 2:
                    System.out.print("Enter station ID to search: ");
                    dir.searchById(input.nextInt());
                    input.nextLine();
                    break;

                case 3:
                    System.out.print("Enter low ID: ");
                    int low = input.nextInt();
                    System.out.print("Enter high ID: ");
                    int high = input.nextInt();
                    input.nextLine();
                    dir.findRange(low, high);
                    break;

                case 4:
                    System.out.print("Enter station ID to update: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = input.nextLine();

                    System.out.print("Enter new travel time: ");
                    int newTravelTime = input.nextInt();
                    input.nextLine();

                    Station updated = dir.updateStation(id, newName, newTravelTime);
                    if (updated != null) {
                        System.out.println("Station updated successfully.");
                    } else {
                        System.out.println("Station not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter station ID to delete: ");
                    dir.removeStation(input.nextInt());
                    input.nextLine();

                    break;

                case 6:
                    dir.printAll();
                    break;

                case 7:
                    Station min = dir.minIdStation();
                    if (min != null) {
                        System.out.println("Station with MIN ID:");
                        min.print();
                    } else {
                        System.out.println("Directory is empty.");
                    }
                    break;

                case 8:
                    Station max = dir.maxIdStation();
                    if (max != null) {
                        System.out.println("Station with MAX ID:");
                        max.print();
                    } else {
                        System.out.println("Directory is empty.");
                    }
                    break;

                case 9:
                    System.out.print("Enter station ID to check: ");
                    int checkId = input.nextInt();
                    input.nextLine();

                    if (dir.exists(checkId)) {
                        System.out.println("Station EXISTS.");
                    } else {
                        System.out.println("Station does NOT exist.");
                    }
                    break;

                case 10:
                    return;
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        read_data();

        TicketingSystem ticketing = new TicketingSystem();
        MaintenanceSystem maintenance = new MaintenanceSystem();
        MetroNetwork metro = new MetroNetwork(Slist);
        StationDirectory directory = new StationDirectory(Slist);

        while (true) {
            printMainScreen();

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    ticketingMenu(ticketing);
                    break;
                case 2:
                    maintenanceMenu(maintenance);
                    break;
                case 3:
                    metroMenu(metro);
                    break;
                case 4:
                    directoryMenu(directory);
                    break;
                case 5:
                    return;
            }
        }
    }
}
