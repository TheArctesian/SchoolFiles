import java.util.ArrayList;

public class RecursionLibrary {

    /** Create a string of descending numbers
     *  Assume n is always an integer >= 1.
     *  Expected: descending(5) should return string "5...4...3...2...1"
     */

    public String descending(int n)
    {
        if (n >= 1) {
            return descending(n);
        } else {
            return 1;

    }

    /** Find the factorial of n
     *  Expected: fact(5) returns 120
     *  Expected: fact(3) returns 6
     *  Expected: facts(6) returns 720
     */

    public int fact(int n) {
        if (num >= 1)
            return num * fact(num - 1);
        else
            return 1;
    }

    /** Obtain the exponent of x^m
     *  Expected: exp(5, 5) returns 3125
     */

    public int exp(int x, int m)
    {
    if (power != 0){
        return (num * power(num, power - 1));
    }
    else {
        return 1;
        }
    }

    /** Find an integer in a list.
     * ArrayList<Integer> listOne= new ArrayList<>();
     * listOne.add(8); listOne.add(9); listOne.add(10); listOne.add(1);
     * Input: search(listOne, 6)
     * Expected return (boolean): false
     */

    public boolean search(ArrayList<Integer> elements, Integer elt)
    {
        if (
    }

    /** Summ all numbers in a list
     *  Expected: sum(new int[]{10,20,30}, 0) returns 60
     *  If list is empty, return 0
     */

    public int sum(int[] elements, int idx)
    {
        return -1;
    }

    /**
     * Find the greatest number in a list of numbers. Can assume will always start at index 0.

     *  listOne = new int[]{8,9,10, 1}
     * 
     * Input: greatest(listOne, 0)
     * Expected return (boolean): false
     **/


    public int greatest(int[] elements, int index)
    {
        return 0;
    }

    /** Evalute string, if it is a palindrom return true, else false
     *  isPalindrome("madam")→  true
     *  isPalindrome("racecar")→  true
     *  isPalindrome("step  on  no  pets")→  true
     *  isPalindrome("Java")→  false
     *  isPalindrome("byebye")→  false
     *  HINT: Remember that String is a char array.
     */
    public boolean isPalindrome(String word)
    {
        return false;
    }

    /**Return all digits that are even as one integer.
     *  evenDigits(8342116)    returns    8426
     *  evenDigits(40109)  returns    400
     *  evenDigits(8)  returns    8
     *  evenDigits(-163505)  returns    -60
     *  evenDigits(35179)  returns    0
     */

    public int evenDigits(int n)
    {
        return 0;
    }

    /**
     *  Basics of Programming Languages.
     *  Programming languages use symbols such as + and * to help programmers
     *  deal with expressions. In this problem we'll build a recursive
     *  expression evaluator.
     *  Expected result: evaluate( "((1*17)+(2*(3+(4*9))))" ) returns 95.
     */

    public int evaluate (String expr)
    {
        return -1;
    }
}
