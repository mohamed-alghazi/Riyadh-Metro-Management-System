package riyadhmetroproject;

public class MaintenanceTask implements Comparable<MaintenanceTask>   {

    private static int orderCounter = 1;
    private int id;
    private String description;
    private int priority;
    private int order;

    public MaintenanceTask(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.order = orderCounter++;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public int getOrder() { return order; }

    public void setPriority(int newPriority) { this.priority = newPriority; }

    public String priorityToString() {
        switch(priority) {
            case 4: return "CRITICAL";
            case 3: return "HIGH";
            case 2: return "MEDIUM";
            default: return "LOW";
        }
    }

    @Override
    public String toString() {
        return "{ID: " + id + ", Priority: " + priorityToString() +
               ", Order: " + order + ", Description: " + description + "}]";
    }

   @Override
public int compareTo(MaintenanceTask other) {
    
    if (this.priority > other.priority) {
        return 1;
    }
    
    if (this.priority < other.priority) {
        return -1;
    }
   
    if (this.order < other.order) {
        return 1;
    }
    if (this.order > other.order) {
        return -1;
    }
   
    return 0;
}

}
