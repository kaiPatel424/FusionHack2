public abstract interface Enemy{
    boolean upgradeable();
    String getName();
    int getPoints();
    void increasePoints(int points);
    int getPlantsEatable();

}