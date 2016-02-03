import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.FileHandler;

/**
 * Created by alexanderhughes on 2/3/16.
 */
public class Game {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, traveller.");
        Player player = new Player();
        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

    }

}
