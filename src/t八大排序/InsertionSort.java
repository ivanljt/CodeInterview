package t八大排序;

class InsertionSort {

    int[] insertionSort(int[] ary) {
        if (ary == null) {
            return ary;
        }
        for (int i = 1; i < ary.length; i++) {
            int v = ary[i];
            for (int j = i - 1; j >= 0; j--) {
//                while (v < ary[j]) {
//                    ary[j + 1] = ary[j];
//                }
                if (v < ary[j]) {
                    ary[j + 1] = ary[j];
                    ary[j] = v;
                } else {
                    break;
                }
            }
        }
        return ary;
    }
}