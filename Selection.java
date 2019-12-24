import edu.princeton.cs.algs4.StdOut;

public class Selection {
    public static void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;    //数组长度
        for (int i = 0; i < N; i++) {//将a[i]与a[i+1..N]中最小的元素交换
            int min = i;      //最小元素的索引
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
/*        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);*/
        }
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {//在单行中打印数组
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {//测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        //String[] a = {"bed", "bug", "dad", "yes", "zoo", "...", "all", "bad", "yet"};
        //String[] a = StdIn.readStrings();
        Integer[] a = {0, 1, 2, 3, 4, 5, 5, 1, 2, 4};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

