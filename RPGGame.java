import java.util.Scanner;

public class RPGGame {
    private static final String FILE_NAME = "gameData.txt";
    private GameDataManager gameDataManager;
    private Scanner scanner;

    public RPGGame() {
        gameDataManager = new GameDataManager();
        scanner = new Scanner(System.in);
    }

    public void loadGame() {
        gameDataManager.loadGameData(FILE_NAME);
    }

    public void saveGame() {
        gameDataManager.saveGameData(FILE_NAME);
    }

    public void displayPlayerStats() {
        Player player = gameDataManager.getPlayer();
        if (player != null) {
            System.out.println("Player Stats:");
            System.out.println("-------------");
            System.out.println("Name: " + player.name);
            System.out.println("Level: " + player.level);
            System.out.println("Health: " + player.health);
            System.out.println("Mana: " + player.mana);
            System.out.println("Gold: " + player.gold);
        } else {
            System.out.println("No player data available.");
        }
    }

    public void inputPlayerDetails() {
        System.out.println("Enter player details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Level: ");
        int level = Integer.parseInt(scanner.nextLine());
        System.out.print("Health: ");
        int health = Integer.parseInt(scanner.nextLine());
        System.out.print("Mana: ");
        int mana = Integer.parseInt(scanner.nextLine());
        System.out.print("Gold: ");
        int gold = Integer.parseInt(scanner.nextLine());

        Player player = new Player(name, level, health, mana, gold);
        gameDataManager.setPlayer(player);
        System.out.println("Player details saved.");
    }
}
