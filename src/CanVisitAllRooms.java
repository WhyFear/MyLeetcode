import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms/
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int roomIndex, Set<Integer> visited) {
        if (!visited.contains(roomIndex)) {
            visited.add(roomIndex);
            for (int key : rooms.get(roomIndex)) {
                dfs(rooms, key, visited);
            }
        }
    }
}
