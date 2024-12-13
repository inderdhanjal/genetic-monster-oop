import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {
        MonsterManager manager = new MonsterManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Monster");
            System.out.println("2. View Monsters");
            System.out.println("3. Breed Monsters");
            System.out.println("4. Save Game");
            System.out.println("5. Load Game");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter color: ");
                    String color = scanner.next();
                    System.out.print("Enter strength: ");
                    int strength = scanner.nextInt();
                    System.out.print("Enter speed: ");
                    int speed = scanner.nextInt();
                    manager.addMonster(new GenericMonster(name, color, strength, speed));
                    break;
                case 2:
                    manager.displayMonsters();
                    break;
                case 3:
                    manager.displayMonsters();
                    System.out.print("Choose first monster index: ");
                    int index1 = scanner.nextInt();
                    System.out.print("Choose second monster index: ");
                    int index2 = scanner.nextInt();
                    manager.breedMonsters(index1, index2);
                    break;
                case 4:
                    try {
                        FileManager.saveMonsters(manager.getMonsters(), "monsters_data.txt");
                        System.out.println("Game saved!");
                    } catch (IOException e) {
                        System.out.println("Error saving game.");
                    }
                    break;
                case 5:
                    try {
                        manager.setMonsters(FileManager.loadMonsters("monsters_data.txt"));
                        System.out.println("Game loaded!");
                    } catch (IOException e) {
                        System.out.println("Error loading game.");
                    }
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
