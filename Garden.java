import java.util.ArrayList;
import java.util.Random;

public class Garden {
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    ArrayList<Plant> plants = new ArrayList<>();

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public void displayPlants(){
        for(Plant plant: plants){
            System.out.println(YELLOW + plant.getName() + RESET);
        }
    }

    public void remove(Plant name){  // remove plant if it gets eaten
        plants.remove(name);
    }

    public boolean isEmpty(){
        return plants.isEmpty();
    }

    public Plant randPlant(){
        Random random = new Random();
        int randomIndex = random.nextInt(plants.size());
        Plant randomPlant = plants.get(randomIndex);
        return randomPlant;
    }

    public int getAllPoints(){
        int points = 0;
        for(Plant plant: plants){
            points += plant.getIncome();
        }
        return points;
    }
}
