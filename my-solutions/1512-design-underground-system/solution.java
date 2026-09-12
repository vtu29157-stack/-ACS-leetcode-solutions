import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Store active check-in details: customerId -> CheckInInfo
    private Map<Integer, CheckInInfo> checkInMap;
    
    // Store aggregated travel data: "startStation->endStation" -> RouteInfo
    private Map<String, RouteInfo> routeMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove customer check-in record
        CheckInInfo checkIn = checkInMap.remove(id);
        
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;

        // Update travel statistics for this station pair
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += travelTime;
        route.tripCount += 1;
        routeMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
