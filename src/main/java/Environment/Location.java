package Environment;

import Inventory.*;

import java.util.HashMap;

public class Location {
    private String description;
    private final String name;
    private Inventory inventory;
    private final HashMap<String, Location> directions;
    public Location(String name, String description, HashMap<String, Location> directions){
        this.name = name;
        this.description = description;
        this.inventory = new Inventory();
        this.directions = directions;
    }
    public void setDescription(String description){this.description = description;}
    public void addDirection(String direction, Location location){this.directions.put(direction,location);}
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public HashMap<String, Location> getDirections(){return this.directions;}
    public void setInventory(Inventory inventory){this.inventory = inventory;}
    public Inventory getInventory(){return this.inventory;}
}
