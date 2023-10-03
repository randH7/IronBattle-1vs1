import java.util.UUID;

public abstract class Character {

    private final String id;
    private String name;
    private int hp ;
    private boolean isAlive ;
    private String typeAttack;

    public Character(String name, int hp){
        this.id=generateId();
        setName(name);
        setHp(hp);
        setAlive(true);
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
        this.isAlive = alive;
    }

    public String getTypeAttack() {
        return typeAttack;
    }

    public void setTypeAttack(String typeAttack) {
        this.typeAttack = typeAttack;
    }

    private String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
