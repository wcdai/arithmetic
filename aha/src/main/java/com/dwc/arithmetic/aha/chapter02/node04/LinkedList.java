package com.dwc.arithmetic.aha.chapter02.node04;

import lombok.Data;

import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 19:39 2020/10/2
 * @description: 链表
 * @question: 有一串已经从小到大排好序的数 2 3 5 8 9 10 18 26 32。现需要往这串数中插入 6 使其得
 * 到的新序列仍符合从小到大排列
 */
public class LinkedList {
    public static void main(String[] args) {
//        test01();
        test02();

    }

    /**
     * 这个方法和test01()没啥区别
     */
    private static void test02() {
        Node head = null;
        Node next = null;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //准备数据：2 3 5 8 9 10 18 26 32 组装链表
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            Node p = new Node();//java申请空间创建对象直接new
            p.setData(a);
            p.setNext(null);
            if (head == null) {
                head = p;
            } else {
                next.setNext(p);
            }
            next = p;
        }

        //待插入值：6
        int b = scanner.nextInt();
        Node t = head;
        while (t != null) {
            if (t.getNext() == null || t.getNext().getData() > b) {
                Node p = new Node();
                p.setData(b);
                p.setNext(t.getNext());
                t.setNext(p);
                break;
            }
            t = t.getNext();
        }

        //遍历链表取值
        t = head;
        while (t != null) {
            System.out.print(t.getData() + "  ");
            t = t.getNext();
        }


    }

    private static void test01() {
        Node head, p, q = null, t;
        int i, n, a;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        head = null;//头指针初始化为空
        //准备数据：2 3 5 8 9 10 18 26 32 组装链表
        for (i = 0; i < n; i++) {
            a = scanner.nextInt();
            p = new Node();//java申请空间创建对象直接new
            p.setData(a);
            p.setNext(null);
            if (head == null) {
                head = p;
            } else {
                q.setNext(p);
            }
            q = p;

        }
        //待插入值：6
        a = scanner.nextInt();
        t = head;

        //准备插入链表
        while (t != null) {
            if (t.getNext() == null||t.getNext().getData() > a) {
                p = new Node();
                p.setData(a);
                p.setNext(t.getNext());
                t.setNext(p);
                break;
            }
            t = t.getNext();
        }

        //遍历链表取值
        t = head;
        while (t != null) {
            System.out.print(t.getData() + "  ");
            t = t.getNext();
        }
    }

    /**
     * 总结：
     *   链表的建立和取值很蛮烦，必须有head节点，next节点，p节点，temp节点一大堆
     */

}

@Data
class Node {
    private int data;
    private Node next;
}
