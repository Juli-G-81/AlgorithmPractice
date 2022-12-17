package elementary01;

/**
 * 选择排序
 * 从0 -- arr.length-1 当中选择最小的，放于0位置（和最小值所在的位置进行值互换）
 * 从1 -- arr.length-1 当中选择最小的，放于1位置
 */
public class Code01_selectSort {
    public static void selectedSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
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
        selectedSort(arr);
        printThisArr(arr);
    }
}
