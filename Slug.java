
public class Slug implements Enemy {

    String name = "Slug \uD83D\uDC0C";
    int currentPoints = 0;
    int pointsToUpgrade = 20;
    int plantsEatable = 2;


    public boolean upgradeable() {
        if (currentPoints >= pointsToUpgrade){
            return true;
        }else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return currentPoints;
    }

    public int getPlantsEatable(){
        return plantsEatable;
    }

    public void increasePoints(int points){
        currentPoints += points;
    }
}
