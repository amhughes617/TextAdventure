import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.FileHandler;

/**
 * Created by alexanderhughes on 2/3/16.
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveller.");
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

        player.findItem("shield");
        player.findItem("boots");
        player.findItem("belt");

        /* String numStr = scanner.nextLine();
        int nInt= Integer.valueOf(numStr);*/
    }

    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            switch (line) {
                case "/hello":
                    System.out.println("Hello");
                    break;

                case "/inv":
                    for (String item : player.items) {
                        System.out.println(item);
                    }
                    break;

                case "/exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Command not found!");
                    break;
            }
            line = scanner.nextLine();
        }
        return line;
    }

}
