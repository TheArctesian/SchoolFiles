public class Espresso {
    double cost;
    String description;
    String name;

    public Drink()
    {
        cost = 2.0;
        description = "STRONG black coffee made by forcing steam through ground coffee bean";
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

