import java.util.Arrays;

class Lin {
    int search(int arr[], int num){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num)
                return i;
        }
        return -1;
    }

    public static void main(String args[]){
        Lin l = new Lin();
        int a[] = {3,2,1,4,5};
        System.out.println(Arrays.toString(a));
        int num = 4;
        int res = l.search(a, num);
        if (res == -1)
            System.out.print("Element is not present in array");
        System.out.println(res);
    }

}
