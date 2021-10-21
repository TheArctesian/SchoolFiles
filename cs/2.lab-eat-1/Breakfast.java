public class Breakfast
{
    double cost;
    String description;
    String name;

    public Breakfast()
    {
        cost = 1.0;
        description = "pancake maybe";
    }

    public Breakfast(String name)
    {
        description = name;
        cost = 5.0;
    }

    public Breakfast(double money)
    {
        cost = money;
        description = "pancake maybe";
    }

    public Breakfast(String name, double money)
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