public class Latte
{
    double cost;
    String description;
    String name;

    public Drink()
    {
        cost = 2.0;
        description = "Espresso mixed with milk so its not as nasty";
    }

    public Drink(String name)
    {
        description = name;
        cost = 5.0;
    }

    public Drink(double money)
    {
        cost = money;
        description = "pancake maybe";
    }

    public Drink(String name, double money)
    {
        cost = money;
        description = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }
}