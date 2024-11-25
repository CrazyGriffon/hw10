package org.example;


import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу https://codeforces.com/contest/356/problem/A
     */
    @SneakyThrows
    public void championship(InputStream in, OutputStream out) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        SegmentTree st = new SegmentTree(n);

        int m = scanner.nextInt();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> winner = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            left.add(scanner.nextInt());
            right.add(scanner.nextInt());
            winner.add(scanner.nextInt());
        }

        for (int i = m - 1; i >= 0; --i) {
            int best = winner.get(i);
            st.update(left.get(i) - 1, best - 2, best);
            st.update(best, right.get(i) - 1, best);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            result.add(st.get(i));
            out.write((st.get(i) + " ").getBytes());
        }
        out.write(String.valueOf(st.get(n - 1)).getBytes());
    }
}
