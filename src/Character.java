import  java.util.Random;
import java.util.UUID;

public class Character {
    private final String id;
    private String name;
    private int hp ;
    private boolean isAlive ;

    public Character(String name, int hp){
        this.id=generateId();
        this.name=name;
        this.hp=hp;
        this.isAlive =true;

    }

    public String getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    private String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}


