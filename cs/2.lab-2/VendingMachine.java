import java.util.ArrayList;

public class VendingMachine {
    ArrayList<Espresso> EspStock;
    ArrayList<Cappuccino> CapStock;
    ArrayList<Latte> LatStock;

    public void vendInit(){

    }
    public String getVendStock() {
        int EspressoStock = EspStock.size();
        int CappuccinoStock = CapStock.size();
        int LatteStock = LatStock.size();

        return "The vending Machine contains: \n" +
                EspressoStock + "Espressos, \n" +
                CappuccinoStock + "Cappuccinos, \n" +
                LatteStock + "Lattes";
    }
}

  