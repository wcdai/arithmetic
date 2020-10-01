package com.dwc.arithmetic.aha.chapter01.node01;

import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 10:52 2020/10/1
 * @description: 最快最简单的排序-简单桶排序
 * @question:
 *  小哼的班上只有5个同学，一次考试中，这5个同学分别考了5分、3分、5分、2分和8分，总分（10分）
 *  接下来将分数进行从大到小进行排序，排序后是 8 5 5 3 2
 */
public class BucketSort {
    public static void main(String[] args) {
        //11个桶 存储 0-10分
        int[] bucket = new int[11];
        //5名同学
        int num = 5;

        //循环输入同学的分数，忽略异常处理
        Scanner scanner = new Scanner(System.in);
        //【时间复杂度】O(M)
        for (int i = 0; i < num; i++) {
            int score = scanner.nextInt();
            //命中，桶中的🚩加一，以桶中🚩的数量代表这个分数的人数
            bucket[score]++;
        }

        //倒序输出同学们的分数
        System.out.println("================同学们的分数为====================");
        //【时间复杂度】O(N+M)
        for (int score = bucket.length-1; score > 0; score--) {
            //number代表当然分数有多少人
            int number = bucket[score];
            for (int counter = 0; counter < number; counter++) {
                System.out.print(score+" ");
            }
        }




    }

    /**
     * 总结：
     * 【总时间复杂度】
     *      O(2N+M) N代表学生数，M代表总分数范围
     * 【简单桶排序基本思想】
     *      根据元素的可出现的数值大小，建立对应数量的桶，桶的位置即代表元素的大小，每个桶大小代表元素个数，初始化每个桶大小都为0
     *      排序：
     *          1.入桶
     *              将元素存入桶，方法为：桶[元素大小]=桶[元素大小]+1,这里桶可以理解为数组，
     *              数组可以通过下标,随机访问数组中的元素.复杂度---O(1)，根据这一特点可以快速将元素入桶
     *          2.入桶了即排好序了，按桶位置顺序倒序或顺序输出桶位置进行,每个桶位置输出次数==桶大小（桶大小等于0即不输出）
     *
     * 【简单桶排序缺点】
     *      1.本题中只能对分数进行排序，不能对同学进行排序，输出人名（比如老王(5分)，小王(3分)，小明(5分)，小张(2分)，小李(8分)）
     *      2.浪费空间，若分数范围过大，比如0-7500000分，需要创建7500001个桶(数组大小)，但同学仍是5名
     *      3.对小数的排序会比较麻烦
     */


}
