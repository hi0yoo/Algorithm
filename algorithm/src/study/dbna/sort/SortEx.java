package study.dbna.sort;

import java.util.Arrays;

public class SortEx {
    public static void main(String[] args) {
        int size = 50000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }

        long startSelectSort = System.currentTimeMillis();
        int[] selectSortedArr = selectSort(arr);
        long endSelectSort = System.currentTimeMillis();
        System.out.println("선택 정렬 수행 시간 : " + (endSelectSort - startSelectSort)/1000.0 + "ms");
        printSortedArr(size, selectSortedArr);

        long startInsertSort = System.currentTimeMillis();
        int[] insertSortedArr = insertSort(arr);
        long endInsertSort = System.currentTimeMillis();
        System.out.println("삽입 정렬 수행 시간 : " + (endInsertSort - startInsertSort)/1000.0 + "ms");
        printSortedArr(size, insertSortedArr);

        long startQuickSort = System.currentTimeMillis();
        int[] quickSortedArr = quickSort(arr);
        long endQuickSort = System.currentTimeMillis();
        System.out.println("퀵 정렬 수행 시간 : " + (endQuickSort - startQuickSort)/1000.0 + "ms");
        printSortedArr(size, quickSortedArr);

        long startCoefficientSort = System.currentTimeMillis();
        int[] coefficientSortedArr = coefficientSort(arr);
        long endCoefficientSort = System.currentTimeMillis();
        System.out.println("계수 정렬 수행 시간 : " + (endCoefficientSort - startCoefficientSort)/1000.0 + "ms");
        printSortedArr(size, coefficientSortedArr);

        int[] clone = arr.clone();
        long startBasicSort = System.currentTimeMillis();
        Arrays.sort(clone);
        long endBasicSort = System.currentTimeMillis();
        System.out.println("자바 Arrays.sort 수행 시간 : " + (endBasicSort - startBasicSort)/1000.0 + "ms");
        printSortedArr(size, clone);

        System.out.println();
        System.out.println("선택 정렬 결과 == 삽입 정렬 결과 : " + Arrays.equals(selectSortedArr, insertSortedArr));
        System.out.println("선택 정렬 결과 == 퀵 정렬 결과 : " + Arrays.equals(selectSortedArr, quickSortedArr));
        System.out.println("선택 정렬 결과 == 계수 정렬 결과 : " + Arrays.equals(selectSortedArr, coefficientSortedArr));
        System.out.println("선택 정렬 결과 == Arrays.sort 정렬 결과 : " + Arrays.equals(selectSortedArr, clone));
        System.out.println("삽입 정렬 결과 == 퀵 정렬 결과 : " + Arrays.equals(insertSortedArr, quickSortedArr));
        System.out.println("삽입 정렬 결과 == 계수 정렬 결과 : " + Arrays.equals(insertSortedArr, coefficientSortedArr));
        System.out.println("삽입 정렬 결과 == Arrays.sort 정렬 결과 : " + Arrays.equals(insertSortedArr, clone));
        System.out.println("퀵 정렬 결과 == 계수 정렬 결과 : " + Arrays.equals(quickSortedArr, coefficientSortedArr));
        System.out.println("퀵 정렬 결과 == Arrays.sort 정렬 결과 : " + Arrays.equals(quickSortedArr, clone));
        System.out.println("계수 정렬 결과 == Arrays.sort 정렬 결과 : " + Arrays.equals(coefficientSortedArr, clone));
    }

    private static void printSortedArr(int size, int[] coefficientSortedArr) {
        if (size <= 10000) {
            System.out.println(Arrays.toString(coefficientSortedArr));
        }
    }

    // 계수 정렬
    private static int[] coefficientSort(int[] target) {
        int min = Arrays.stream(target).min().orElseThrow();
        int max = Arrays.stream(target).max().orElseThrow();
        // 기존 배열의 각 데이터가 몇번 등장했는지 기록할 배열 선언
        int[] arr = new int[max - min + 1];
        // 정렬 결과를 담을 배열 선언
        int[] result = new int[target.length];

        // 데이터 등장 횟수 기록
        for (int i = 0; i < target.length; i++) {
            arr[target[i] - min]++;
        }

        // 기록한 결과를 이용하여 result 배열에 정렬 결과 기록
        int arrPointer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    result[arrPointer++] = i + min;
                }
            }
        }

        return result;
    }

    // 퀵 정렬
    private static int[] quickSort(int[] target) {
        int[] arr = target.clone();
        int endIdx = arr.length - 1;
        int startIdx = 0;
        quickSortAlgorithm(arr, startIdx, endIdx);
        return arr;
    }
    private static void quickSortAlgorithm(int[] arr, int startIdx, int endIdx) {
        // 종료 조건
        if (startIdx >= endIdx) {
            return;
        }

        // 피벗 설정
        int pivot = startIdx;
        // 탐색 포인터 설정
        int i = startIdx + 1;
        int j = endIdx;

        while (i <= j) {
            // 피벗보다 큰 데이터를 찾을 때 까지 i 포인터를 증가시킨다.
            while (i <= endIdx && arr[i] <= arr[pivot]) {
                i++;
            }
            // 피벗보다 작은 데이터를 찾을 때 까지 j 포인터를 감소시킨다.
            // 작은 수를 찾지 못한다면 j = pivot 을 가리킨다.
            while (j > startIdx && arr[j] >= arr[pivot]) {
                j--;
            }

            // i, j가 엇갈렸다면 피벗과 작은 데이터(arr[j]) 교체
            if (i > j) {
                int tmp = arr[pivot];
                arr[pivot] = arr[j];
                arr[j] = tmp;

            } else {
                // 엇갈리지 않았다면 큰 데이터와 작은 데이터 교체
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        // 반복문 탈출하면 i > j, j = 피벗
        quickSortAlgorithm(arr, startIdx, j - 1);
        quickSortAlgorithm(arr, j + 1, endIdx);
    }

    // 삽입 정렬
    private static int[] insertSort(int[] target) {
        int[] arr = target.clone();
        int size = arr.length;

        for (int b = 1; b < size; b++) {
            int tmp = arr[b]; // 현재 위치 원소값 저장
            int a = b - 1;

            // b 포인터의 값이 a 포인터의 값보다 클 때까지 수행
            while (a >= 0 && arr[a] > tmp) {
                // a 포인터의 값을 한 칸 뒤로 민다.
                arr[a + 1] = arr[a];
                a--;
            } // b 포인터의 값이 a 포인트 값 보다 크면 반복 종료.
            // a 포인터 값 < b 포인터 값 상태가 된다.
            // 따라서 b 포인터 값을 (a 포인터 + 1)의 위치에 삽입한다.
            arr[a + 1] = tmp;
        }
        return arr;
    }

    // 선택 정렬
    private static int[] selectSort(int[] target) {
        int[] arr = target.clone();
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIdx = getMinIdx(arr, i);
            swap(arr, i, minIdx);
        }
        return arr;
    }

    private static int getMinIdx(int[] target, int startIdx) {
        int size = target.length;
        int idx = startIdx;
        int min = target[idx];
        for (int i = startIdx + 1; i < size; i++) {
            if (target[i] < min) {
                min = target[i];
                idx = i;
            }
        }
        return idx;
    }

    private static void swap(int[] arr, int srcIdx, int desIdx) {
        int tmp = arr[srcIdx];
        arr[srcIdx] = arr[desIdx];
        arr[desIdx] = tmp;
    }
}
