package study.dbna.binarysearch;

public class BinarySearch {

    private static int recursiveCount = 0;
    private static int loopCount = 0;

    public static void main(String[] args) {
        int size = 10000000;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int target = 3;

        // 재귀 호출 이진 탐색
        long start = System.nanoTime();
        int recursiveBinarySearchIdx = recursiveBinarySearch(arr, target, 0, arr.length - 1);
        long end = System.nanoTime();
        System.out.println("===== 재귀 호출 이진 탐색 결과 =====");
        System.out.println("has data : " + (recursiveBinarySearchIdx != -1));
        System.out.println("target index : " + recursiveBinarySearchIdx);
        System.out.println("recursive count : " + recursiveCount);
        System.out.println("run time (nano-seconds) : " + (end - start) + "ns");

        System.out.println();

        // 반복문 이진 탐색
        start = System.nanoTime();
        int loopBinarySearchIdx = loopBinarySearch(arr, target);
        end = System.nanoTime();
        System.out.println("===== 반복문 이진 탐색 결과 =====");
        System.out.println("has data : " + (loopBinarySearchIdx != -1));
        System.out.println("target index : " + loopBinarySearchIdx);
        System.out.println("loop count : " + loopCount);
        System.out.println("run time (nano-seconds) : " + (end - start) + "ns");
    }

    // 반복문 이진 탐색
    private static int loopBinarySearch(int[] arr, int target) {
        int startIdx = 0;
        int endIdx = arr.length - 1;

        while (startIdx <= endIdx) {
            loopCount++;
            int midIdx = (startIdx + endIdx) / 2;

            if (target == arr[midIdx]) {
                return midIdx;
            } else if (target < arr[midIdx]) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }

        return -1;
    }

    // 재귀 호출 이진 탐색
    private static int recursiveBinarySearch(int[] arr, int target, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return -1;
        }

        recursiveCount++;
        int midIdx = (startIdx + endIdx) / 2;

        if (arr[midIdx] == target) {
            return midIdx;
        } else if (arr[midIdx] > target) {
            return recursiveBinarySearch(arr, target, startIdx, midIdx - 1);
        } else {
            return recursiveBinarySearch(arr, target, midIdx + 1, endIdx);
        }
    }
}
