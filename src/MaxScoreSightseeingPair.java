public class MaxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int left = A[0], op = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            op = Math.max(op, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        return op;
    }
}
