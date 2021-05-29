package testMain;

import testEnvironment.*;
import testInventory.*;

public class Player {
    private final String name;
    private final Inventory inventory;
    private Location location;
    public Player(String name, Location location){
        this.name = name;
        this.location = location;
        this.inventory = new Inventory();
    }
    public String getName(){return this.name;}
    public void lookAround(){
        System.out.println(this.location.getDescription());
    }
    public void go(String way){
        way = way.toLowerCase();
        if (this.location.getDirections().containsKey(way)){
            this.location = this.location.getDirections().get(way);
            System.out.println();
            System.out.println("Ты пришёл в " + this.location.getName());
        }
        else System.out.println("Ты не можешь пойти в эту сторону.");
    }
    public Location getLocation(){return this.location;}
    public void take(String item){
        item = item.toLowerCase();
        if(this.location.getInventory().contains(item))
        {
            if (this.location.getInventory().get(item).isMovable()) {
                this.inventory.add(item, this.location.getInventory().get(item));
                Inventory newInventory = this.location.getInventory();
                newInventory.remove(item);
                this.location.setInventory(newInventory);
                System.out.println("Ты положил " + item + " в свой инвентарь.");
            }
            else System.out.println("Сейчас ты не можешь это взять");
        }
        else System.out.println("Здесь нет этого предмета.");
    }
    public void put(String item) {
        item = item.toLowerCase();
        if (this.inventory.contains(item))
        {
            Inventory newInventory = this.location.getInventory();
            newInventory.add(item, this.inventory.get(item));
            this.location.setInventory(newInventory);
            this.inventory.remove(item);
            System.out.println("Ты выложил " + item + " из своего инвентаря.");
        }
        else System.out.println("У тебя сейчас нет этого предмета.");
    }
    public void showLocationInventory(){
        this.location.getInventory().show();
    }
    public void showInventory(){
        if (!this.inventory.isEmpty())
            this.inventory.show();
        else System.out.println("У тебя с собой ничего нет.");
    }
    public void use(String name){
        if (this.inventory.contains(name)){
            if (this.inventory.get(name).isUsable()){
                System.out.println(this.inventory.get(name).getUsing());
                this.inventory.remove(name);
            }
            else System.out.println(this.inventory.get(name).getUsing());
        }
        else System.out.println("У тебя в инвентаре этого нет.");
    }
}
