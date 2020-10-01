package com.dwc.arithmetic.aha.chapter01.node02;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 11:55 2020/10/1
 * @description: 邻居好说话---冒泡排序
 * @question: 将 12 35 99 18 76 这5个数进行从大到小的排序，期望结果：99 76 35 18 12
 */
public class BubbleSort {
    public static void main(String[] args) {
        bubbleSort1();
        bubbleSort2();
    }

    /**
     * 总结：
     *  【总时间复杂度】
     *      O(N^2) N代表元素总个数
     *  【冒泡排序基本思想】
     *      每次比较两个相邻的元素，如果他们的顺序错误就把他们交换
     *  【冒泡排序缺点】
     *      时间复杂度高。冒泡排序的核心部分是双重嵌套循环，时间复杂度O(N^2)
     */


    private static void bubbleSort2() {
        //老王(5分)，小王(3分)，小明(5分)，小张(2分)，小李(8分
        Student[] arr = {
                Student.builder().name("老王").score(5).build(),
                Student.builder().name("小王").score(3).build(),
                Student.builder().name("小明").score(5).build(),
                Student.builder().name("小张").score(2).build(),
                Student.builder().name("小李").score(8).build(),
        };

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].getScore() < arr[j + 1].getScore()) {
                    Student temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    private static void bubbleSort1() {
        int[] arr = {12, 35, 99, 18, 76};
        //n次排序，只用跑n-1趟。外层循环控制趟数，内层将本趟最小数归位
        for (int i = 0; i < arr.length-1; i++) {
            //从最左边，比较相邻两数大小，将较小数变成右邻居，挨个比较。
            // 每跑一趟，就有一位本趟最小数归位至数组右边，下一趟无需再比较，arr.length-i
            // a[j]和a[j+1]比较，j无需也不能走到j=arr.length-1,此时j+1=arr.length,
            // 因此，本循环次数为arr.length-1-i
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("总计(arr.length-1)=4趟，每趟比较次数依次为(arr.length-1-i)={4,3,2,1},总循环次数即(4+3+2+1)=10");
        System.out.println("【时间复杂度为】O((1+N-1)(N-1)/2)=O(1/2N(N-1))=O(1/2N^2)=O(N^2)");
    }

}

@Data
@Builder
class Student{
   private String name;
   private Integer score;
}