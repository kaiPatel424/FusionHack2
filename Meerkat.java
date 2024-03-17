public class Meerkat implements Enemy{
    String name = "Meerkat \uD83D\uDC12";
    int currentPoints = 0;
    int pointsToUpgrade = 35;
    int plantsEatable = 3;

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
