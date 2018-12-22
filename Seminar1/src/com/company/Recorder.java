package com.company;

import java.io.*;

public class Recorder {
    PrintStream printStream;

    int numberOfData;
    FileOutputStream[] listOfRecords;
    public Recorder() {
        try {
            listOfRecords = new FileOutputStream[10];
            listOfRecords[0] = new FileOutputStream("QuickSortIterativeRandom.txt",true);
            listOfRecords[1] = new FileOutputStream("QuickSortRecursiveRandom.txt",true);
            listOfRecords[2] = new FileOutputStream("QuickSortIterativeFirst.txt",true);
            listOfRecords[3] = new FileOutputStream("QuickSortRecursiveFirst.txt",true);
            listOfRecords[4] = new FileOutputStream("QuickSortIterativeMedian.txt",true);
            listOfRecords[5] = new FileOutputStream("QuickSortRecursiveMedian.txt", true);
            listOfRecords[6] = new FileOutputStream("MergeSortIterative.txt", true);
            listOfRecords[7] = new FileOutputStream("MergeSortRecursive.txt", true);
            listOfRecords[8] = new FileOutputStream("InsertionSortIterative.txt",true);
            listOfRecords[9] = new FileOutputStream("InsertionSortRecursive.txt", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setRecordTo(String tag) {
        switch (tag) {
            case "QuickSort iterative with random pivot":
                printStream = new PrintStream(listOfRecords[0]);
                break;
            case "QuickSort Recursive with random pivot":
                printStream = new PrintStream(listOfRecords[1]);
                break;
            case "QuickSort iterative with pivot from first":
                printStream = new PrintStream(listOfRecords[2]);
                break;
            case "QuickSort Recursive with pivot from first":
                printStream = new PrintStream(listOfRecords[3]);
                break;
            case "QuickSort iterative with pivot of median of 3":
                printStream = new PrintStream(listOfRecords[4]);
                break;
            case "QuickSort Recursive with pivot of median of 3":
                printStream = new PrintStream(listOfRecords[5]);
                break;
            case "MergeSort Iterative":
                printStream = new PrintStream(listOfRecords[6]);
                break;
            case "MergeSort Recursive":
                printStream = new PrintStream(listOfRecords[7]);
                break;
            case "InsertionSort Iterative":
                printStream = new PrintStream(listOfRecords[8]);
                break;
            case "InsertionSort Recursive":
                printStream = new PrintStream(listOfRecords[9]);
                break;
        }
    }

    public void record(String tag, Integer i ,long elapsedTime) {

    }

    public void recordAverageTime(String tag, long avgTime) {
//        printStream.println("The average running time of " + tag + " is " + (double)avgTime / 1000000000 + " x pow(10,9) ns." + " Data size: " + numberOfData + "\n");
    printStream.print((double)avgTime / 1000000000 + ", ");
    }


}
