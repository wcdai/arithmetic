package com.dwc.arithmetic.aha.chapter04.node03;

import lombok.Builder;
import lombok.Data;

import java.util.Scanner;

/**
 * @author: wcdai
 * @date: 20:14 2020/10/3
 * @description: 层层递进--广度优先算法
 * @question: 从迷宫中救出小哈
 */
public class BreadthFirstSearch {


    static int p;
    static int q;
    static int m;
    static int n;
    static int[][] a;
    static int[][] book;
    static int flag;
    static int tx;
    static int ty;

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

        Note[] que = new Note[2501];//地图不超过50*50
        //定义一个用于表示走的方向的数组
        int[][] next = {
                {0, 1},//向右
                {1, 0},//向下
                {0, -1},//向左
                {-1, 0},//向上
        };

        //队列初始化
        int head = 1;
        int tail = 1;
        //往队列插入迷宫入口坐标
        Note note = Note.builder()
                .x(startx)
                .y(starty)
                .s(0)
                .f(0)
                .build();
        que[tail] = note;
        tail++;
        book[startx][starty] = 1;
        flag = 0;//用来记录是否达到目标点 0否1是
        //当队列不为空时循环队列
        while (head < tail) {
            //枚举4个方向
            for (int i = 0; i < next.length; i++) {
                //计算下一个点的坐标
                tx = que[head].getX() + next[i][0];
                ty = que[head].getY() + next[i][1];

                if (tx < 1 || tx > n || ty < 1 || ty > m) {
                    continue;
                }
                //标记过的点或障碍点不会进入队列
                if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                    //标记这个点为已经走过
                    book[tx][ty] = 1;
                    Note n = Note.builder()
                            .x(tx)
                            .y(ty)
                            .s(que[head].getS() + 1)
                            .build();
                    que[tail] = n;
                    tail++;
                }
                //如果到目标点了，停止扩展，任务结束，退出循环
                if (tx == p && ty == q) {
                    flag = 1;
                    break;
                }

            }
            if (flag == 1) {
                break;
            }
            head++;

        }

        System.out.println(que[tail-1].getS());
    }
}

@Data
@Builder
class Note {
   private int x;//行，不是横坐标
   private int y;//列，不是纵坐标
   private int f;//父坐标，本题暂时无用
   private int s;//步数
}