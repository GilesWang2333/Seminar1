package com.company;

import java.util.List;

public class InsertionSort extends Sort {

    public InsertionSort(List<Integer> target) {
        super(target);
    }

    private void sortRecur(int[] array, int n) {
        if (n > 0) {
            //前n - 1有序
            sortRecur(array, n - 1);
            Insert(array, n);
        }
    }

    private void Insert(int[] array, int n) {
        int i = n - 1;
        int key = array[n];
        while (i >= 0 && key < array[i]) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = key;
    }

    public void sortIterative() {
        tag = "InsertionSort Iterative";
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j;
            for (j = i - 1; j >= 0 && data[j] > temp; j--) {
                data[j + 1] = data[j];
            }
            data[j + 1] = temp;
        }
    }

    public void sortRecursive() {
        tag = "InsertionSort Recursive";
        sortRecur(data,data.length - 1);
    }
}
