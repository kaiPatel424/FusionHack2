public class Bluebell implements Plant{
    String name;
    int income;

    public Bluebell(){
        name = "Bluebell \uD83E\uDEBB";
        income = 12;
    }

    public String getName(){
        return name;
    }

    public int getIncome(){
        return income;
    }
}
