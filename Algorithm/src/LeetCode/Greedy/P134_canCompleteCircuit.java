package LeetCode.Greedy;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 */
public class P134_canCompleteCircuit {

    // 1.暴力法： 依此判断从每个加油站出发是否可行，
    //  判断能否达到下一个加油站：当前油箱的剩余油量加上可加的油量是否大于前往该加油站消耗的油量
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasCount = gas.length;

        for(int i = 0; i < gasCount; i++){
            boolean flag = true;

            int left = 0;
            for(int k = i; k < i + gasCount; k++){
                int j = k % gasCount;
                if(left + gas[j] < cost[j]){
                    flag = false;
                    break;
                }
                left = left + gas[j] - cost[j];
            }
            if(flag == true) return i;
        }
        return -1;
    }


    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int gasCount = gas.length;

        int total_tank = 0;
        int cur_tank = 0;

        int start = 0;
        for(int i = 0 ; i < gasCount; i++){
            total_tank += gas[i] - cost[i];
            cur_tank += gas[i] - cost[i];

            if(cur_tank < 0){
                start = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank >= 0 ? start : -1;

    }



    public static void main(String[] args) {
        P134_canCompleteCircuit solution = new P134_canCompleteCircuit();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit1(gas, cost));
    }
}
