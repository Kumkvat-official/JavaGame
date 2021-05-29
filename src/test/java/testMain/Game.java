package testMain;

import testInventory.*;
import testEnvironment.*;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static void game(){
        boolean game = true;
        String command, name;
        Scanner in = new Scanner(System.in);
        //Инвентарь и направления

        //Первая тестовая локация
        Item item1 = new Item("Первый предмет", "первый предмет", "первый тестовый предмет", "Ты использовал первый тестовый предмет", true, true);
        Item item2 = new Item("Второй предмет", "второй предмет", "второй тестовый предмет", "Ты не можешь сейчас это использовать", false, false);

        Inventory firstInventory = new Inventory();
        firstInventory.add(item1.getKey(), item1);
        firstInventory.add(item2.getKey(), item2);

        HashMap<String, Location> firstDirections = new HashMap<>();

        //Вторая тестовая локация

        Item item3 = new Item("Третий предмет", "третий предмет", "третий тестовый предмет", "Ты использовал третий тестовый предмет", true, true);
        Item item4 = new Item("Чётвертый предмет", "четвёртый предмет", "четвёртый тестовый предмет", "Ты не можешь сейчас это использовать", false, false);

        Inventory secondInventory = new Inventory();
        secondInventory.add(item3.getKey(), item3);
        secondInventory.add(item4.getKey(), item4);
        HashMap<String,Location> secondDirections = new HashMap<>();



        //Создание локаций

        Location first = new Location("Первая тестовая локация", "", firstDirections);
        Location second = new Location("Вторая тестовая локация","",secondDirections);


        //Присваивание направлений, инвентаря и описаний локациям
        first.setDescription(Descriptions.firstDescription);
        first.addDirection("вперёд", second);
        first.setInventory(firstInventory);
        second.setDescription(Descriptions.secondDescription);
        second.addDirection("назад", first);
        second.setInventory(secondInventory);




        //Вступление игры

        System.out.println(Descriptions.help);
        System.out.print("Введи своё имя: ");
        name = in.nextLine();
        Player player = new Player(name, first);
        System.out.println("Привет, " + player.getName()+"! Это тестовая версия игры, включающая в себя две локации с двумя предметами каждой.");
        System.out.println();
        System.out.println("Для тестирования игры вводи команды из таблички выше. В этой версии игры нет конца, выйти можно только по команде.");

        //Основная игра
        while (game) {
            command = in.nextLine();
            command = command.toLowerCase();
            switch (command) {
                case "локация" -> player.lookAround();
                case "предметы" -> player.showLocationInventory();
                case "взять" -> {
                    System.out.println("Что ты хочешь взять?");
                    command = in.nextLine();
                    command = command.toLowerCase();
                    player.take(command);
                }
                case "выложить" -> {
                    System.out.println("Что ты хочешь выложить?");
                    command = in.nextLine();
                    command = command.toLowerCase();
                    player.put(command);
                }
                case "инвентарь" -> {
                    System.out.println("У тебя есть:");
                    player.showInventory();
                }
                case "использовать" -> {
                    System.out.println("Что ты хочешь использовать?");
                    command = in.nextLine();
                    command = command.toLowerCase();
                    player.use(command);
                }
                case "вперёд", "назад", "влево", "вправо" -> player.go(command);
                case "помощь" -> System.out.println(Descriptions.help);
                case "выход" -> game = false;
                default -> System.out.println("Неизвестная команда!");
            }
        }
    }
}
