package Programs;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_기둥과보 {

	/*
	 * [카카오] 기둥과보설치
	 * 
	 * 1. 구조물 만든 뒤 구조물 리턴
	 * 
	 * 2. n<=100
	 * 
	 * 3. 기둥배열 보배열 만든뒤 조건에 맞게 
	 * 기둥 : 맨 밑이거나 한쪽 보가 있는경우 설치 
	 * 보 : 보 한쪽 끝이 기둥위에 있거나 양쪽에 보가
	 * 있는경우
	 */
	public static void main(String[] args) {
		int n = 5;
//		int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
//				{ 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },
				{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };

		System.out.println(Arrays.toString(solution(n, build_frame)));
	}

	static boolean[][][] build;

	private static int[][] solution(int n, int[][] build_frame) {
		build = new boolean[n + 1][n + 1][2];

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int structure = build_frame[i][2];
			int isInstall = build_frame[i][3];

			// 기둥
			if (structure == 0) {
				if (isInstall == 1) {// 설치
					build[x][y][0] = confirmPillar(x, y);
				} else {// 삭제
					build[x][y][0] = false;
					if ((isPillar(x, y + 1) && !confirmPillar(x, y + 1)) // 위에 기둥 검사
							|| (isBeam(x, y + 1) && !confirmBeam(x, y + 1)) // 바로 위의 보 검사
							|| (isBeam(x - 1, y + 1) && !confirmBeam(x - 1, y + 1))) { // 바로 위 왼쪽의 보 검사
						build[x][y][0] = true;
					}
				}
			}

			// 보
			else {
				if (isInstall == 1) {// 설치
					build[x][y][1] = confirmBeam(x, y);
				} else {// 삭제
					build[x][y][1] = false;
					if ((isPillar(x, y) && !confirmPillar(x, y)) // 보 왼쪽 기둥
							|| (isPillar(x + 1, y) && !confirmPillar(x + 1, y)) // 보 오른쪽 기둥
							|| (isBeam(x + 1, y) && !confirmBeam(x + 1, y)) // 오른쪽 보
							|| (isBeam(x - 1, y) && !confirmBeam(x - 1, y))) { // 왼쪽 보
						build[x][y][1] = true;
					}
				}
			}
		}

		ArrayList<Structure> list = new ArrayList<>();
		for (int i = 0; i < build.length; i++) {
			for (int j = 0; j < build.length; j++) {
				if (build[i][j][0]) {
					list.add(new Structure(i, j, 0));
				}

				if (build[i][j][1]) {
					list.add(new Structure(i, j, 1));
				}
			}
		}

		int[][] answer = new int[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			answer[i][0] = list.get(i).x;
			answer[i][1] = list.get(i).y;
			answer[i][2] = list.get(i).struc;
		}

		return answer;
	}

	static boolean isPillar(int x, int y) {
		if (x < 0 || y < 0 || x > build.length || y > build.length) {
			return false;
		}

		return build[x][y][0];
	}

	static boolean isBeam(int x, int y) {
		if (x < 0 || y < 0 || x > build.length || y > build.length) {
			return false;
		}

		return build[x][y][1];
	}

	static boolean confirmPillar(int x, int y) {
		// 바닥 위거나, 기둥 위거나, 보의 한 쪽 위거나
		return y == 0 || isPillar(x, y - 1) || isBeam(x, y) || isBeam(x - 1, y);
	}

	static boolean confirmBeam(int x, int y) {
		// 아래에 기둥이 있는지, 양 옆에 연결된 보가 있는지
		return isPillar(x, y - 1) || isPillar(x + 1, y - 1) || (isBeam(x - 1, y) && isBeam(x + 1, y));
	}

	static class Structure {
		int x;
		int y;
		int struc;

		Structure(int x, int y, int structure) {
			this.x = x;
			this.y = y;
			this.struc = structure;
		}
	}
}
