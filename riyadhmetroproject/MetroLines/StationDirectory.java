package riyadhmetroproject.MetroLines;

import java.util.ArrayList;
import static riyadhmetroproject.RiyadhMetroProject.Slist;

public class StationDirectory {

    private BSTree<Integer, Station> tree = new BSTree<>();
   

    public StationDirectory(ArrayList<Station> Slist) {
       
          
        
        for(int i=0;i<Slist.size();i++) {
            Station s=Slist.get(i);
            tree.insert(s.getStationId(), s);
        }
    }

    public void addNewStation(Station s) {
        tree.insert(s.getStationId(), s);
        
    }

    public void searchById(int id) {
        Station s = tree.search(id);
        if (s != null) {
            System.out.println("Station Found:");
            s.print();
        } else {
            System.out.println("Station NOT found.");
        }
    }

    public void findRange(int low, int high) {
        System.out.println("Stations from " + low + " to " + high + ":");
        tree.rangeSearch(low, high); 
    }

    
public Station updateStation(int id, String newName, int newTravelTime) {
    Station s = tree.search(id); 
    if (s != null) {
        s.setName(newName);
        s.setTravelTime(newTravelTime);
    }
    return tree.search(id);
}

   
public void removeStation(int id) {
        Station toRemove = tree.search(id);
        if (toRemove != null) {
            tree.delete(id);
            
           
        }
    }

    public void printAll() {
        System.out.println("All stations (sorted by ID):");
        tree.print();
    }

    public Station minIdStation() {
        return tree.findMin();
    }

    public Station maxIdStation() {
        return tree.findMax();
    }

    public boolean exists(int id) {
        return tree.search(id) != null;
    }

   
}
