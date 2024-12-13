
package org.java.introduction.geneticmonster;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Monster monster : monsters) {
                writer.write(monster.toString());
                writer.newLine();
            }
        }
    }

    public static ArrayList<Monster> loadMonsters(String filename) throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Monster monster = new Monster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    monsters.add(monster);
                }
            }
        }
        return monsters;
    }
}


---

Assumptions

1. The Monster class has the following structure:

public class Monster {
    private String name;
    private String type;
    private int attack;
    private int defense;

    public Monster(String name, String type, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return name + "," + type + "," + attack + "," + defense;
    }
}
