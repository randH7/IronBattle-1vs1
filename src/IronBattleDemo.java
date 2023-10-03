import java.util.Random;
import java.util.Scanner;

public class IronBattleDemo {

    public static void main(String[] args) {
        chooseMenu();
    }

    public static void chooseMenu(){

        Scanner inputUser = new Scanner(System.in);
        int inputNumber;

        do{
            printStartMenu();
            inputNumber = inputUser.nextInt();
            switch (inputNumber){
                case 1:
                    startCustomizeBattle();
                case 2:
                    startRandomBattle();
                case 3:
                    System.exit(0);
                default:
                    System.err.println("WRONG INPUT!\nPlease enter a number that in the menu.");
            }
        }while (inputNumber <= 1 || inputNumber >= 3);

    }

    public static void startCustomizeBattle(){

        Character p1 = customizeCharacter(1);
        Character p2 = customizeCharacter(2);
        int roundNum = 0;
        String winnerP = "";

        do{
            roundNum++;
            winnerP = startRound(roundNum, p1, p2);
        }while (winnerP == "");

        printRoundInfo(roundNum, p1, p2);

        if(winnerP == "tie"){
            printTie();
            Scanner input = new Scanner(System.in);
            input.nextLine();
            startCustomizeBattle();
        } else {
            if(winnerP.equals(p1.getId())) {
                printWinner(1);
                Scanner input = new Scanner(System.in);
                input.nextLine();
            }else if (winnerP.equals(p2.getId())) {
                printWinner(2);
                Scanner input = new Scanner(System.in);
                input.nextLine();
            }

            chooseMenu();
        }

    }

    public static void startRandomBattle(){

        int characterP1 = new Random().nextInt(2); // 0 = warrior   1 = wizard
        int characterP2 = new Random().nextInt(2);

        Character p1 = characterRandom(characterP1, "Boot1");
        Character p2 = characterRandom(characterP2, "Boot2");

        int roundNum = 0;
        String winnerP = "";

        do{
            roundNum++;
            winnerP = startRoundBoot(roundNum, p1, p2);
        }while (winnerP == "");

        printRoundInfo(roundNum, p1, p2);

        if(winnerP == "tie"){
            printTie();
            startRandomBattle();
        } else {
            if(winnerP.equals(p1.getId()))
                printWinner(1);
            else if (winnerP.equals(p2.getId()))
                printWinner(2);

            chooseMenu();
        }
    }

    public static void printStartMenu(){
        System.out.println("| ______________________________________________ |");
        System.out.println("|            WELCOME TO IRON BATTLE ⚔️           |");
        System.out.println("|       A Text-Based RPG Battle game 1vs.1       |");
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 To get started,                |");
        System.out.println("|        Type in a number below and enter.       |");
        System.out.println("|                                                |");
        System.out.println("|               1) Customize Battle              |");
        System.out.println("|               2) Random Battle                 |");
        System.out.println("|               3) Exit                          |");
        System.out.println("| ______________________________________________ |");
    }

    public static void printCharacterMenu(){
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|            Please choose character,            |");
        System.out.println("|        Type in a number below and enter.       |");
        System.out.println("|                                                |");
        System.out.println("|                  1) Warrior 🧝🏼                 |");
        System.out.println("|                  2) Wizard 🧙🏼‍♂️                  |");
        System.out.println("| ______________________________________________ |");
    }

    public static Character customizeCharacter(int playerNumber){
        Scanner inputUser = new Scanner(System.in);
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|          Please enter your name P"+playerNumber+" 📝          |");
        System.out.println("| ______________________________________________ |");
        String inputName = inputUser.next();

        int inputNumber;

        do{
            printCharacterMenu();
            inputNumber = inputUser.nextInt();
            switch (inputNumber){
                case 1:
                    return new Warrior(inputName, 0,0,0);
                case 2:
                    return new Wizard(inputName, 0,0,2);
                default:
                    System.err.println("WRONG INPUT!\nPlease enter a number that in the menu.");
            }
        }while (inputNumber != 1 && inputNumber !=2);

        return null;
    }

    public static Character characterRandom(int characterRandom, String name){

        Character character = new Warrior("null", 0, 0, 0);

        if(characterRandom == 0)
            character = new Warrior(name, 0, 0, 0);
        else if(characterRandom == 1)
            character = new Wizard(name, 0, 0, 0);

        return character;

    }

    public static void printRoundInfo(int roundNum, Character p1, Character p2){
        String nameP1 = p1.getClass().getSimpleName();
        String nameP2 = p2.getClass().getSimpleName();

        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|                    ROUND #"+roundNum+"                    |");
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|                    PLAYER #1                   |");
        if(nameP1.equals("Warrior")) {
            System.out.println("| ______________________________________________ |");
            System.out.println("|  🧝🏼 "+p1.getName());
            System.out.println("|  HP: "+ p1.getHp());
            System.out.println("|  Stamina: "+((Warrior) p1).getStamina());
            System.out.println("|  Strength: "+((Warrior) p1).getStrength());
        }
        else if(nameP1.equals("Wizard")) {
            System.out.println("| ______________________________________________ |");
            System.out.println("|  🧙🏼‍♂️ "+p1.getName());
            System.out.println("|  HP: "+ p1.getHp());
            System.out.println("|  Mana: "+((Wizard) p1).getMana());
            System.out.println("|  Intelligence: "+((Wizard) p1).getIntelligence());
        }
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|                    PLAYER #2                   |");
        if(nameP2.equals("Warrior")) {
            System.out.println("| ______________________________________________ |");
            System.out.println("|  🧝🏼 "+p2.getName());
            System.out.println("|  HP: "+ p2.getHp());
            System.out.println("|  Stamina: "+((Warrior) p2).getStamina());
            System.out.println("|  Strength: "+((Warrior) p2).getStrength());
        }
        else if(nameP2.equals("Wizard")) {
            System.out.println("| ______________________________________________ |");
            System.out.println("|  🧙🏼‍♂️ "+p2.getName());
            System.out.println("|  HP: "+ p2.getHp());
            System.out.println("|  Mana: "+((Wizard) p2).getMana());
            System.out.println("|  Intelligence: "+((Wizard) p2).getIntelligence());
        }
        System.out.println("| ______________________________________________ |");
    }

