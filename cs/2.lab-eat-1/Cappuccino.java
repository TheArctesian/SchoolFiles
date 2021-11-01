public class Cappuccino {
    double cost;
    String description;
    String name;

    public Drink()
    {
        cost = 2.0;
        description = "A delicious beverage topped with frothed hot milk or cream and often flavored with cinnamon";
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
