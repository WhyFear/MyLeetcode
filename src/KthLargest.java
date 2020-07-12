import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;
        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) //超过大小就弹出最小元素。最后剩下的就是第K个元素
                heap.poll();
        }
    }

    public int add(int val) {
        heap.add(val);
        if ((heap.size() > k)) heap.poll();
        return heap.peek();
    }
}