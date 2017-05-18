public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        /*
        因为每个房子只有3种刷法
        costs[0][0] costs[0][1] costs[0][2] 为刷第1个房子所需的费用的3种不同情况
        分别计算送第2个房子开始用3种不同颜色刷所需的费用知道第n个房子，之后取3个之中的最小值
        */
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        int n = costs.length - 1;
        return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
    }
}