package com.dwc.arithmetic.aha.chapter04.node01;

import java.util.Arrays;

/**
 * @author: wcdai
 * @date: 11:49 2020/10/3
 * @description: 不撞南墙不回头--深度优先搜索
 * @question:
 *   输入一个n,输出一个n的全排列
 *   这里我们将问题形象化，举个例子。假如有编号为1，2，3的3张扑克牌和编号为1，2，3的3个盒子
 *   现在需要将这3张扑克牌分别放到3个盒子中，并且每个盒子有且只能放一张扑克牌，那么一共有几种
 *   不同的放法？
 */
public class DepthFirstSearch {

    static int n = 3; //定义需要全排列的总数1~n
    static int[] a = new int[n+1]; //盒子 a[0]不使用
    static int[] book = new int[n+1]; // 标记这个数是否已经放入盒中

    public static void main(String[] args) {
        //深度优先搜索
        dfs(1);
        //暴力枚举
        violenceEnum();
    }

    /**
     * 暴力枚举
     */
    private static void violenceEnum() {
        //因为已知n=3，一共3个数，每个数的取值都是1-3，所以是三层循环
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i != j && i != k && j != k) {
                        System.out.println(i+"--"+j+"--"+k);
                    }
                }
            }
        }

    }

    /**
     * 深度优先搜索
     * @param step 当前在第几个盒子位置
     */
    private static void dfs(int step) {
        //走到最后一个盒子的下一个盒子位置了，不做任何操作，结束掉，
        if (step == n + 1) {
//            if (a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6] == a[7] * 100 + a[8] * 10 + a[9]) {
                System.out.println(Arrays.toString(a));
//            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                a[step] = i;
                book[i] = 1;
                dfs(step+1);

                //下一个盒子走完（下下下...个也会走完，即第一次排列完成）会回到当前位置
                //可以开始新一轮排列了
                book[i] = 0;
            }
        }


    }
    /**
     * 总结：
     * 【深度优先算法基本思想】
     *    深度优先算法是对暴力枚举的改进
     *    void dfs(int step){
     *        判断边界
     *        尝试每一种可能 for(i=1;i<=n;i++){
     *          if(未被标记book[i]==0){
     *              标记 book[i]=1
     *              继续下一步 dfs(step+1);
     *              取消标记 book[i]=0
     *          }
     *        }
     *    }
     *   尝试：
     *      1-n:为可尝试范围，
     *      i++:让每次尝试不通数值，且只能依次尝试完1-n
     *      book[]:
     *          标记，防止下一步走上一步的老路。
     *          取消标记，这步已近走完，没有下一步。那么可以让出标记。(由下一步回退到了当前步，并且会接着退回到上一步，因此没有下一步)
     *  本例中：
     *
     */

}
