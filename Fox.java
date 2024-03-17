public class Fox implements Enemy {
    String name = "Fox \uD83E\uDD8A";
    int currentPoints = 0;
    int pointsToUpgrade = 40;
    int plantsEatable = 5;

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
