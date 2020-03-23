package Backjoon;

import java.util.Scanner;

public class Main2174 {

	/*
	 * 1. 맵에 로봇 초기 위치를 1로 바꿔주고 ArrayList에 Class robot을 저장
	 * 2. dfs로 명령어를 반복해서 실행 만약 하다가 1을 만나거나 밖으로 나가게 되면 프로그램 종료
	 * 3. 종료되면 바로 결과 출력
	 */
	
	static int[][] map;
	static robot[] ro;
	static order[] order;
	static boolean check = false;
	static int[][] pos = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int a, b, m, n;
	static int ans = 0;
	static int num1, num2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[b][a];
		ro = new robot[n];
		num1 = 0;
		num2 = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[b - y][x - 1] = 1;
			ro[i] = new robot(b - y, x - 1, sc.next().charAt(0));
		}

		order = new order[m];
		for (int i = 0; i < m; i++) {
			order[i] = new order(sc.nextInt(), sc.next().charAt(0), sc.nextInt());
		}

		for (int i = 0; i < m; i++) {
			dfs(order[i].num, order[i].o, order[i].cnt, 0);

			if (check) {
				break;
			}
		}

		switch (ans) {
		case 0:
			System.out.println("OK");
			break;
		case 1:
			System.out.println("Robot " + num1 + " crashes into the wall");
			break;
		case 2:
			System.out.println("Robot " + num1 + " crashes into robot " + num2);
			;
			break;

		}

	}

	private static void dfs(int num, char o, int cnt, int chk) {

		if (cnt == chk) {
			return;
		}
		int r = ro[num - 1].r;
		int c = ro[num - 1].c;

		switch (o) {
		case 'F':
			map[r][c] = 0;
			int nr = 0, nc = 0;
			switch (ro[num - 1].dir) {
			case 'S':
				nr = r + pos[0][0];
				nc = c + pos[0][1];
				break;
			case 'N':
				nr = r + pos[1][0];
				nc = c + pos[1][1];
				break;
			case 'E':
				nr = r + pos[2][0];
				nc = c + pos[2][1];
				break;
			case 'W':
				nr = r + pos[3][0];
				nc = c + pos[3][1];
				break;

			}

			if (nr < 0 || nc < 0 || nr >= b || nc >= a) {
				num1 = num;
				ans = 1;
				check = true;
				return;
			}
			if (map[nr][nc] == 0) {
				map[nr][nc] = 1;
			} else {
				num1 = num;
				for (int i = 0; i < n; i++) {
					if (ro[i].r == nr && ro[i].c == nc) {
						num2 = i + 1;
					}
				}
				ans = 2;
				check = true;
				return;
			}
			ro[num - 1].r = nr;
			ro[num - 1].c = nc;

			dfs(num, o, cnt, chk + 1);

			break;

		case 'R':
			switch (ro[num - 1].dir) {
			case 'S':
				ro[num - 1].dir = 'W';
				break;
			case 'N':
				ro[num - 1].dir = 'E';
				break;
			case 'E':
				ro[num - 1].dir = 'S';
				break;
			case 'W':
				ro[num - 1].dir = 'N';
				break;
			}

			dfs(num, o, cnt, chk + 1);
			break;

		case 'L':
			switch (ro[num - 1].dir) {
			case 'S':
				ro[num - 1].dir = 'E';
				break;
			case 'N':
				ro[num - 1].dir = 'W';
				break;
			case 'E':
				ro[num - 1].dir = 'N';
				break;
			case 'W':
				ro[num - 1].dir = 'S';
				break;
			}

			dfs(num, o, cnt, chk + 1);
			break;

		}

	}

	static class robot {
		int r, c;
		char dir;

		public robot(int r, int c, char dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static class order {
		int num, cnt;
		char o;

		public order(int num, char o, int cnt) {
			super();
			this.num = num;
			this.o = o;
			this.cnt = cnt;
		}

	}

}
