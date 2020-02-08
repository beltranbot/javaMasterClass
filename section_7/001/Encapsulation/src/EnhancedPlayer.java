public class EnhancedPlayer {

    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int hitPoints, String weapon) {
        this.name = name;
        this.hitPoints = hitPoints > 0 && hitPoints <= 100 ? hitPoints : this.hitPoints;
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitPoints = this.hitPoints - damage;
        if (this.hitPoints <= 0) {
            System.out.println("Player knocke out");
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
