package elementary01;

/**
 * @PROJECT: 插入排序
 * @DESCRIPTION: 在 0--m 保证有序（m<=n）
 * 在 0--1， 0--2， 0--3....0--n 保证有序
 * @USER: Elizabeth
 * @DATE: 2022/12/16 21:08
 */
public class Code03_insertSort {

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            for (int i = end; i > 0; i--) {
                if(arr[i] < arr[i-1]){
                    swap(arr, i, i-1);
                }else {
                    break;
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
        insertSort1(arr);
        printThisArr(arr);

    }
}
