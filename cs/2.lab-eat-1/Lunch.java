public class Lunch
{
    double cost;
    String description;
    String name;

    public Lunch()
    {
        cost = 1.0;
        description = "food";
    }

    public Lunch(String name)
    {
        description = name;
        cost = 5.0;
    }

    public Lunch(double money)
    {
        cost = money;
        description = "food";
    }

    public Lunch(String name, double money)
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