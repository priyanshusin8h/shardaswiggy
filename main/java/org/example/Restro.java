package org.example;
//Food Item class: name, quantity and price
import java.util.*;
import java.io.*;

public class Restro {
    String name;
    String distance;
    String ratings;
    String id;

    Restro(String id, String name, String distance, String ratings){
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.ratings = ratings;
    }

}
