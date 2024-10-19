import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RPGGame game = new RPGGame();
        int choice = -1;

        do {
            System.out.println("Select what to do: ");
            System.out.println("1) Load ");
            System.out.println("2) New ");
            System.out.print("-> ");
            choice = scan.nextInt();
            scan.nextLine(); 
    
            if (choice == 2) {
                game.inputPlayerDetails();
                game.saveGame();
                game.displayPlayerStats();
            } else if (choice == 1) {
                game.loadGame();
                game.displayPlayerStats();
            } else if(choice == 0){
                scan.close();
                return;
            } 
        } while(choice != 0);
        scan.close();
    }
}
