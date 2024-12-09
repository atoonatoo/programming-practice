package com.practice.programmingpractice.algolism.sort;

import java.util.Arrays;

public class MergeSort {

    // 병합 정렬 함수
    public static void mergeSort(int[] array) {
        // 배열의 길이가 1 이하인 경우 정렬할 필요 없음
        if (array.length < 2) {
            return;
        }

        // 배열을 두 부분으로 나눔
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // 재귀적으로 두 부분을 정렬
        mergeSort(left);
        mergeSort(right);

        // 두 정렬된 배열을 병합
        merge(array, left, right);
    }

    // 두 배열을 병합하는 함수
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 왼쪽 배열과 오른쪽 배열을 비교하면서 작은 값을 array에 채워 넣음
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열에 남아있는 값이 있으면 넣어줌
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        // 오른쪽 배열에 남아있는 값이 있으면 넣어줌
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("원본 배열: " + Arrays.toString(array));

        mergeSort(array); // 병합 정렬 수행

        System.out.println("정렬된 배열: " + Arrays.toString(array));
    }
}
