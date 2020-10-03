package com.dwc.arithmetic.aha.chapter04.node02;

import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 13:48 2020/10/3
 * @description: 解救小哈
 * @question:
 * 从迷宫中救出小哈
 */
public class Labyrinth {

    static int min = 99999;//最少步数
    static int p;
    static int q;
    static int m;
    static int n;
    static int[][] a;
    static int[][] book;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //读入n,m n为行m为列
        System.out.println("请输入迷宫行数");
        n = sc.nextInt();
        System.out.println("请输入迷宫列数");
        m = sc.nextInt();

        //读入迷宫，
        a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println("第" + i + "行");
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < a.length; i++) {
            System.out.println("第" + i + "行");
            for (int j = 1; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }

        //从起点开始搜索
        System.out.println("请输入起点坐标");
        int startx = sc.nextInt();
        int starty = sc.nextInt();
        System.out.println("请输入终点坐标");
        p = sc.nextInt();
        q = sc.nextInt();


        //标记数组
        book = new int[n + 1][m + 1];
        book[startx][starty] = 1; //标记起点已经在路上，防止重复走


        dfs(startx, starty, 0);
        System.out.println("最短步数为："+min);

    }

    private static void dfs(int x, int y, int step) {
        //定义四种走法，按顺时针
        int[][] next = {
                {0, 1},//向右
                {1, 0},//向下
                {0, -1},//向左
                {-1, 0}//向上
        };

        //到终点了
        if (x == p && y == q) {
            //更新最小值
            if (step < min) {
                min = step;
                return;
            }
        }

        int tx, ty;

        //枚举4种走法
        for (int i = 0; i < next.length; i++) {
            //计算下一个点的坐标
            tx = x + next[i][0];
            ty = y + next[i][1];
            if (tx < 1 || tx > n || ty < 1 || ty > m) {
                continue;
            }
            //判断该点是否为障碍物或者已经在路径中
            if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1;//标记这个点已经走过
                dfs(tx, ty, step + 1);//开始尝试下一个点
                book[tx][ty] = 0;//尝试结束，取消这个点的标记
            }
        }


    }

    /**
     * 总结：
     * 【深度优先算法基本思想】
     *    void dfs(int step){
     *        判断边界
     *        尝试每一种可能 for(...){
     *            继续下一步 dfs(step+1);
     *        }
     *    }
     */
}
