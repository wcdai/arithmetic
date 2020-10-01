package com.dwc.arithmetic.aha.chapter01.node03;

import java.util.Arrays;

/**
 * @author: wcdai
 * @date: 14:26 2020/10/1
 * @description: 最常用的排序--快速排序
 * @question: 对6 1 2 7 9 3 4 5 10 8 这10个数进行排序
 */
public class QuickSort {
       static int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 6, 8};
       static int count = 0;
    public static void main(String[] args) {
        quickSort(0, arr.length - 1);
        System.out.println("结束");
        System.out.println(Arrays.toString(arr));
        System.out.println("count = " + count);
    }

    private static void quickSort(int left, int right) {
        count++;
        //此处过滤left=right是因为二分之后，分到左边或右边只有最后一个元素,没有比较的意义
        //此处过滤left>right是因为二分之后，分到左边只有最后一个元素,右边没有元素，会出现left>right的情况
        if (left >=right) {
            return;
        }


        //left和right控制指针的范围
        //l为左指针，向右移动
        int l = left;
        //r为右指针，向左移动
        int r = right;
        int baseValue = arr[left];
        //4.两数重合了推出循环，开始和基准点进行交换
        while (l < r) {
            //1.先从右到左，移动右指针，直到指针所指的数<基准点
            if (arr[r] > baseValue) {
                r--;
            } else {
                //2.右边找到比基准点小的后，在从左往右移动左指针，直到指针所指的数>基准点
                if (arr[l] <= baseValue) { //基准数取最左边，此处必须得<=，取右边可以<
                    l++;
                } else {
                    //3.左边找到比基准点大的后再和右边的对换
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                }
            }

        }
        //先从左忘右移动也行
        /*while (l < r) {

            if (arr[l] <= baseValue) {
                l++;
            } else {
                if (arr[r] >= baseValue) {
                    r--;
                } else {
                    //2.右边找到比基准点小的后，在从左往右移动左指针，直到指针所指的数>基准点
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                }
                //3.左边找到比基准点大的后再和右边的对换

            }

            //1.先从右到左，移动右指针，直到指针所指的数<基准点


        }*/

        //l和r重合，将arr[l](或arr[r])和基准点交换,第一个数归位
        int tem = arr[l];
        arr[l] = baseValue;
        arr[left] = tem;

        //继续处理左边的，左边的二分之后还要继续这样处理，因此，此处递归
        quickSort(left, l - 1);
        //继续处理右边的，递归
        quickSort(r + 1,right);

    }

    /**
     * 总结：
     *  【总时间复杂度】
     *      平均时间复杂度为O(NlogN) 简单测试了下，大概从4个元素开始，快排时间复杂度总比冒泡排序小
     *  【快速排序排序基本思想】
     *     1.定基准数
     *        本案例每次都以最左边的数为基准数，每一轮循环有两个目的,
     *        1是将基准数归位，归位的原理就是，假设是从小到大排序，那么如果某个位置左边的数都<=基准数，右边的数都>基准数，
     *         那么此处就是基准数，即完成归位
     *        2是顺手排个序，这是比冒泡排序高明点的地方，对整个数组进行分区，假设是从小到大排序，那么以基准数做比较，从左到右数据可分为小于基准数区，
     *        等于基准数区，大于基准数区，那么在移动左右指针找基准数归位位置时，可根据这一特定将大于等于基准数的数和小于基准数的数交换个位置
     *     2.分区
     *       如1.2
     *     3.二分
     *      基准数归位后，以基准数为分割线，将数据进行二分，本案例然后再以各自最左边的数为基准数，进行基准数归位的移形换位处理，如此反复
     *
     *  【快速排序排序缺点】
     *      实现起来稍微有点麻烦
     */

}
