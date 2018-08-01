package t八大排序;


class QuickSort {
    public int[] quickSort(int[] a, int n) {
        // write code here
        if (a == null || a.length == 0) {
            return a;
        }

        return quickSort(a, 0, n - 1);
    }

    int[] quickSort(int[] a, int start, int end) {
        //递归终止条件，勿忘
        if (start >= end) {
            return a;
        }
        int pivot = a[start];
        int i = start + 1;
        int j = end;
        //切分，左边 <= pivot  < 右边
        while (i <= j) {
            while (i <= j && a[i] <= pivot) i++;
            while (i <= j && a[j] > pivot) j--;
            if (i == j) {
                i++;
            }
            if (i < j) {//这个判断是有必要的，防止 i > j的情况（可能导致数组越界）
                //交换值
                //a[i]  a[j]
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                //交换之后需要更新指针。
                i++;
                j--;
            }
        }
        a[start] = a[j];
        a[j] = pivot;
        quickSort(a, start, j - 1);
        quickSort(a, j + 1, end);
        return a;
    }

    /**
     * 优化
     * */
}
