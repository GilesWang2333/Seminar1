package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static int NumberOfLoops = 30;

    static Recorder recorder;
    static Timer timer;
    public static void main(String[] args) {
	// write your code here
        timer = new Timer();
        recorder = new Recorder();
        List<Integer> list = new ArrayList<>();
        int numbersOfData[] = new int[10];
        for (int i = 100000, j = 0; i < 1000000 && j < numbersOfData.length; j++,i += 100000) {
            numbersOfData[j] = i;
        }

        try {
            Scanner scanner;
            for (int i: numbersOfData) {
                scanner = new Scanner(new File("AllNumbers.txt"));
                list.clear();
                recorder.numberOfData = i;
                for (int l = 0; l < i; l++) {
                    if (scanner.hasNextInt()) list.add(scanner.nextInt());
                }
                System.out.println("Data size: " + i);
                MergeSort(list);
                InsertionSort(list);
                QuickSort(list);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    private static void MergeSort(List<Integer> list) {
        System.out.println("MergeSort");

        long[] timeForRecursive = new long[NumberOfLoops];
        long[] timeForIterative = new long[NumberOfLoops];

        MergeSort mergeSort = null;
        recorder.setRecordTo("MergeSort Recursive");
        for (int i = 0; i < NumberOfLoops; i++) {
            mergeSort = new MergeSort(list);
            timer.start();
            mergeSort.sortRecursive();
            timer.stop();
            timeForRecursive[i] = timer.getElapsedTime();
            recorder.record(mergeSort.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(mergeSort.tag, getAverageTime(timeForRecursive));

        recorder.setRecordTo("MergeSort Iterative");

        for (int i = 0; i < NumberOfLoops; i++) {
            mergeSort = new MergeSort(list);
            timer.start();
            mergeSort.sortIterative();
            timer.stop();
            timeForIterative[i] = timer.getElapsedTime();
            recorder.record(mergeSort.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(mergeSort.tag, getAverageTime(timeForIterative));
    }

    private static void InsertionSort(List<Integer> list) {
        System.out.println("InsertionSort");

        long[] timeForRecursive = new long[NumberOfLoops];
        long[] timeForIterative = new long[NumberOfLoops];
        InsertionSort insertionSort = null;
        recorder.setRecordTo("InsertionSort Recursive");

        for (int i = 0; i < NumberOfLoops; i++) {
            insertionSort = new InsertionSort(list);
            timer.start();
            insertionSort.sortRecursive();
            timer.stop();
            timeForRecursive[i] = timer.getElapsedTime();
            recorder.record(insertionSort.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(insertionSort.tag, getAverageTime(timeForRecursive));

        recorder.setRecordTo("InsertionSort Iterative");

        for (int i = 0; i < NumberOfLoops; i++) {
            insertionSort = new InsertionSort(list);
            timer.start();
            insertionSort.sortIterative();
            timer.stop();
            timeForIterative[i] = timer.getElapsedTime();
            recorder.record(insertionSort.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(insertionSort.tag, getAverageTime(timeForIterative));



    }

    private static void QuickSort(List<Integer> list) {
        System.out.println("QuickSort");

        long[] timeForRecursiveF = new long[NumberOfLoops];
        long[] timeForRecursiveM = new long[NumberOfLoops];
        long[] timeForRecursiveR = new long[NumberOfLoops];
        long[] timeForIterativeF = new long[NumberOfLoops];
        long[] timeForIterativeM = new long[NumberOfLoops];
        long[] timeForIterativeR = new long[NumberOfLoops];
        Timer timer = new Timer();

        QuickSortIterative iterative = null;
        recorder.setRecordTo("QuickSort iterative with random pivot");
        for (int i = 0; i < NumberOfLoops; i++) {
            iterative = new QuickSortIterative(list);
            timer.start();
            iterative.random_pivot();
            timer.stop();
            timeForIterativeR[i] = timer.getElapsedTime();
            recorder.record(iterative.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(iterative.tag, getAverageTime(timeForIterativeR));

        recorder.setRecordTo("QuickSort iterative with pivot from first");
        for (int i = 0; i < NumberOfLoops; i++) {
            iterative = new QuickSortIterative(list);
            timer.start();
            iterative.first_pivot();
            timer.stop();
            timeForIterativeF[i] = timer.getElapsedTime();
            recorder.record(iterative.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(iterative.tag, getAverageTime(timeForIterativeF));

        recorder.setRecordTo("QuickSort iterative with pivot of median of 3");
        for (int i = 0; i < NumberOfLoops; i++) {
            iterative = new QuickSortIterative(list);
            timer.start();
            iterative.median_of_three();
            timer.stop();
            timeForIterativeM[i] = timer.getElapsedTime();
            recorder.record(iterative.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(iterative.tag, getAverageTime(timeForIterativeM));



        QuickSortRecursive recursive = null;

        recorder.setRecordTo("QuickSort Recursive with random pivot");
        for (int i = 0; i < NumberOfLoops; i++) {
            recursive = new QuickSortRecursive(list);
            timer.start();
            recursive.random_pivot();
            timer.stop();
            timeForRecursiveR[i] = timer.getElapsedTime();
            recorder.record(recursive.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(recursive.tag, getAverageTime(timeForRecursiveR));

        recorder.setRecordTo("QuickSort Recursive with pivot from first");
        for (int i = 0; i < NumberOfLoops; i++) {
            recursive = new QuickSortRecursive(list);
            timer.start();
            recursive.first_pivot();
            timer.stop();
            timeForRecursiveF[i] = timer.getElapsedTime();
            recorder.record(recursive.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(recursive.tag, getAverageTime(timeForRecursiveF));

        recorder.setRecordTo("QuickSort Recursive with pivot of median of 3");
        for (int i = 0; i < NumberOfLoops; i++) {
            recursive = new QuickSortRecursive(list);
            timer.start();
            recursive.median_of_three();
            timer.stop();
            timeForRecursiveM[i] = timer.getElapsedTime();
            recorder.record(recursive.tag, i, timer.getElapsedTime());
        }
        recorder.recordAverageTime(recursive.tag, getAverageTime(timeForRecursiveM));
    }

    private static long getAverageTime(long[] array) {
        long sum = 0;
        for (long i: array) {
            sum = sum + i;
        }
        sum /= NumberOfLoops;
        return sum;
    }


}
