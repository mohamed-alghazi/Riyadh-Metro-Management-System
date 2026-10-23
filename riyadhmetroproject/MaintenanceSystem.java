package riyadhmetroproject;

public class MaintenanceSystem {

    private AHeap<Integer, MaintenanceTask> heap; 

   
    public MaintenanceSystem() {
        heap = new AHeap<>(100); 
    }

    
    public void submitTask(int id, String desc, int priority) {
        MaintenanceTask task = new MaintenanceTask(id, desc, priority); 
        heap.insert(priority, task); 
        System.out.println("Task submitted: " + task);
    }

   
    public void assignNextTask() {
        AHNode<Integer, MaintenanceTask> node = heap.removemax(); 
        if (node == null) System.out.println("No tasks to assign.");
        else System.out.println("Assigned task: " + node.getValue());
    }

   
    public void viewMostCritical() {
        AHNode<Integer, MaintenanceTask> node = heap.getMax(); 
        if (node == null) System.out.println("No pending tasks.");
        else System.out.println("Most critical task: " + node.getValue());
    }

   
    public void displayAllPendingTasks() {
        AHNode<Integer, MaintenanceTask>[] arr = heap.getSortedArray(); 
        if (arr.length == 0) System.out.println("No pending tasks.");
        else {
            System.out.println("All pending tasks:");
           for(int i=0;i<arr.length;i++)
                System.out.println(arr[i].getValue());
        }
    }

   
    public void updatePriority(int id, int newPriority) {
        AHNode<Integer, MaintenanceTask>[] arr = heap.getSortedArray(); 
        MaintenanceTask taskToUpdate = null;

       
        for (AHNode<Integer, MaintenanceTask> node : arr) {
            if (node.getValue().getId() == id) {
                taskToUpdate = node.getValue();
                break;
            }
        }
//for(int i=0;i<arr.length;i++){
//     if (arr[i].getValue().getId() == id) {
//                taskToUpdate = arr[i].getValue();
//                break;
//            }
//}
        if (taskToUpdate == null) {
            System.out.println("Task not found.");
            return;
        }

      
        if (heap.updateKey(taskToUpdate.getId(), newPriority))
            System.out.println("Priority updated for task ID " + id + " to " + newPriority);
        else
            System.out.println("Failed to update priority.");
    }
}
