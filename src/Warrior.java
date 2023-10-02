import java.util.Random;

public class Warrior extends Character  implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setHp(hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public void setHp(int hp) {

        super.setHp(new Random().nextInt(101) + 100);

    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {

        this.stamina = new Random().nextInt(41) + 10;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = new Random().nextInt(10) + 1;
    }

    @Override
    public void attack(Character character) {
        int attack = 0;
        int attackRandom = new Random().nextInt();

        if(attackRandom == 0)
            attack =weakAttack();
        else if(attackRandom == 1)
            attack =heavyAttack();

        character.setHp((character.getHp()-attack));
    }

    public int heavyAttack(){
        if(stamina >= 5){
            stamina -= 5;
            return strength;
        } else {
            return weakAttack();
        }
    }

    public int weakAttack(){
        if(stamina > 0){
            stamina++;
            return strength/2;
        } else {
            stamina += 2;
            return 0;
        }
    }
}
