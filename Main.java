import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    int balance = 50;
    int daysAlive;
    ArrayList<Enemy> currentEnemyList;
    int currentEnemyIndex = 0;
    Enemy currentEnemy;
    Garden myGarden = new Garden();
    Scanner scanner = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public void dislayShop(){
        String plantToBuy;
        boolean keepBuying = true;
        System.out.println("Name | Price/Income");
        System.out.println("1. Honeysuckle: 15");
        System.out.println("2. Bluebell: 12");
        System.out.println("3. Carnation: 8");
        System.out.println("4. Laburnum: 5");
        System.out.println("5. Begonia: 3");
        System.out.println("6. EXIT SHOP");

        while(keepBuying){
            System.out.println("Would you like to buy a plant?");
            plantToBuy = scanner.nextLine();
            boolean expression = !(plantToBuy.equals("1") || plantToBuy.equals("2") || plantToBuy.equals("3") || plantToBuy.equals("4") || plantToBuy.equals("5") || plantToBuy.equals("6"));
            while(expression){
                System.out.println(RED + "NOT A VALID OPTION" + RESET);
                System.out.println("Would you like to buy a plant?");
                plantToBuy = scanner.nextLine();
                expression = !(plantToBuy.equals("1") || plantToBuy.equals("2") || plantToBuy.equals("3") || plantToBuy.equals("4") || plantToBuy.equals("5") || plantToBuy.equals("6"));
            }

            if (plantToBuy.equals("1")){
                Honeysuckle honeysuckle = new Honeysuckle();
                if (balance >= honeysuckle.getIncome()){
                    myGarden.addPlant(honeysuckle);
                    balance = balance - honeysuckle.getIncome();
                    System.out.println(GREEN + "Your new balance is: " + balance + "¥" + RESET);
                }else{
                    System.out.println( RED + "INSUFFICIENT FUNDS" + RESET);
                }

            }
            if (plantToBuy.equals("2")){
                Bluebell bluebell = new Bluebell();
                if (balance >= bluebell.getIncome()){
                    myGarden.addPlant(bluebell);
                    balance = balance - bluebell.getIncome();
                    System.out.println(GREEN + "Your new balance is: " + balance + "¥" + RESET);
                }else{
                    System.out.println(RED + "INSUFFICIENT FUNDS" + RESET);
                }

            }
            if (plantToBuy.equals("3")){
                Carnation carnation = new Carnation();
                if (balance >= carnation.getIncome()){
                    myGarden.addPlant(carnation);
                    balance = balance - carnation.getIncome();
                    System.out.println(GREEN + "Your new balance is: " + balance + "¥" + RESET);
                }else{
                    System.out.println(RED + "INSUFFICIENT FUNDS" + RESET);
                }

            }
            if (plantToBuy.equals("4")){
                Laburnum laburnum = new Laburnum();
                if (balance >= laburnum.getIncome()){
                    myGarden.addPlant(laburnum);
                    balance = balance - laburnum.getIncome();
                    System.out.println(GREEN + "Your new balance is: " + balance + "¥" + RESET);
                }else{
                    System.out.println(RED + "INSUFFICIENT FUNDS" + RESET);
                }

            }
            if (plantToBuy.equals("5")){
                Begonia begonia = new Begonia();
                if (balance >= begonia.getIncome()){
                    myGarden.addPlant(begonia);
                    balance = balance - begonia.getIncome();
                    System.out.println(GREEN + "Your new balance is: " + balance + "¥" + RESET);
                }else{
                    System.out.println(RED + "INSUFFICIENT FUNDS" + RESET);
                }
            }

            if (plantToBuy.equals("6")){
                System.out.println("EXITING THE SHOP...");
                keepBuying = false;
            }
        }
    }

    public void createArrayList(){ // Created the array list of enemies
        currentEnemyList = new ArrayList<>();
        currentEnemyList.add(new Slug());
        currentEnemyList.add(new Meerkat());
        currentEnemyList.add(new Racoon());
        currentEnemyList.add(new Fox());
        currentEnemyList.add(new Bear());
        currentEnemyList.add(new Dragon());
    }
    public void simulate(){
        createArrayList();
        while (currentEnemyIndex != 5 || (balance <=0 && myGarden.isEmpty())){
            for(daysAlive = 1; daysAlive <= 10; daysAlive++) { //Loops for 10 days
                currentEnemy = currentEnemyList.get(currentEnemyIndex);
                System.out.println("---------- DAY " + daysAlive + " ----------");
                System.out.println(BLUE + "BALANCE: " + balance + "¥" + RESET);
                //displays shop and asks player if they'd like to buy anything
                System.out.println("Would you like to visit the shop (y/n)?");
                String option = scanner.nextLine();
                while (!(option.equals("y") || (option.equals("n")))) {
                    System.out.println("Would you like to visit the shop (y/n)?");
                    option = scanner.nextLine();
                }
                if (option.equals("y")) {
                    dislayShop();
                }

                System.out.println(GREEN + "Your current garden is:" + RESET);
                myGarden.displayPlants();

                Random rand = new Random();
                int eatablePlants = rand.nextInt(currentEnemy.getPlantsEatable()) + 1;
                while (eatablePlants > 0 && (!myGarden.isEmpty())) {
                    //remove the plant eaten
                    //decrement the eaten plants counter
                    for (int i = 1; i <= eatablePlants; i++) {
                        if (!myGarden.isEmpty()) {
                            Plant randomPlant = myGarden.randPlant();
                            System.out.println(RED + currentEnemy.getName() + " has eaten " + randomPlant.getName() + RESET);
                            myGarden.remove(randomPlant);
                            // enemy gains
                            currentEnemy.increasePoints(randomPlant.getIncome());
                            System.out.println(RED + currentEnemy.getName() + " is now on " + currentEnemy.getPoints() + " points" + RESET);
                        }else{
                            break;
                        }
                    }
                    eatablePlants = 0;
                }

                System.out.println(GREEN + "Your current garden is:" + RESET);
                myGarden.displayPlants();

                try {
                    Thread.sleep(1000); //Pauses for one second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (currentEnemy.upgradeable()) { //Checks to see if the enemy is ready to be upgraded
                    currentEnemyIndex++;
                    currentEnemy = currentEnemyList.get(currentEnemyIndex);
                    System.out.println(RED + "Current enemy is: " + currentEnemy.getName() + RESET);
                }
                balance += myGarden.getAllPoints();

                if (currentEnemyIndex == 5 || (balance <= 3 && myGarden.isEmpty())){
                    System.out.println(RED + "YOU LOSE \uD83D\uDE08" + RESET);
                    System.exit(0);
                }

            }
            System.out.println(GREEN + "YOU WIN \uD83C\uDFC6" + RESET);
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.simulate();
    }
}