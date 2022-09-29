public class Expo {

    public static void main(String[] args) {
        int num = 4;
        int power = 2;
        long exp = power(num, power);
        System.out.println(num + " to the " + power + " = " + exp);
    }
    public static long power(int num, int power)
    {
    if (power != 0){
        return (num * power(num, power - 1));
    }
    else {
      return 1;
    }
    }
}
