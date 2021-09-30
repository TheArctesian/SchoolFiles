import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println("Input your name: ");
    Scanner sc = new Scanner(System.in);
    String student = sc.next();
    System.out.println(student);
    Student student1 = new Student(student);

    System.out.println(student1.getName());
    VendingMachine vend = new VendingMachine();


    Cappuccino capp1 = new Cappuccino();




  }
}