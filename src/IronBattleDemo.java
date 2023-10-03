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
                    System.err.println("WRONG INPUT! Please enter a number that in the menu.");
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

        if(winnerP == "tie"){
            printTie();
            startCustomizeBattle();
        } else {
            printWinner(winnerP);
            chooseMenu();
        }

    }

    public static void startRandomBattle(){

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
                    System.err.println("WRONG INPUT! Please enter a number that in the menu.");
            }
        }while (inputNumber != 1 && inputNumber !=2);

        return null;
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
            System.out.println("|  Stamina: "+((Wizard) p1).getMana());
            System.out.println("|  Strength: "+((Wizard) p1).getIntelligence());
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
            System.out.println("|  Stamina: "+((Wizard) p2).getMana());
            System.out.println("|  Strength: "+((Wizard) p2).getIntelligence());
        }
        System.out.println("| ______________________________________________ |");
    }

    //TODO
    public static String startRound(int roundNum, Character p1, Character p2){
        Scanner inputAttack = new Scanner(System.in);
        String nameP1 = p1.getClass().getSimpleName();
        String nameP2 = p2.getClass().getSimpleName();
        printRoundInfo(roundNum, p1, p2);
        System.out.println("| ______________________________________________ |");
        System.out.println("|                                                |");
        System.out.println("|          :joystick: LET'S START THE ROUND :joystick:           |");
        System.out.println("|              Press Enter to Start              |");
        inputAttack.nextLine();
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P1,                  |");
        System.out.println("|                                                |");
        if(nameP1.equals("Warrior")) {
            ((Warrior) p1).attack(p2);
            System.out.println("|  Type Attack: "+p1.getTypeAttack());
        }else if (nameP1.equals("Wizard")) {
            ((Wizard) p1).attack(p2);
            System.out.println("|  Type Attack: "+p1.getTypeAttack());
        }
        System.out.println("|                                                |");
        System.out.println("|            Press Enter to ATTACK P2            |");
        inputAttack.nextLine();
        System.out.println("| ********************************************** |");
        System.out.println("|                                                |");
        System.out.println("|                 Your Turn P2,                  |");
        System.out.println("|                                                |");
        if(nameP2.equals("Warrior")) {
            ((Warrior) p2).attack(p1);
            System.out.println("|  Type Attack: "+p2.getTypeAttack());
        }else if (nameP2.equals("Wizard")) {
            ((Wizard) p2).attack(p1);
            System.out.println("|  Type Attack: "+p2.getTypeAttack());
        }
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

    //TODO
    public static void printWinner(String winnerP){

    }

    //TODO
    public static void printTie(){

    }

}
