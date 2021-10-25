import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    String name;
    ArrayList<Lunch> Lunch = new ArrayList<>();
    ArrayList<Breakfast> Breakfast = new ArrayList<>();
    ArrayList<Snack> Snack = new ArrayList<>();
    ArrayList<Drink> drinks = new ArrayList<>();
    HashMap<String, String> studentOrders = new HashMap<String, String>();
    public void setName(String name) {
        this.name = name;
    }
    public Student(String input) {
        name = input;
    }

    public String getName() {
        return name;
    }

    public String getBreakfast() {
        return Breakfast.toString();
    }

    public String getDrinks() {return drinks.toString();}

    public String getLunch() {
        return Lunch.toString();
    }

    public String getSnack() {return Snack.toString();}

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

    public void setStudentOrders(String type,String name) {
        studentOrders.put(type, name);
    }

    public HashMap<String, String> getSorders() {
        return studentOrders;
    }
}