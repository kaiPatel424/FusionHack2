public class Carnation implements Plant{
    String name;
    int income;

    public Carnation(){
        name = "Carnation \uD83C\uDF38";
        income = 8;
    }

    public String getName(){
        return name;
    }

    public int getIncome(){
        return income;
    }
}
