public class Drink
{
    double cost;
    String description;
    String name;

    public Drink()
    {
        cost = 1.0;
        description = "pancake maybe";
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
}