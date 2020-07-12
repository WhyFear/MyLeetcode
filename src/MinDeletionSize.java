public class MinDeletionSize {
    public static void main(String[] args) {
        String[] str = new String[]{"xc", "yb", "za"};
//        String[] str = new String[]{"ca","bb","ac"};
        System.out.println(minDeletionSize(str));
    }

    public static int minDeletionSize(String[] A) {
        int minDeletionSize = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < A.length - 1; ) {
                if (A[j].toCharArray()[i] < A[j + 1].toCharArray()[i]) {
                    j++;
                } else {
                    minDeletionSize++;
                    break;
                }
            }
            if (0 == minDeletionSize) break;
        }
        return minDeletionSize;
    }
}
