class rec {
    public int mys(int n){
        if (n >0){
            System.out.println(n-3);
            return 3+mys(n-3);
        } else {
            return 3;
        }
    }
    public static void main(String[] args) {

        int s = mys(7);
        System.out.println(s);

    }
}
