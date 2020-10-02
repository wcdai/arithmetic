package com.dwc.arithmetic.aha.chapter02.node05;

/**
 * @author: wcdai
 * @date: 21:26 2020/10/2
 * @description: 模拟链表
 * @question:
 *      使用两个数组模拟链表结构
 * 原问题 ：
 *  有一串已经从小到大排好序的数 2 3 5 8 9 10 18 26 32。现需要往这串数中插入 6 使其得
 * 到的新序列仍符合从小到大排列
 */
public class SimulationList {

    public static void main(String[] args) {

        int[] data = new int[100];
        int[] source = {2, 3, 5, 8, 9, 10, 18, 26, 32};
        int[] right = new int[100];
        int count = source.length;
        for (int i = 1; i <= count; i++) {
            //data[0]不要了 从1开始
            data[i] = source[i-1];
            //right[i]为0代表第i个元素无下一节点
            right[i] = i + 1;
        }
        right[count] = 0;
        //新增的数：6
        int insert = 6;
        for (int i = 1; right[i] != 0; ) {

            if ( insert < data[right[i]]) {
                count++;
                data[count] = insert;
                int temp = right[i];
                right[i] = count;
                right[count] = temp;
                break;
            }
            i = right[i];
        }

        for (int i = 1; i != 0; ) {
            System.out.print(data[i]+"  ");
            i = right[i];

        }



    }

}
