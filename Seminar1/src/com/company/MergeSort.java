package com.company;

import java.util.List;

public class MergeSort extends Sort {

    int[] result;

    public MergeSort(List<Integer> target) {
        super(target);
        result = new int[data.length];
    }

    private void sortRecur(int[] data, int[] orderedData, int left, int right) {
        if (left >= right) return;
        int len = right - left;
        int mid = len / 2 + left;
        int leftL = left;
        int rightL = mid;
        int leftR = mid + 1;
        int rightR = right;
        //左侧有序
        sortRecur(data, orderedData, leftL, rightL);
        //右侧有序
        sortRecur(data, orderedData, leftR, rightR);
        //合并左右侧
        merge(data, orderedData, left, mid, right);

    }


    private void merge(int[] data, int[] orderedData, int left, int mid, int right) {
        int leftL = left;
        int rightL = mid;
        int leftR = mid + 1;
        int rightR = right;
        int i = left;
        while (leftL <= rightL && leftR <= rightR)
            orderedData[i++] = data[leftL] < data[leftR] ? data[leftL++] : data[leftR++];
        while (leftL <= rightL) {
            orderedData[i++] = data[leftL++];
        }
        while (leftR <= rightR)
            orderedData[i++] = data[leftR++];
        for (i = left; i <= right; i++)
            data[i] = orderedData[i];
    }

    public void sortRecursive() {
        tag = "MergeSort Recursive";
        sortRecur(data, result, 0, data.length - 1);
    }

    public void sortIterative() {
        tag = "MergeSort Iterative";
        //i为每一步的距离
        for (int i = 2; i < data.length * 2; i *= 2) {
            //根据步距分块整理
            for (int j = 0; j < (data.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= data.length ? (data.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= data.length ? (data.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (data[l] < data[m]) {
                        result[start++] = data[l++];
                    } else {
                        result[start++] = data[m++];
                    }
                }
                while (l < mid)
                    result[start++] = data[l++];
                while (m <= right) {
                    result[start++] = data[m++];
                }
                System.arraycopy(result,left,data,left,right - left + 1);
            }
        }
    }
}
