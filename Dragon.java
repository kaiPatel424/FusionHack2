public class Dragon implements Enemy {
    String name = "Dragon \uD83D\uDC09";
    int currentPoints = 0;
    int plantsEatable = 10;

    public boolean upgradeable() {
        return false;
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
