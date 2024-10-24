package lc.stack.m;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    // O(n log n) O(n)
    public int carFleet(int target, int[] pos, int[] speed) {
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < pos.length; ++i)
            m.put(pos[i], (double)(target - pos[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        CarFleet carFleetCalculator = new CarFleet();
        int target =12;
        int[] pos = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleetCalculator.carFleet(target, pos, speed));
    }
}

