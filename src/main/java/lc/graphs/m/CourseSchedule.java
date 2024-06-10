package lc.graphs.m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {
    // O(V+E) O(V)
    Set<Integer> set = new HashSet();
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] count = new int[n];
        ArrayList<Integer>[] prereqs = new ArrayList[n];
        for(int k = 0; k < n; k++)
            prereqs[k] = new ArrayList();
        for(int[] temp : prerequisites) {
            int a = temp[0];
            int b = temp[1];
            count[a]++;
            prereqs[b].add(a);
        }
        for(int k = 0; k < count.length; k++) {
            if(!set.contains(k)){
                if(count[k] == 0)
                    n = DFS(count, prereqs, k, n);
            }
        }
        return n == 0 ?  true : false;
    }

    public int DFS(int [] count,ArrayList<Integer> [] prereqs, int currentClass, int n){
        set.add(currentClass);
        n--;
        if(prereqs[currentClass].size() == 0)
            return n;
        for(int neighbor : prereqs[currentClass]) {
            count[neighbor]--;
            if(count[neighbor] == 0) {
                if(!set.contains(neighbor))
                    n = DFS(count, prereqs, neighbor, n);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
    }
}
