import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * chaoxi
 */
public class FindWhetherExistsPath {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        for(int[] g:graph){
            if(set.contains(g[0])){
                set.add(g[1]);
            }
        }
        return set.contains(target);
    }
}