    public static String startRound(int roundNum, Character p1, Character p2){
        Scanner inputAttack = new Scanner(System.in);
        String nameP1 = p1.getClass().getSimpleName();
        String nameP2 = p2.getClass().getSimpleName();
        printRoundInfo(roundNum, p1, p2);
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|          🕹️ LET'S START THE ROUND 🕹️           |");
        System.out.println("|              Press Enter to Start              |");
        inputAttack.nextLine();
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P1,                  |");
        System.out.println("|                                                |");
        if(nameP1.equals("Warrior")) {
            ((Warrior) p1).attack(p2);
            System.out.println("|                 (Type Attack)                 |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p1.getTypeAttack());
        }else if (nameP1.equals("Wizard")) {
            ((Wizard) p1).attack(p2);
            System.out.println("|                 (Type Attack)                 |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p1.getTypeAttack());
        }
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|            Press Enter to ATTACK P2            |");
        inputAttack.nextLine();
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P2,                  |");
        System.out.println("|                                                |");
        if(nameP2.equals("Warrior")) {
            ((Warrior) p2).attack(p1);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p2.getTypeAttack());
        }else if (nameP2.equals("Wizard")) {
            ((Wizard) p2).attack(p1);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p2.getTypeAttack());
        }
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|            Press Enter to ATTACK P1            |");
        inputAttack.nextLine();
        System.out.println("| ______________________________________________ |");
        if(p1.getHp() <= 0)
            p1.setAlive(false);
        if(p2.getHp() <= 0)
            p2.setAlive(false);
        if(p1.isAlive() == false || p2.isAlive() == false){
            if(p1.getHp() > p2.getHp())
                return p1.getId();
            else if(p2.getHp() > p1.getHp())
                return p2.getId();
            else if (p1.getHp() == p2.getHp())
                return "tie";
        }
        return "";
    }

    public static String startRoundBoot(int roundNum, Character p1, Character p2){
        String nameP1 = p1.getClass().getSimpleName();
        String nameP2 = p2.getClass().getSimpleName();
        printRoundInfo(roundNum, p1, p2);
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|          🕹️ LET'S START THE ROUND 🕹️           |");
        System.out.println("|              Press Enter to Start              |");
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P1,                  |");
        System.out.println("|                                                |");
        if(nameP1.equals("Warrior")) {
            ((Warrior) p1).attack(p2);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p1.getTypeAttack());
        }else if (nameP1.equals("Wizard")) {
            ((Wizard) p1).attack(p2);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p1.getTypeAttack());
        }
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|            Press Enter to ATTACK P2            |");
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P2,                  |");
        System.out.println("|                                                |");
        if(nameP2.equals("Warrior")) {
            ((Warrior) p2).attack(p1);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p2.getTypeAttack());
        }else if (nameP2.equals("Wizard")) {
            ((Wizard) p2).attack(p1);
            System.out.println("|                 (Type Attack)                  |");
            System.out.println("|                       ⇓                        |");
            System.out.println(p2.getTypeAttack());
        }
        System.out.println("|                                                |");
        System.out.println("|                                                |");
        System.out.println("|            Press Enter to ATTACK P1            |");
        System.out.println("| ______________________________________________ |");
        if(p1.getHp() <= 0)
            p1.setAlive(false);
        if(p2.getHp() <= 0)
            p2.setAlive(false);
        if(p1.isAlive() == false || p2.isAlive() == false){
            if(p1.getHp() > p2.getHp())
                return p1.getId();
            else if(p2.getHp() > p1.getHp())
                return p2.getId();
            else if (p1.getHp() == p2.getHp())
                return "tie";
        }
        return "";
    }

    public static void printWinner(int winnerP){
        System.out.println("| ______________________________________________ |");
        System.out.println("|          THE WINNER OF IRON BATTLE ⚔️          |");
        System.out.println("|       A Text-Based RPG Battle game 1vs.1       |");
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                       🥇                       |");
        System.out.println("|                ⭐ PLAYER #"+winnerP+" ⭐                 |");
        System.out.println("|               YOU ARE THE WINNER               |");
        System.out.println("|                                                |");
        System.out.println("| ______________________________________________ |");
        System.out.println("|         Press Enter to GO to START MENU        |");
    }

    public static void printTie(){
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|          ❗THE BATTLE END IN A TIE❗           |");
        System.out.println("|             Press Enter to Restart             |");
        System.out.println("| ______________________________________________ |");
    }

}
