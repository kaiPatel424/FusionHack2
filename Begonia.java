public class Begonia implements Plant{
    String name;
    int income;

    public Begonia(){
        name = "Begonia \uD83C\uDF3A";
        income = 3;
    }

    public String getName(){
        return name;
    }

    public int getIncome(){
        return income;
    }
}
