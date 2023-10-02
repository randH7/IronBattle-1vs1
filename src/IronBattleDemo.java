import java.util.Scanner;

public class IronBattleDemo {

    public static void main(String[] args) {
        chooseMenu();
    }

    //TODO default sout re-enter number
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
            }
        }while (inputNumber <= 1 || inputNumber >= 3);

    }

    public static void startCustomizeBattle(){
        Character p1 = customizeCharacter(1);
        Character p2 = customizeCharacter(2);
        int roundNum = 0;
        int scoreP1 = 0;
        int scoreP2 = 0;
        String winnerP = "";

        do{
            roundNum++;

            printRoundInfo(roundNum, p1, p2, scoreP1, scoreP2);

            winnerP = startBattle(p1, p2);

            if(winnerP == p1.getId()){
                scoreP1++;
            }else if(winnerP == p2.getId()){
                scoreP2++;
            }

        }while ( roundNum == 1 || scoreP1 == scoreP2);

        printWinner();
        chooseMenu();

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

    //TODO default sout re-enter number
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
                    return new Warrior(inputName, 0);
                case 2:
                    return new Wizard(inputName, 0);
            }
        }while (inputNumber != 1 && inputNumber !=2);

        return null;
    }

    //TODO
    public static void printRoundInfo(int roundNum, Character p1, Character p2, int score1, int score2){
        System.out.println("| ______________________________________________ |");
        System.out.println("|                    ROUND #"+roundNum+"                    |");

        System.out.println("| ______________________________________________ |");
    }

    //TODO
    public static String startBattle(Character p1, Character P2){

        return "";
    }

    //TODO
    public static void printWinner(){

    }

}
