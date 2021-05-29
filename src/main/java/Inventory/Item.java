package Inventory;

public class Item {
    private String description;
    private final String name, key, using;
    private boolean movable;
    private final boolean usable;
    public Item(String name, String key, String description, String using, boolean usable, boolean movable){
        this.name = name;
        this.description = description;
        this.key = key;
        this.using = using;
        this.usable = usable;
        this.movable = movable;
    }
    public String getName(){return this.name;}
    public String getKey(){return this.key;}
    public String getDescription(){return this.description;}
    public boolean isUsable(){return this.usable;}
    public boolean isMovable(){return this.movable;}
    public String getUsing(){return this.using;}
    public void setMovable(boolean bool){this.movable = bool;}
    public void setDescription(String description){this.description = description;}
}
