import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Input your name: ");
        Scanner sc = new Scanner(System.in);
        String student = sc.next();
        Cappuccino capp1 = new Cappuccino();
        Student student1 = new Student(student);
        System.out.println(student1.name + " has " + student1.monies + "$");
        sc.close();
        Scanner peepee = new Scanner(System.in);
        VendingMachine vend = new VendingMachine();
        vendStart(vend, peepee);
    }


    private static void vendStart(VendingMachine vend, Scanner peepee) {
        System.out.println("""
                Actions
                 1. Look at Machines stock
                 2. Look at how much money you have
                 3. Buy a coffee
                 4. End
                 """);
        String action = peepee.next();
        if (action.equals("1")) {
            vendStock(vend, peepee);
        }

    }

    private static void vendStock(VendingMachine vend, Scanner peepee) {
        System.out.println(vend.getVendStock());
        vendStart(vend, peepee);
    }
}



