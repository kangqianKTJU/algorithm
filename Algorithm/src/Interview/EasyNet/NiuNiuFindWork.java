package Interview.EasyNet;

import java.util.*;

/**题目描述
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，
 * 于是他只好把这个任务交给了你。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 *
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 *
 *
 * 输入
 * 复制
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 *
 *
 * 输出
 * 复制
 * 100
 * 1000
 * 1001
 */
public class NiuNiuFindWork {

    // 1. 通过Map来储存工作难度和报酬，O(N^2)，case passed 20%
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfWork = in.nextInt();
        int numOfFri = in.nextInt();

        Map[] hardAndSal = new Map[numOfWork];
        for(int i = 0; i < numOfWork; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(in.nextInt(), in.nextInt());
            hardAndSal[i] = map;
        }

        int[] ability = new int[numOfFri];
        for(int i = 0; i < ability.length; i++){
            ability[i] = in.nextInt();
        }

        for(int i = 0; i < numOfFri; i++){
            int maxSal = 0;
            for(int j = 0; j < numOfWork; j++){
                int hard = 0;
                int sal = 0;
                Set set = hardAndSal[j].keySet();
                for(Object key:set){
                    hard = (Integer) key;
                    sal = (Integer)hardAndSal[j].get(hard);
                }
                if(ability[i] >= hard && sal > maxSal){
                    maxSal = sal;
                }
            }
            System.out.println(maxSal);
        }

    }


    // 2. 优化存储，将Map数组改为二维数组，提高了Case passed 40%
    public static void main2(){
        Scanner in = new Scanner(System.in);
        int numOfWork = in.nextInt();
        int numOfFri = in.nextInt();

       int[][] hardAndSal = new int[numOfWork][2];
        for(int i = 0; i < numOfWork; i++){
            hardAndSal[i][0] = in.nextInt();
            hardAndSal[i][1] = in.nextInt();
        }

        int[] ability = new int[numOfFri];
        for(int i = 0; i < ability.length; i++){
            ability[i] = in.nextInt();
        }

        for(int i = 0; i < numOfFri; i++){
            int maxSal = 0;
            for(int j = 0; j < numOfWork; j++){

                if(ability[i] >= hardAndSal[j][0] && hardAndSal[j][1] > maxSal){
                    maxSal = hardAndSal[j][1];
                }
            }
            System.out.println(maxSal);
        }
    }


    // 3. 排序 + 二分查找法
    public static void main3(){
        Scanner in = new Scanner(System.in);
        int numOfWork = in.nextInt();
        int numOfFri = in.nextInt();

        Pair[] hardAndSal = new Pair[numOfWork];
        for(int i = 0; i < numOfWork; i++){
            hardAndSal[i] = new Pair(in.nextInt(), in.nextInt());
        }

        int[] ability = new int[numOfFri];
        for(int i = 0; i < ability.length; i++){
            ability[i] = in.nextInt();
        }
        Arrays.sort(hardAndSal, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.data1 - o2.data1;
            }
        });

        for(int i = 0; i < numOfFri; i++){
            int maxSal = hardAndSal[0].data2;
            for(int j = 0; j < numOfWork; j++){
                if(ability[i] >= hardAndSal[j].data1){
                    maxSal = Math.max(hardAndSal[j].data2, maxSal);
                }else{
                    break;
                }
            }
            System.out.println(maxSal);
        }



    }




    public static void main(String[] args) {
        main3();
    }


}

class Pair{
    Integer data1;
    Integer data2;
    Pair(Integer data1, Integer data2){
        this.data1 = data1;
        this.data2 = data2;
    }
}
