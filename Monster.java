package org.java.introduction.geneticmonster;

import java.io.*;

public abstract class Monster {
    protected String name;
    protected String color;
    protected int strength;
    protected int speed;

    // Constructor
    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    // Abstract method for special ability
    public abstract void performSpecialAbility();

   
    @Override
    public String toString() {
        return name + "," + color + "," + strength + "," + speed;
    }

    
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(toString());
        }
    }

   
    public static Monster loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] parts = line.split(",");
            return new GenericMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
    }
}


class GenericMonster extends Monster {
    public GenericMonster(String name, String color, int strength, int speed) {
        super(name, color, strength, speed);
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " performs a generic special ability!");
    }
}
