import java.util.ArrayList;

public class MonsterManager {
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void breedMonsters(int index1, int index2) {
        if (index1 < monsters.size() && index2 < monsters.size()) {
            Monster parent1 = monsters.get(index1);
            Monster parent2 = monsters.get(index2);
            // Combine traits (simplified example)
            String name = parent1.getName() + "-" + parent2.getName();
            String color = parent1.getColor();
            int strength = (parent1.getStrength() + parent2.getStrength()) / 2;
            int speed = (parent1.getSpeed() + parent2.getSpeed()) / 2;

            Monster offspring = new GenericMonster(name, color, strength, speed);
            monsters.add(offspring);
            System.out.println("New monster bred: " + offspring.getName());
        }
    }

    public void displayMonsters() {
        for (int i = 0; i < monsters.size(); i++) {
            System.out.println(i + ": " + monsters.get(i));
        }
    }
}
