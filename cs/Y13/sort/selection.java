import java.util.Arrays;
class Selection { 
    int[] sort(int arr[]){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String args[]){
        Selection sel = new Selection();
        int a[] = {3,2,1,4,5};
        System.out.println(Arrays.toString(a));
        int out[] = sel.sort(a);
        System.out.println(Arrays.toString(out));
    }

}

