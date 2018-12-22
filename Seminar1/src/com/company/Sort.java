package com.company;

import java.util.List;

public class Sort {
    public String tag;
    public int[] data;

    public Sort(List<Integer> target) {
        data = new int[target.size()];
        for (int i = 0; i < target.size(); i++) data[i] = target.get(i);
    }

    protected void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void print() {
        for (int i: data) {
            System.out.print(i + " ");
        }
    }
}
