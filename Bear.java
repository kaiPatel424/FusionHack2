public class Bear implements Enemy {
    String name = "Bear \uD83E\uDDF8";
    int currentPoints = 0;
    int pointsToUpgrade = 50;
    int plantsEatable = 7;

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
