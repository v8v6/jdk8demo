package com.sc.cd.datastruct.algorithm;

public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 16, 22, 24, 27, 54, 65, 75, 80};
        System.out.println(search(numbers, 27));
    }

    /**
     * 二分查找
     * @param numbers
     * @param key
     * @return
     */
    private static int search(int[] numbers, int key) {
        int min = 0, max = numbers.length, mid = 0;

        while (min <= max) {
            mid = max / 2;
            if (key < numbers[mid]) {
                max = mid - 1;
            } else if (key > numbers[mid]) {
                min = max + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
