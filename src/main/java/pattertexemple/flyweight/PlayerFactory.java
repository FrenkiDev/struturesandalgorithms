package pattertexemple.flyweight;

import java.util.HashMap;

public class PlayerFactory {
    private static HashMap<String, Player> playerHashMapyers = new HashMap<>();

    public static Player creatPlayer(String team) {
        Player players = null;

        if (playerHashMapyers.containsKey(team)) {
            players = playerHashMapyers.get(team);
        } else {
            switch (team) {
                case "Terrorist": {
                    players = new Terrorist();
                    System.out.println("Terrorist team created!");
                }
                break;
                case "Counter-Terrorist": {
                players = new CounterTerrorist();
                    System.out.println("Counter-Terrorist team created!");
                }
                break;
            }
        }

        playerHashMapyers.put(team, players);

        return players;
    }
}
