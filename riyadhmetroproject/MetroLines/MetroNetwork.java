package riyadhmetroproject.MetroLines;

import java.util.ArrayList;

public class MetroNetwork {

    private CircularDoublyList line1;
    private CircularDoublyList line2;
    private CircularDoublyList line3;
   

    public MetroNetwork(ArrayList<Station> Slist) {
        line1 = new CircularDoublyList();
        line2 = new CircularDoublyList();
        line3 = new CircularDoublyList();
      
        rearData(Slist);
    }

    private void rearData(ArrayList<Station> Slist) {
        for (Station ob : Slist) {
            switch (ob.getLineNumber()) {
                case 1: line1.addLast(ob); break;
                case 2: line2.addLast(ob); break;
                case 3: line3.addLast(ob); break;
                
            }
        }
    }

    public CircularDoublyList getLine(int lineNum) {
        switch (lineNum) {
            case 1: return line1;
            case 2: return line2;
            case 3: return line3;
            default: return null;
        }
    }

    public void addFirst(int lineNum, Station station) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) {
            L.addFirst(station);
          
        }
    }

    public void addLast(int lineNum, Station station) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) {
            L.addLast(station);
           
        }
    }

    
public boolean insertBetween(int lineNum, String beforeName, String afterName, Station station) {
    CircularDoublyList L = getLine(lineNum);
    if (L != null && L.insertBetween(beforeName, afterName, station)) {
        
        return true;
    }
    return false;
}

    public boolean removeStation(int lineNum, String name) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) return L.remove(name);
        return false;
    }


    public Node findStation(int lineNum, String name) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) return L.find(name);
        return null;
    }

    public void displayForward(int lineNum) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) L.displayForward();
    }

    public void displayBackward(int lineNum) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) L.displayBackward();
    }

    public int countStations(int lineNum) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) return L.count();
        return 0;
    }

    public void shortestRoute(int lineNum, String startName, String endName) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) L.printShortestRoute(startName, endName);
    }

    public void durationForward(int lineNum, String startName, String endName) {
        CircularDoublyList L = getLine(lineNum);
        if (L != null) L.durationAndCount(startName, endName);
    }
}
