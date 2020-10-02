package com.dwc.arithmetic.aha.chapter01.node04;



/**
 * @author: wcdai
 * @date: 10:15 2020/10/2
 * @description: 小哼买书
 * @question: 小哼的学校要建立一个图书角，老师派小哼去找一些同学做调查，看看同学们都喜欢读
 * 哪些书。小哼让每个同学写出一个自己最想读的书的 ISBN 号（你知道吗？每本书都有唯一
 * 的 ISBN 号，不信的话你去找本书翻到背面看看）。当然有一些好书会有很多同学都喜欢，
 * 这样就会收集到很多重复的 ISBN 号。小哼需要去掉其中重复的 ISBN 号，即每个 ISBN 号只
 * 保留一个，也就说同样的书只买一本（学校真是够抠门的）。然后再把这些 ISBN 号从小到
 * 大排序，小哼将按照排序好的 ISBN 号去书店买书。请你协助小哼完成“去重”与“排序”
 * 的工作。
 * 输入有 2 行，第 1 行为一个正整数，表示有 n 个同学参与调查（n≤100）。第 2 行有 n
 * 个用空格隔开的正整数，为每本图书的 ISBN 号（假设图书的 ISBN 号在 1~1000 之间）。
 * 输出也是 2 行，第 1 行为一个正整数 k，表示需要买多少本书。第 2 行为 k 个用空格隔
 * 开的正整数，为从小到大已排好序的需要购买的图书的 ISBN 号。
 * <p>
 * 例如输入：
 * 10
 * 20 40 32 67 40 20 89 300 400 15
 * 则输出：
 * 8
 * 15 20 32 40 67 89 300 400
 */
public class BuyBooks {
    static int[] arr = {20, 40, 32, 67, 40, 20, 89, 300, 400, 15};
    public static void main(String[] args) {

//        bucketSort();
        bubbleSort();
        quickSort(0,arr.length-1);
        //打印出结果
        printBooks();

    }

    /**
     * 快排
     */
    private static void quickSort(int left,int right) {

        //过滤二分之后只有一个元素或无元素的情况
        if (left >= right) {
            return;
        }

        //定义基准点为每轮的最左元素
        int baseValue = arr[left];
        //定义左右指针起点
        int l = left;
        int r = right;


        while (l < r) {
            while (arr[r] > baseValue && l<r) {
                r--;
            }

            while (arr[l] <= baseValue && l<r) {
                l++;
            }

            int tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
        }

        //基准点归位
        arr[left] = arr[l];
        arr[l] = baseValue;

        //以基准点位置（l或r），一分为二，继续处理左边（left至l）的数
        quickSort(left,l-1);
        //以基准点位置（l或r），一分为二，继续处理右边（r+1至right）的数
        quickSort(r+1,right);

    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }


    /**
     * 桶排序
     */
    private static void bucketSort() {
        int num = 10;

        int[] isbn = new int[1000];

        for (int i = 0; i < arr.length; i++) {
            isbn[arr[i] - 1]++;
        }
        int count = 0;
        String isbnStr = "";
        for (int i = 0; i < isbn.length; i++) {
            if (isbn[i] > 0) {
                count++;
                isbnStr += (i + 1) + "  ";
            }
        }
        System.out.println("count = " + count);
        System.out.println("isbnStr = " + isbnStr);
    }


    private static void printBooks() {
        int count = 1;
        String str = "";
        for (int i = 0; i < arr.length-1; i++) {

            if (arr[i] != arr[i + 1]) {
                count++;
                str += arr[i]+"  ";
            }

        }
        str += arr[arr.length-1]+"  ";
        System.out.println("count = " + count);
        System.out.println(str);
    }

    /**
     * 总结:
     *      用快排就对了
     */
}
