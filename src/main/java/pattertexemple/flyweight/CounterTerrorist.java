package pattertexemple.flyweight;

public class CounterTerrorist implements Player {
    private static final String MISSION = "defuse the bomb";
    private String weapon;

    @Override
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void showInformation() {
        System.out.printf("Plaer Counter - Terrorist added. Weapon %s, Mission %s%n", weapon, MISSION);
    }
}
