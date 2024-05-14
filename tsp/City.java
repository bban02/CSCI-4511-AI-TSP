/*
* City.java
* Models a city
*/

package tsp;
import java.lang.Math;

public class City {
    double x;
    double y;
    String cityName;
    
    // Constructs a randomly placed city
    public City(){
        this.x = (Math.random()*200);
        this.y = (Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(String name, double x, double y){
        cityName = name;
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public double getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public double getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        // from Calculate distance between two latitude-longitude points? (Haversine formula)   
        double radius = 3958.8;
        double toRad = Math.PI / 180;
        
        double lat1 = city.getX() * toRad;
        double lat2 = getX() * toRad;
        double lon1 = city.getY() * toRad;
        double lon2 = getY() * toRad;
        
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.cos(lat1) * Math.cos(lat2) * 
            Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = radius * c;
        return distance;        
    }
    
    @Override
    public String toString(){
        return getX()+", "+getY();
    }
}