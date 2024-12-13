package org.java.introduction.geneticmonster;

import java.io.*;

public class DesertMonster extends Monster {
    public DesertMonster(String name, String color, int strength, int speed) {
        super(name, color, strength, speed);
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is surviving in the desert!");
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(name + "," + color + "," + strength + "," + speed);
        }
    }

    public static DesertMonster loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] parts = reader.readLine().split(",");
            return new DesertMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
    }
}
