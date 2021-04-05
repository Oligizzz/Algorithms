package com.oligizzz.algorithms.Sort.utils;

import java.io.Serializable;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/25
 * @Modify By:
 */
public class BaseSort implements Sortab, Serializable {

        public static int [] array_Test = {12,85,98,32,54,78,1,0,32,69,24,894,2,9,456,37,91,43,20,80,70,147,369,45812,302};
        @Override
        public void sort(int[] array) {

        }

        @Override
        public boolean less(int a, int b) {
                return (a-b)<0;
        }

        @Override
        public boolean isSorted(int[] array) {
                if(array.length == 0 || array.length ==1){
                        return true;
                }
                for(int i = 1 ; i < array.length ; i++){
                        if(array[i]<array[i-1]){
                                return false;
                        }
                }
                return true;
        }

        @Override
        public void swap(int[] array, int index1, int index2) {
                int temp = array[index1];
                array[index1] = array[index2];
                array[index2] = temp;

        }
}
