// Class for storing player information
class Player {
    String name;
    int level;
    int health;
    int mana;
    int gold;

    public Player(String name, int level, int health, int mana, int gold) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    }
}

// Class for storing inventory items
class InventoryItem {
    String name;
    int quantity;

    public InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

// Class for storing quest information
class Quest {
    String name;
    String status;

    public Quest(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
