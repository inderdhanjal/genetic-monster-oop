package org.java.introduction.geneticmonster;

import java.io.*;

public class FlyingMonster extends Monster {
    private int wingSpan;

    public FlyingMonster(String name, String color, int strength, int speed, int wingSpan) {
        super(name, color, strength, speed);
        this.wingSpan = wingSpan;
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is flying with a wingspan of " + wingSpan + " meters!");
    }

    @Override
    public String toString() {
        return name + "," + color + "," + strength + "," + speed + "," + wingSpan;
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(toString());
        }
    }

    public static FlyingMonster loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] parts = reader.readLine().split(",");
            return new FlyingMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
        }
    }
}
