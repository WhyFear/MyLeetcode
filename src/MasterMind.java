/**
 * https://leetcode-cn.com/problems/master-mind-lcci/
 */
public class MasterMind {
    public int[] masterMind(String solution, String guess) {
        int[] op = new int[2];
        int[] solutionInts = new int[4]; // r g b y
        for (int i = 0; i < 4; i++) {
            if (solution.charAt(i) == guess.charAt(i)) op[0]++;
            switch (String.valueOf(solution.charAt(i))) {
                case "R":
                    solutionInts[0]++;
                    break;
                case "G":
                    solutionInts[1]++;
                    break;
                case "B":
                    solutionInts[2]++;
                    break;
                case "Y":
                    solutionInts[3]++;
                    break;
            }
        }
        for (int i = 0; i < 4; i++) {
            switch (String.valueOf(guess.charAt(i))) {
                case "R":
                    if (solutionInts[0] != 0) {
                        solutionInts[0]--;
                        op[1]++;
                    }
                    break;
                case "G":
                    if (solutionInts[1] != 0) {
                        solutionInts[1]--;
                        op[1]++;
                    }
                    break;
                case "B":
                    if (solutionInts[2] != 0) {
                        solutionInts[2]--;
                        op[1]++;
                    }
                    break;
                case "Y":
                    if (solutionInts[3] != 0) {
                        solutionInts[3]--;
                        op[1]++;
                    }
                    break;
            }
        }
        op[1] -= op[0];
        return op;
    }
}
