import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<Lunch> Lunch = new ArrayList<>();
    ArrayList<Breakfast> Breakfast = new ArrayList<>();
    ArrayList<Snack> Snack = new ArrayList<>();
    ArrayList<Drink> drinks = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public Student(String input) {
        name = input;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Breakfast> getBreakfast() {
        return Breakfast;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Lunch> getLunch() {
        return Lunch;
    }

    public ArrayList<Snack> getSnack() {
        return Snack;
    }

    public void addLunch(Lunch LunchTemp) {
        Lunch.add(LunchTemp);
    }

    public void addBreakfast(Breakfast BrkTemp) {
        Breakfast.add(BrkTemp);
    }

    public void addSnack(Snack SnackTemp) {
        Snack.add(SnackTemp);
    }

    public void addDrinks(Drink DrinksTemp) {
        drinks.add(DrinksTemp);
    }


}