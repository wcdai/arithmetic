package com.dwc.arithmetic.aha.chapter02.node01;



/**
 * @author: wcdai
 * @date: 12:12 2020/10/2
 * @description: 解密 QQ 号——队列
 * @question:
 *   新学期开始了，小哈是小哼的新同桌（小哈是个小美女哦~），小哼向小哈询问 QQ 号，
 * 小哈当然不会直接告诉小哼啦，原因嘛你懂的。所以小哈给了小哼一串加密过的数字，同时
 * 小哈也告诉了小哼解密规则。规则是这样的：首先将第 1 个数删除，紧接着将第 2 个数放到
 * 这串数的末尾，再将第 3 个数删除并将第 4 个数放到这串数的末尾，再将第 5 个数删除……
 * 直到剩下最后一个数，将最后一个数也删除。按照刚才删除的顺序，把这些删除的数连在一
 * 起就是小哈的 QQ 啦。现在你来帮帮小哼吧。小哈给小哼加密过的一串数是“6 3 1 7 5 8 9 2 4”。
 */
public class MyQueue {
    public static void main(String[] args) {

        queue01();

    }

    private static void queue01() {
        int[] pp = new int[100];
        int[] source =  new int[]{6, 3, 1, 7, 5, 8, 9, 2, 4} ;

        for (int i = 0; i < source.length; i++) {
            pp[i] = source[i];
        }


        int head = 0;
        int tail = 9;
        while (head < tail) {
            //打印队首，队首出队
            System.out.print(pp[head]+"  ");
            head++;

            //新队首移至队尾
            pp[tail] = pp[head];
            head++;
            tail++;

        }
    }
}

