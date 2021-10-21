import java.util.*;

class Main {
    static Scanner peepee = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Input your name: ");
        String student = peepee.next();

        Student student1 = new Student(student);
        VendingMachine vend = new VendingMachine();

        System.out.println(student1.name + " has $" + student1.monies );
        vend.vendInit();
        vendStart(vend);

    }


    private static void vendStart(VendingMachine vend) {
        System.out.println("""
                Actions: to pick one type the word before the descr iption 
                 stock - Look at Machines stock
                 2. Look at how much money you have
                 3. Buy a coffee
                 4. End
                 """);
        String action = peepee.next();
        if (action.equals("1")) {
            vendStock(vend);
        }

    }

    private static void vendStock(VendingMachine vend) {
        System.out.println(vend.getVendStock());
        vendStart(vend);
    }
}



