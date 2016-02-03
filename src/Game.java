import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.FileHandler;

/**
 * Created by alexanderhughes on 2/3/16.
 */
public class Game {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveller.");
        System.out.println("What is your name");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Welcome, " + name);

        System.out.println("Choose your weapon [sword/mace]");
        String weapon = scanner.nextLine();

        if(weapon.equalsIgnoreCase("sword")) {
            System.out.println("A sword is a fine choice!");
        }
        else if (weapon.equalsIgnoreCase("mace")) {
            System.out.println("A mace is a fine choice!");
        }
        else {
            throw new Exception("Invalid weapon!");         // must declare this exception at the top of the method
        }

        System.out.println("Choose your location [forest/tunnel]");
        String location = scanner.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        }
        else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        }
        else {
            throw new Exception("Invalid Location!");
        }
    }

}