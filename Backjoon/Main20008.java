package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20008 {

	/*
	 * [백준] 몬스터를 처치하자!
	 * 
	 * 1. 몬스터를 처치할 최소시간
	 * 
	 * 2. N <=5 , HP <= 100000
	 * 
	 * 3. 대기시간, 쿨타임, 데미지 중 데미지로 정렬 후 while문 돌면서 체력소진
	 */
	static int N;
	static int HP;
	static Skill[] SKILL;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		SKILL = new Skill[N];
		int HP = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cd = Integer.parseInt(st.nextToken());
			int damage = Integer.parseInt(st.nextToken());
			SKILL[i] = new Skill(cd, damage);
		}
		int[] cool = new int[N];
		System.out.println(BTK(0, HP, cool));
	}

	// 현재 시간이 t이고 HP고 스킬들을 사용할 수 있게 되는 시간들이 cool일때
	// 처치하는데 걸리는 시간
	static int BTK(int t, int hp, int[] cool) {
		if (hp <= 0) {return t;}
		int min = 1000;
		boolean used = false;
		for (int i = 0; i < N; i++) { // N개의 스킬 중에서
			if (t >= cool[i]) { // 사용 할 수 있는 스킬인 경우
				used = true;
				int temp = cool[i];
				cool[i] = t + SKILL[i].time;
				min = Math.min(min, BTK(t + 1, hp - SKILL[i].damage, cool));
				cool[i] = temp;
			}
		}
		// 모두 다 사용할 수 없는 경우
		if (!used) {min = Math.min(min, BTK(t + 1, hp, cool));}
		return min;
	}
	
	static class Skill {
		int time; int damage;
		public Skill(int t, int d) {time = t; damage = d;}
	}
}
