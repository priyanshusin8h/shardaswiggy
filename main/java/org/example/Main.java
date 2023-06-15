package org.example;

import java.io.BufferedReader;
import org.example.Dish;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.io.FileReader;
import org.example.Restro;
class Parse{

    Dish[] dishes = new Dish[10];
    Restro [] restaurants = new Restro[10];
    void parse_dishes(){
        try {
            FileReader fr = new FileReader("data/Dish.csv");
            BufferedReader br = new BufferedReader(fr);
            String newline;
            String[] arr;
            int i = 0;
            while ((newline = br.readLine()) != null) {
                arr = newline.split(",");
                Dish d = new Dish(arr[0],arr[1],arr[2]);
                dishes[i] = d;
                i++;
            }
        } catch (Exception e) {
            System.out.print("");
        }
    }

    void parse_restaurant(){
        try{
            FileReader f = new FileReader("data/Restro.csv");
            BufferedReader br = new BufferedReader(f);
            String newline;
            String[] arr;
            int i = 0;
            while ((newline = br.readLine()) != null) {
                arr = newline.split(",");
                Restro d = new Restro(arr[0],arr[1],arr[2],arr[3]);
                restaurants[i] = d;
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parse p = new Parse();
        p.parse_dishes();
        p.parse_restaurant();
        int choice;
        do {
            System.out.println("Welcome to Sharda Swiggy");
            System.out.println("Press 0 for displaying menu, 1 for searching the menu, 2 for exit");
            choice = sc.nextInt();
            Restro[] restaurants = p.restaurants;
            Dish[] dishes = p.dishes;
            switch (choice) {
                case 0:
                    System.out.println("MENU DISPLAYED BELOW |-------------------|");
                    for (int i = 0; i < 10; i++) {
                        if (restaurants[i] != null) {
                            float k = (i + 1) / 10;
                            System.out.println(String.format("%s %5s %5s",restaurants[i].id, restaurants[i].name + "\uD83C\uDF7D\uFE0F",  restaurants[i].ratings ));
                            for (int j = 0; j < 10; j++) {
                                if (dishes[j] != null && restaurants[i].id.equals(dishes[j].id)) {
                                    k += 0.1;
                                    System.out.println(String.format("\t%.1f %5s %5s", Integer.parseInt(dishes[j].id) + k, dishes[j].dish_name, dishes[j].price + "\uD83D\uDCB5"));
                                }
                            }
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;
                case 1:
                    System.out.println("Choose restaurant to search from : ");
                    for(int i = 0; i<10; i++){
                        if(restaurants[i] != null)
                            System.out.println(String.format("%s %5s %5s",restaurants[i].id, restaurants[i].name + "\uD83C\uDF7D\uFE0F",  restaurants[i].ratings + "✨" ));
                    }
                    int index = sc.nextInt();

//                    for(int i = 0; i<10; i++){
//                        if(Integer.parseInt(restaurants[i].id) == index)
//
//                    }
//                    System.out.println("Choose a dish from selected restaurants: ");
                    break;
                case 2:
                    System.out.println("Exit!");
                    break;
            }
        }while(choice != 2);
    }
    }



