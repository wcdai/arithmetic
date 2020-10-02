package com.dwc.arithmetic.aha.chapter02.node03;

import lombok.Data;

/**
 * @author: wcdai
 * @date: 15:30 2020/10/2
 * @description: 纸牌游戏——小猫钓鱼
 * @question:
 *   星期天小哼和小哈约在一起玩桌游，他们正在玩一个非常古怪的扑克游戏——“小猫钓
 * 鱼”。游戏的规则是这样的：将一副扑克牌平均分成两份，每人拿一份。小哼先拿出手中的
 * 第一张扑克牌放在桌上，然后小哈也拿出手中的第一张扑克牌，并放在小哼刚打出的扑克牌
 * 的上面，就像这样两人交替出牌。出牌时，如果某人打出的牌与桌上某张牌的牌面相同，即
 * 可将两张相同的牌及其中间所夹的牌全部取走，并依次放到自己手中牌的末尾。当任意一人
 * 手中的牌全部出完时，游戏结束，对手获胜。
 * 假如游戏开始时，小哼手中有 6 张牌，顺序为 2 4 1 2 5 6，小哈手中也有 6 张牌，顺序
 * 为 3 1 3 5 6 4，最终谁会获胜呢？现在你可以拿出纸牌来试一试。接下来请你写一个程序来
 * 自动判断谁将获胜。这里我们做一个约定，小哼和小哈手中牌的牌面只有 1~9。
 */
public class CardGames {
    public static void main(String[] args) {
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        Stack s = new Stack();
        int[] book = new int[10];
        //小哼手上6张牌
        int[] soure01 = new int[]{2, 4, 1, 2, 5, 6};
        for (int i = 0; i < soure01.length; i++) {
            q1.data[q1.tail] = soure01[i];
            q1.tail++;
        }


        //小哈手上6张牌
        int[] soure02 = new int[]{3, 1, 3, 5, 6, 4};
        for (int i = 0; i < soure02.length; i++) {
            q2.data[q2.tail] = soure02[i];
            q2.tail++;
        }


        while (q1.head < q1.tail && q2.head < q2.tail) {
            int t = q1.data[q1.head];//小哼出一张牌
            if (book[t] == 0) {//表明桌上没有牌面为t的牌
                //小哼此轮没有赢牌
                s.top++;
                q1.head++;
                s.data[s.top] = t; //把牌打到桌面即入栈
                book[t] = 1;
            }else {
                //小哼此轮赢牌
                q1.head++; //小哼已经打出一张牌，所以要把打出的牌出队
                q1.data[q1.tail] = t;//紧接着把打出的牌放到手中牌的末尾
                q1.tail++;
                while(s.data[s.top]!=t) //把桌上可以赢得的牌依次放到手中牌的末尾
                {
                    book[s.data[s.top]]=0;//取消标记
                    q1.data[q1.tail]=s.data[s.top];//依次放入队尾
                    q1.tail++;
                    s.top--; //栈中少了一张牌，所以栈顶要减1
                }
                book[s.data[s.top]]=0;//取消标记
                q1.data[q1.tail]=s.data[s.top];//依次放入队尾
                q1.tail++;
                s.top--; //栈中少了一张牌，所以栈顶要减1
            }

            t=q2.data[q2.head]; //小哈出一张牌
            //判断小哈当前打出的牌是否能赢牌
            if (book[t] == 0) //表明桌上没有牌面为t的牌
            {
                //小哈此轮没有赢牌
                q2.head++; //小哈已经打出一张牌，所以要把打出的牌出队
                s.top++;
                s.data[s.top] = t; //再把打出的牌放到桌上，即入栈
                book[t] = 1; //标记桌上现在已经有牌面为t的牌
            } else {
                q2.head++;
                q2.data[q2.tail] = t;
                q2.tail++;
                while (s.data[s.top] != t) {
                    book[s.data[s.top]] = 0;
                    q2.data[q2.tail] = s.data[s.top];
                    q2.tail++;
                    s.top--;
                }
                book[s.data[s.top]] = 0;
                q2.data[q2.tail] = s.data[s.top];
                q2.tail++;
                s.top--;
            }
        }
        if(q2.head==q2.tail)
        {
            System.out.print("小哼win\n");
            System.out.print("小哼当前手中的牌是");
            for(int i=q1.head;i<=q1.tail-1;i++)
                System.out.print(" "+q1.data[i]);
            if(s.top>0) //如果桌上有牌则依次输出桌上的牌
            {
                System.out.print("\n桌上的牌是");
                for(int i=0;i<=s.top;i++)
                    System.out.print(" "+s.data[i]);
            }
            else
                System.out.print("\n桌上已经没有牌了");
        }
        else
        {
            System.out.print("小哈win\n");
            System.out.print("小哈当前手中的牌是");
            for(int i=q2.head;i<=q2.tail-1;i++)
                System.out.print(" "+q2.data[i]);
            if(s.top>0) //如果桌上有牌则依次输出桌上的牌
            {
                System.out.print("\n桌上的牌是");
                for(int i=0;i<=s.top;i++)
                    System.out.print(" "+s.data[i]);
            }
            else
                System.out.print("\n桌上已经没有牌了");
        }



    }
    /**
     * 结果：
     *  小哈win
     *  小哈当前手中的牌是 6 5 2 3 4 1
     *  桌上的牌是 3 4 5 6 2 1
     *
     *  总结：
     *      一不小心，你就算错
     */
}
@Data
class Queue{
    int data[] = new int[200];
    int head = 0;
    int tail = 0;
}
@Data
class Stack{
    int[] data = new int[10];
    int top = -1;
}
