import java.util.Random;

public class Warrior extends Character  implements Attacker {

    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setHp(new Random().nextInt(101) + 100);
        setStamina(new Random().nextInt(41) + 10);
        setStrength(new Random().nextInt(10) + 1);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {
        int attack = 0;
        int attackRandom = new Random().nextInt(2);

        if(attackRandom == 0)
            attack = weakAttack();
        else if(attackRandom == 1)
            attack = heavyAttack();

        character.setHp((character.getHp() - attack));
    }

    public int heavyAttack(){
        if(stamina >= 5){
            stamina -= 5;
            super.setTypeAttack("|                Heavy Attack 🗡️                 |");
            return strength;
        } else {
            return weakAttack();
        }
    }

    public int weakAttack(){
        if(stamina > 0){
            stamina++;
            super.setTypeAttack("|                 Weak Attack 🏹                 |");
            return strength/2;
        } else {
            stamina += 2;
            super.setTypeAttack("|    You don't have the stamina to do Attack     |\n|   So we will give you a gift (🧪 stamina ++2)  |");
            return 0;
        }
    }

}
