public class Snack
{
    double cost;
    String description;
    String name;

    public Snack()
    {
        cost = 1.0;
        description = "pancake maybe";
    }

    public Snack(String name)
    {
        description = name;
        cost = 5.0;
    }

    public Snack(double money)
    {
        cost = money;
        description = "pancake maybe";
    }

    public Snack(String name, double money)
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