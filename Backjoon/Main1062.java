package Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1062{

	/*
	 * 1. 만들 수 있는 단어의 최대수를 구하여라
	 * 
	 * 2.N <= 50, 0<=K<=26, 시작단어 anta, 끝단어 tica
	 * 
	 * 3. 
	 * if K<5 ans = 0
	 * else 배열 선언 후 K-1 체크 후 넘어가고 넘어가기
	 */
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] word = new int[N];

        for (int i = 0; i < N; i++) {
            char[] tempStr = br.readLine().toCharArray();
            for (char x : tempStr) {
                word[i] |= (1 << x - 'a');
            }
        }

        System.out.println(solve(0, K, 0, word));
    }

    static int solve(int alphabetIdx, int K, int mask, int[] word) {

        if (K < 0) {
            return 0;
        }

        if (alphabetIdx == 26) {
            int cnt = 0;
            for (int i = 0; i < word.length; i++) {
                if (word[i] == (word[i] & mask)) {
                    cnt++;
                }
            }
            return cnt;
        }

        int ans = 0;
        int case1, case2;

        // 1. 해당 알파벳을 배우는 경우
        case1 = solve(alphabetIdx + 1, K - 1, mask | (1 << alphabetIdx), word);
        case2 = 0;

        // 2. 해당 알파벳을 배우지 않는 경우
        switch (alphabetIdx) {

            case 'a' - 'a':
            case 'n' - 'a':
            case 't' - 'a':
            case 'i' - 'a':
            case 'c' - 'a':
                break;

            default:

                case2 = solve(alphabetIdx + 1, K, mask, word);
                break;
        }

        ans = Math.max(case1, case2);

        return ans;
    }
}

