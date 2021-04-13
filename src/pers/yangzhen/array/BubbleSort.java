package pers.yangzhen.array;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{0, 12, -9, 123, 121, 90, 65, 1, 32, 19};
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}