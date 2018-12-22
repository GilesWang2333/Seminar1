package com.company;

import java.util.List;
import java.util.Random;

public class QuickSortRecursive extends Sort {

    int pivotMethod;

    public QuickSortRecursive(List<Integer> target) {
        super(target);
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = partition(array, left, right);
            sort(array, left, mid - 1);
            sort(array, mid + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotPos;
        switch (pivotMethod){
            case 0:
                Random random = new Random();
                pivotPos = random.nextInt(right - left) + left;
                swap(array, pivotPos, left);
                break;
            case 1:
                pivotPos = getMedianOf(array, left,left + (right - left) / 2, right);
                swap(array, pivotPos, left);
                break;
            default:
                break;
        }
        int pivot = array[left];
        while (right > left) {
            //先判断基准数和其后面的数
            while (pivot <= array[right] && left < right) {
                right--;
            }
            //当基准数大于array[right]，则填坑
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            //填坑array[right]
            while (pivot >= array[left] && left < right) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
                right--;
             }
        }
        array[left] = pivot;
        return left;
    }


    public void random_pivot() {
        pivotMethod = 0;
        tag = "QuickSort Recursive with random pivot";
        sort(data, 0, data.length - 1);
    }

    public void median_of_three() {
        pivotMethod = 1;
        tag = "QuickSort Recursive with pivot of median of 3";
        sort(data, 0, data.length - 1);
    }

    public void first_pivot() {
        pivotMethod = 2;
        tag = "QuickSort Recursive with pivot from first";
        sort(data, 0, data.length - 1);
    }

    private Integer getMedianOf(int[] array, Integer a, Integer b, Integer c) {
        if (array[a] >= array[b] && array[c] <= array[b]) return b;
        else if (array[b] >= array[a] && array[c] <= array[a]) return a;
        else return c;
    }


}

