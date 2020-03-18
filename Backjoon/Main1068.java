package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1068 {

	/*
	 * [백준] 트리
	 * 1. 트리
	 * 
	 * 2. N <= 50, 부모노드가 없을 시 -1
	 * 
	 * 3. 배열로 트리구현, 삭제(dfs)
	 */
	static int N;
	static int[][] nodes;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nodes = new int[N][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nodes[i][0] = Integer.parseInt(st.nextToken());
		}
		
		//자식이 몇명있는지 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(nodes[j][0] == i)nodes[i][1]++;
			}
		}
		
		//해당 부모를 가진 자식노드들을 다 지우기
		removeNode(Integer.parseInt(br.readLine()));
		
		//마지막 노드갯수
		int leafNode = 0;
		for (int i = 0; i < N; i++) {
			if(nodes[i][0] != -2 && nodes[i][1] == 0)leafNode++;
		}
		
		System.out.println(leafNode);
	}

	private static void removeNode(int del) {
		if(nodes[del][0] != -1) {
			nodes[nodes[del][0]][1]--;
		}
		nodes[del][0] = -2;
		
		if(nodes[del][1] !=0) {
			for (int i = 0; i < N; i++) {
				if(nodes[i][0] == del) {
					removeNode(i);
				}
			}
		}
	}

}
