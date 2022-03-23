package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 * [ 3,4,5,1,2 ]
 * [ 2,2,2,3,0,0,1,2 ]
 * [ 2,3,0,0,1 ]
 * [ 1,2 ]
 */
public class Ofe11 {

    public int minArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int mid = i + (j - i >>> 1);
            if (arr[mid] > arr[j]) {
                i = mid + 1;
            } else if (arr[mid] < arr[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        return arr[i];
    }
}
