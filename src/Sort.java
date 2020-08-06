import java.util.Arrays;

/**
 * 四种常见的算法
 */
public class Sort {
    // 冒泡排序
    public void bubbleSort(int[] array) {
        int t;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
    }

    // 选择排序
    public void selectSort(int[] array) {
        int t;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[index] > array[j])
                    index = j;
            if (index != i) { //找到了比array[i]小的则与array[i]交换位置
                t = array[i];
                array[i] = array[index];
                array[index] = t;
            }
        }
    }

    public void insertionSort(int[] array) {
        int i, j, t;
        for (i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                t = array[i];
                for (j = i - 1; j >= 0 && t < array[j]; j--)
                    array[j + 1] = array[j];
                //插入array[i]
                array[j + 1] = t;
            }
        }
    }

    // 分治法快速排序
    public void quickSort(int[] array, int low, int high) { // 传入low=0，high=array.length-1;
        if (low >= high) {
            return;
        }
        int pivot = array[low];// 基准点
        int temp;
        int i = low;
        int j = high;//为什么要声明i和j，因为后面做迭代的时候还需要用到最初的left和right
        while (i < j) {//验证array数组至少有2个元素，才要做排序
            /*
             * 提问：
             * 为什么是 while里的判断，为什么是 “target[j] >= pivot”，而不是“target[j] > pivot”？？？
             * 答: 数组[181,181,187,181]，分别用上面两种while去测试：
             *    如果是">="时，因为 181 >= 181 成立，所以right就会从右往左移；
             *    如果是">"时，因为 181 > 181 成立，所以right就不会左移。
             * 重点！！！right或left，必须有一方得是移动的！！！否则程序就会进入死循环！！！
             */
            // 如果right一直都大于或等于pivot，则继续走，直到找到比pivot小的：
            while (array[j] >= pivot && i < j) {
                j--;
            }
            // 如果left一直都小于等于pivot，则继续走，直到找到比pivot大的：
            while (array[i] <= pivot && i < j) {
                i++;
            }
            // 此时right < pivot, left > pivot，将i和j做交换：
            if (i < j) {  //这里做判断是为了right到了left位置时，不用再将执行下面这三行代码了：
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // left和right相遇了：
        //将相遇点的元素和pivot做交换：
        array[low] = array[j];
        array[j] = pivot;
        //基准点两边的元素的分别再做排序：
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, high);
    }


    public static void main(String[] args) {
        int[] array = {37, 47, 23, 100, 19, 56, 56, 99, 9};
        Sort st = new Sort();
        // st.bubbleSort(array);
        // st.selectSort(array);
        // st.insertionSort(array);
        st.quickSort(array, 0, array.length - 1);
        System.out.println("排序后：" + Arrays.toString(array));
    }
}
