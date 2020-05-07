import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Integer.max;
import static java.lang.System.exit;

public class Gen {
    static PrintWriter out;
    static boolean isLocal = true;

    // Both inclusives
    int getRandomBetween(int low, int high) {
        return new Random().nextInt(high + 1 - low) + low;
    }

    long getRandomBetween(long low, long high) {
        return ThreadLocalRandom.current().nextLong(low, high + 1); // For 2-digit integers, 10-99 inclusive.
    }

    void solve() throws Exception {
        int t = 100;
        out.println(t);
        for (int tt = 1; tt <= t; tt++) {
            int a = getRandomBetween(1, 200);
            int b = getRandomBetween(1, 200);
            int q = 1;
            out.println(a + " " + b + " " + q);
            while (q-- > 0) {
                int l = getRandomBetween(1, 1000000);
                int r = getRandomBetween(l, max(1000000, l));
                out.println(l + " " + r);
            }
        }
    }

    void genArray(int n, int min_v, int max_v) {
        for (int i = 0; i < n; i++) out.print(getRandomBetween(min_v, max_v) + " ");
        out.println();
    }

    void genArray(int n, long min_v, long max_v) {
        for (int i = 0; i < n; i++) out.print(getRandomBetween(min_v, max_v) + " ");
        out.println();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                out = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/sol.in")));
            } else {
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
            new Gen().solve();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}
