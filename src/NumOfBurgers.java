import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 * 二元一次方程而已
 */
public class NumOfBurgers {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 == 1 || tomatoSlices < cheeseSlices) return new ArrayList<>();
        List<Integer> op = new ArrayList<>();

        int x = tomatoSlices / 2 - cheeseSlices;
        int y = cheeseSlices - x;
        if (x < 0 || y < 0) return new ArrayList<>();
        op.add(x);
        op.add(y);
        return op;
    }
}
