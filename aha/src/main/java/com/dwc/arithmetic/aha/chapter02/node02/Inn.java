package com.dwc.arithmetic.aha.chapter02.node02;

import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 15:01 2020/10/2
 * @description: 解密回文——栈
 * @question: 校验一个字符串是否是回文
 */
public class Inn {
    public static void main(String[] args) {
        //准备数据
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int mid = str.length()/2;
        int top = -1;

        //栈初始化
        char[] chars = new char[str.length()];
        for (int i = 0; i < mid; i++) {
            chars[++top] =str.charAt(i);
        }
        int next = 0;
        if (str.length() % 2 == 0) {
            next = mid;
        } else {
            next = mid + 1;
        }

        //开始匹配
        for (int i = next; i < str.length(); i++) {
            if (str.charAt(i) != chars[top]) {
                break;
            }
            top--;
        }

        if (top == -1) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
