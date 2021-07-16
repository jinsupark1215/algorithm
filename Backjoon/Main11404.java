package Backjoon;

class Main11404 {
    public static void main(String[] args) throws Exception {

        int INF = 99999999, N = read() + 1, M = read(), a, b, c, v, map[][] = new int[N][N];

        for (a = 1; a < N; a++) {
            for (b = 1; b < N; b++)
                if (a != b) map[a][b] = INF;
        }

        for (v = 0; v < M; v++) {
            if (map[a = read()][b = read()] > (c = read())) map[a][b] = c;
        }

        for (v = 1; v < N; v++)
            for (a = 1; a < N; a++)
                if (a != v) for (b = 1; b < N; b++)
                    if (v != b && map[a][b] > (c = map[a][v] + map[v][b])) map[a][b] = c;

        StringBuilder sb = new StringBuilder();
        for (a = 1; a < N; a++) {
            for (b = 1; b < N; b++) sb.append((c = map[a][b]) < INF ? c : 0).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}