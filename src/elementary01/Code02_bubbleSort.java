package elementary01;

/**
 * 冒泡排序
 * 对比0位和1位数字，小的放前面，
 */
public class Code02_bubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int k = 0; k < arr.length; k++){
            for (int i = 0; i < arr.length-1; i++) {
                int j = i + 1;
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printThisArr(int[] arr) {
        for (int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {3, 6, 3, 63, 2, 0, 1, 9};
        printThisArr(arr);
        bubbleSort(arr);
        printThisArr(arr);

    }

}
