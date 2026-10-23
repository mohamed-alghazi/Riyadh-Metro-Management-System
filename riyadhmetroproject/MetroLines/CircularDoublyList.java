package riyadhmetroproject.MetroLines;

public class CircularDoublyList {

    private Node head;
    private int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Station station) {
        Node n = new Node(station);
        if (isEmpty()) {
            head = n;
            n.next = n;
            n.prev = n;
        } else {
            Node tail = head.prev;
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(Station station) {
        if (isEmpty()) {
            addFirst(station);
            return;
        }
        Node tail = head.prev;
        Node n = new Node(station);
        n.next = head;
        n.prev = tail;
        tail.next = n;
        head.prev = n;
        size++;
    }

    public boolean insertBetween(String beforeName, String afterName, Station station) {
        if (isEmpty() || this.size < 2) return false;
        Node curr = head;
        for (int i = 0; i < size; i++) {
            String currName = curr.data.getName();
            String nextName = curr.next.data.getName();
            if (currName.equalsIgnoreCase(beforeName) && nextName.equalsIgnoreCase(afterName)) {
                Node n = new Node(station);
                n.next = curr.next;
                n.prev = curr;
                curr.next.prev = n;
                curr.next = n;
                size++;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean remove(String name) {
        if (isEmpty()) return false;
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.getName().equalsIgnoreCase(name)) {
                if (size == 1) {
                    head = null;
                    size = 0;
                    return true;
                }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                if (curr == head) head = curr.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public Node find(String name) {
        if (isEmpty()) return null;
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data.getName().equalsIgnoreCase(name)) return curr;
            curr = curr.next;
        }
        return null;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("No stations.");
            return;
        }
        Node curr = head;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("No stations.");
            return;
        }
        Node curr = head.prev;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.data + " -> ");
            curr = curr.prev;
        }
        System.out.println();
    }

    public int count() {
        return size;
    }

    public void printShortestRoute(String startName, String endName) {
        Node s = find(startName);
        Node e = find(endName);
        if (s == null || e == null) {
            System.out.println("Station not found!");
            return;
        }
        int timeF = 0;
        String pathF = s.data.getName();
        Node currF = s;
        while (currF != e) {
            if (currF.next == e)
                timeF += currF.next.data.getTravelTime();
            else
                timeF += currF.next.data.getTravelTime() + 2;
            currF = currF.next;
            pathF += " -> " + currF.data.getName();
        }
        int timeB = 0;
        String pathB = s.data.getName();
        Node currB = s;
        while (currB != e) {
            if (currB.prev == e)
                timeB += currB.prev.data.getTravelTime();
            else
                timeB += currB.prev.data.getTravelTime() + 2;
            currB = currB.prev;
            pathB += " -> " + currB.data.getName();
        }
        System.out.println("\n===== SHORTEST ROUTE =====");
        if (timeF <= timeB) {
            System.out.println("Path: " + pathF);
            System.out.println("Total Time: " + timeF + " minutes");
        } else {
            System.out.println("Path: " + pathB);
            System.out.println("Total Time: " + timeB + " minutes");
        }
    }

    public void durationAndCount(String startName, String endName) {
        Node s = find(startName);
        Node e = find(endName);
        if (s == null || e == null) {
            System.out.println("Station not found!");
            return;
        }
        int time = 0;
        int count = 0;
        Node curr = s;
        while (curr != e) {
            time += curr.data.getTravelTime() + 2;
            count++;
            curr = curr.next;
        }
        System.out.println("Stations Between = " + count);
        System.out.println("Total Duration = " + time + " minutes");
    }
}
