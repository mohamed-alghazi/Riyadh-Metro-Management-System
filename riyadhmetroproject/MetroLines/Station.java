package riyadhmetroproject.MetroLines;

public class Station {

    private static int IdCounter = 1001;
    private int stationId;
    private int lineNumber;
    private String name;
    private int travelTime;
    private int numberOfPlatforms;
    private String facilities;
    private String accessibilityFeatures;
    private int avgDailyPassengers;
    private String operatingHours;

    

    public Station(String name, int travelTime,
                   int numberOfPlatforms, String facilities,
                   String accessibilityFeatures,
                   int avgDailyPassengers, String operatingHours,
                   int lineNumber) {
        this.stationId = IdCounter++;
        this.name = name;
        this.travelTime = travelTime;
        this.numberOfPlatforms = numberOfPlatforms;
        this.facilities = facilities;
        this.accessibilityFeatures = accessibilityFeatures;
        this.avgDailyPassengers = avgDailyPassengers;
        this.operatingHours = operatingHours;
        this.lineNumber = lineNumber;
    }

    public String getName() { return name; }
    public int getTravelTime() { return travelTime; }
    public int getStationId() { return stationId; }
    public int getLineNumber() { return lineNumber; }

    public String getLineName() {
        switch(lineNumber) {
            case 1: return "Line 1 (Orange)";
            case 2: return "Line 2 (Yellow)";
            case 3: return "Line 3 (Green)";
            default: return "Unknown Line";
        }
    }

    public void setName(String name) { this.name = name; }
    public void setTravelTime(int travelTime) { this.travelTime = travelTime; }
    public void setNumberOfPlatforms(int numberOfPlatforms) { this.numberOfPlatforms = numberOfPlatforms; }
    public void setFacilities(String facilities) { this.facilities = facilities; }
    public void setAccessibilityFeatures(String accessibilityFeatures) { this.accessibilityFeatures = accessibilityFeatures; }
    public void setAvgDailyPassengers(int avgDailyPassengers) { this.avgDailyPassengers = avgDailyPassengers; }
    public void setOperatingHours(String operatingHours) { this.operatingHours = operatingHours; }
    public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

    @Override
    public String toString() {
        return "ID: " + stationId +
               ", Name: " + name +
               ", Line: " + getLineName() +
               ", Travel Time: " + travelTime + " min";
    }

    public void print() {
        System.out.println("---- Station Information ----");
        System.out.println("Station ID: " + stationId);
        System.out.println("Name: " + name);
        System.out.println("Travel Time: " + travelTime + " min");
        System.out.println("Line Number: " + lineNumber + " (" + getLineName() + ")");
        System.out.println("Number of Platforms: " + numberOfPlatforms);
        System.out.println("Facilities: " + facilities);
        System.out.println("Accessibility: " + accessibilityFeatures);
        System.out.println("Average Daily Passengers: " + avgDailyPassengers);
        System.out.println("Operating Hours: " + operatingHours);
        System.out.println("-----------------------------");
    }
}
