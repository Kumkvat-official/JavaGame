package testInventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final HashMap<String, Item> items;
    public Inventory(){
        this.items = new HashMap<String, Item>();
    }
    public boolean contains(String name){
        return this.items.containsKey(name);
    }
    public Item get(String name){
        return this.items.get(name);
    }
    public boolean isEmpty(){return this.items.isEmpty();}
    public void show(){
        if(!this.items.isEmpty())
        {
            Item item;
            for(Map.Entry<String, Item> entry : this.items.entrySet()){
                item = entry.getValue();
                System.out.print(item.getName()+": ");
                System.out.println(item.getDescription());
            }
        }
        else
            System.out.println("Здесь нет ничего, что бы ты мог взять с собой или использовать.");
    }
    public void add(String name, Item item){
        this.items.put(name, item);
    }
    public void remove(String name){
        this.items.remove(name);
    }

}
