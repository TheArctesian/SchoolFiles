public class eval {
    /**
     *  Basics of Programming Languages.
     *  Programming languages use symbols such as + and * to help programmers
     *  deal with expressions. In this problem we'll build a recursive
     *  expression evaluator.
     *  Expected result: evaluate( "((1*17)+(2*(3+(4*9))))" ) returns 95.
     */
    public static int evaluate(String expr)
    {
        String[] arrOfStr = expr.split("(");
        for(String a : arrOfStr){
            System.out.println(a);
        }
        return 1;
    }
    public static void main(String[] args) {
        String expr = "((1*17)+(2*(3+(4*9))))";
        int i = evaluate(expr);
    }

}
