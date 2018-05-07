package patternEx;

import pattertexemple.flyweight.Player;
import pattertexemple.flyweight.PlayerFactory;

import java.util.Random;

public class TestFlyWeight {
    private static final String[] TEAM = {"Terrorist", "Counter-Terrorist"};
    private static final String[] WEAPON = {"K&M", "M16", "AK-47", "Colt"};

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++){
            Player player = PlayerFactory.creatPlayer(getRandomTeam());

            player.setWeapon(getRandomWeapon());
            player.showInformation();
        }
    }

    static String getRandomTeam(){
        Random randoms = new Random();
        int i = randoms.nextInt(TEAM.length);
        return TEAM[i];
    }

    static String getRandomWeapon(){
        Random randoms = new Random();
        int i = randoms.nextInt(WEAPON.length);
        return WEAPON[i];
    }
}
