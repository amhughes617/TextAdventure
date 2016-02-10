/**
 * Created by alexanderhughes on 2/9/16.
 */
public class Character {
    int health;
    int damage;
    String name;

    public void battle(Character enemy) {
        System.out.printf("%s appears!\n", enemy.name);

        while (health > 0 && enemy.health > 0) {

            health-= enemy.damage;
            enemy.health-= damage;

            System.out.printf("%s's health: %d\n", name, health);
            System.out.printf("%s's health: %d\n", enemy.name, enemy.health);
        }

        String message = "%s got knocked the fuck out!\n";

        if (health <= 0) {
            System.out.printf(message, name);
        }
        if (enemy.health <= 0) {
            System.out.printf(message, enemy.name);
        }

    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
