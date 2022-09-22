import java.util.Arrays;

class Bin {

  int search(int arr[], int num) {
    int low = 0;
    int high = arr.length - 1;
    Arrays.sort(arr);
    while (high - low > 1) {
      int mid = (high + low) / 2;
      if (arr[mid] < num) {
        low = mid + 1;
      } else {
        high = mid;
      }
      if (arr[low] == num) return low; else if (arr[high] == num) return high;
    }
    return -1;
  }

  public static void main(String args[]) {
    Bin l = new Bin();
    int a[] = { 3, 2, 1, 4, 5 };

    System.out.println(Arrays.toString(a));
    int num = 4;
    int res = l.search(a, num);
    if (res == -1) System.out.print("Element is not present in array");
    System.out.println(res);
  }
}
