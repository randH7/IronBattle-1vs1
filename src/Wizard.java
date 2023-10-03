import java.util.Random;

public class Wizard extends Character implements Attacker {

    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setHp(new Random().nextInt(51) + 50);
        setMana(new Random().nextInt(41) + 10);
        setIntelligence(new Random().nextInt(50) + 1);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character character) {
        int attack = 0;
        int attackRandom = new Random().nextInt(2);

        if (attackRandom == 0)
            attack = staffHit();
        else if (attackRandom == 1)
            attack = fireball();

        character.setHp((character.getHp() - attack));
    }

    public int fireball() {
        if (mana >= 5) {
            mana -= 5;
            super.setTypeAttack("|                  Fireball 🔥                   |");
            return intelligence;
        } else {
            return staffHit();
        }
    }

    public int staffHit() {
        if (mana > 0) {
            mana++;
            super.setTypeAttack("|                  Staff Hit 🪄                  |");
            return 2;
        } else {
            mana += 2;
            super.setTypeAttack("|      You don't have the mana to do Attack      |\n|    So we will give you a gift (🫙 mana ++2)    |");
            return 0;
        }
    }

}
