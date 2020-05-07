import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

public class Brute {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = true;


    void Case() throws IOException {
        int t[] = sort(na(2));
        int a = t[0], b = t[1], q = nextInt();
        while (q-- > 0) {
            long l = nextLong(), r = nextLong();
            int ans = 0;
            for (long i = l; i <= r; i++) if ((i % a) % b != (i % b) % a) ans++;
            out.print(ans + " ");
        }
        out.println();
    }

    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            Case();
        }
    }

    void outputArray(int[] a) {
        for (int x : a) out.print(x + " ");
        out.println();
    }

    public static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1)
            return false;
        int j;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        int d = a[i];
        a[i] = a[j - 1];
        a[j - 1] = d;
        for (int p = i + 1, q = n - 1; p < q; p++, q--) {
            d = a[p];
            a[p] = a[q];
            a[q] = d;
        }
        return true;
    }

    List<List<Integer>> gen_subsets(int n) {
        List<List<Integer>> h = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    tmp.add(i);
                }
            }
            h.add(tmp);
        }
        return h;
    }


    int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    private int[] na(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    private long[] nal(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
    }

    int nextInt() throws IOException {
        return parseInt(next());
    }

    long nextLong() throws IOException {
        return parseLong(next());
    }

    double nextDouble() throws IOException {
        return parseDouble(next());
    }

    String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                in = new BufferedReader(new FileReader("src/tests/sol.in"));
                out = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/brute.out")));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }

            //long lStartTime = System.currentTimeMillis();
            new Brute().solve();
            //long lEndTime = System.currentTimeMillis();
            //out.println("Elapsed time in seconds: " + (double)(lEndTime - lStartTime) / 1000.0);
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}
