import java.util.Random;

public class Wizard extends Character implements Attacker {


    private int mana;
    private int intelligence;

    //constructor:
    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setHp(hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    //setters and getters:
    public void setHp(int hp) {

        super.setHp(new Random().nextInt(51) + 50);
    }

    //mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {

        this.mana = new Random().nextInt(41) + 10;

    }

    //intelligence
    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = new Random().nextInt(50) + 1;
    }

    @Override
    public void attack(Character character) {
        int attack = 0;
        int attackRandom = new Random().nextInt();

        if (attackRandom == 0)
            attack = staffHit();
        else if (attackRandom == 1)
            attack = fireBall();

        character.setHp((character.getHp() - attack));
    }

    public int fireBall() {
        if (mana >= 5) {
            mana -= 5;
            return intelligence;
        } else {
            return staffHit();
        }
    }

    public int staffHit() {
        if (mana > 0) {
            mana++;
            return 2;
        } else {
            mana += 2;
            return 0;
        }

    }
}


