import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
        try {
            player = loadGame();
            System.out.println("Loaded saved game");
        }
        catch (Exception e) {
            System.out.println("Starting new game");
        }
        if (player.name == null) player.chooseName();
        if (player.weapon == null) player.chooseWeapon();
        if (player.location == null) player.chooseLocation();

        if (player.items.isEmpty()) {
            player.findItem("shield");
            player.findItem("boots");
            player.findItem("belt");
        }

        Enemy ogre = new Enemy("Ogre", 10, 10);
        player.battle(ogre);
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
                case "/save":
                    try {
                        saveGame();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Command not found!");
                    break;
            }
            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame() throws IOException {  //save game code
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(player);    //"*" serializes everything including hashmaps and arrays

        File f = new File("game.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
        System.out.println("Game Saved!!!");
    }

    public static Player loadGame() throws FileNotFoundException {
        File f = new File("game.json");
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser  parser = new JsonParser();
        return parser.parse(contents, Player.class);
    }
}
