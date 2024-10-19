import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameDataManager {
    private Player player;
    private List<InventoryItem> inventory = new ArrayList<>();
    private List<Quest> quests = new ArrayList<>();

    public void setPlayer(Player player){
        this.player = player;
    }

    public void loadGameData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String section = "";

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("[") && line.endsWith("]")) {
                    // Identify section (e.g., [player])
                    section = line.substring(1, line.length() - 1).toLowerCase();
                } else if (line.contains("=")) {
                    // Split key and value
                    String[] parts = line.split("=");
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    // Populate data based on section
                    switch (section) {
                        case "player":
                            setPlayerData(key, value);
                            break;
                        case "inventory":
                            addInventoryItem(key, Integer.parseInt(value));
                            break;
                        case "quests":
                            addQuest(key, value);
                            break;
                    }
                }
            }

            System.out.println("Game data loaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayerData(String key, String value) {
        // Initialize player if not already created
        if (player == null) {
            player = new Player("", 0, 0, 0, 0);
        }

        switch (key) {
            case "name":
                player.name = value;
                break;
            case "level":
                player.level = Integer.parseInt(value);
                break;
            case "health":
                player.health = Integer.parseInt(value);
                break;
            case "mana":
                player.mana = Integer.parseInt(value);
                break;
            case "gold":
                player.gold = Integer.parseInt(value);
                break;
        }
    }

    private void addInventoryItem(String name, int quantity) {
        inventory.add(new InventoryItem(name, quantity));
    }

    private void addQuest(String name, String status) {
        quests.add(new Quest(name, status));
    }

    public void saveGameData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Save player data
            bw.write("[player]\n");
            if (player != null) {
                bw.write("name=" + player.name + "\n");
                bw.write("level=" + player.level + "\n");
                bw.write("health=" + player.health + "\n");
                bw.write("mana=" + player.mana + "\n");
                bw.write("gold=" + player.gold + "\n");
            }

            // Save inventory data
            bw.write("\n[inventory]\n");
            for (InventoryItem item : inventory) {
                bw.write(item.name + "=" + item.quantity + "\n");
            }

            // Save quests data
            bw.write("\n[quests]\n");
            for (Quest quest : quests) {
                bw.write(quest.name + "=" + quest.status + "\n");
            }

            System.out.println("Game data saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters for accessing the data
    public Player getPlayer() {
        return player;
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
