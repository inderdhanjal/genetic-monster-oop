package org.java.introduction.geneticmonster;

import java.io.*;

public class AquaticMonster extends Monster {
    public AquaticMonster(String name, String color, int strength, int speed) {
        super(name, color, strength, speed);
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(name + " is swimming!");
    }

    public void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"));
        writer.write(name + "," + color + "," + strength + "," + speed);
        writer.close();
    }

    public static AquaticMonster loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String[] parts = reader.readLine().split(",");
        reader.close();
        return new AquaticMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
    }
}
