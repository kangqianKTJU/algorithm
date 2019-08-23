package LeetCode.Greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 */
public class P621_leastInterval {
    public int leastInterval(char[] tasks, int n) {

        Map<Integer, Character> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            map.put(i, tasks[i]);
        }

        Set<Character> set = new HashSet<>();
        for(int i = 0; i < tasks.length; i++){

            if(map.get(i) != null) {
                Character ch = map.get(i);
                if(set.contains(ch)){
                    i++;
                }else{

                }

            }else{
                i++;
            }
        }

        return -1;
    }
}