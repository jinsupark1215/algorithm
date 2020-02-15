package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753_최단경로 {
	/*
	 * 1. 최단경로를 구하기
	 * 
	 * 2. V <= 20000, E <=300000
	 * 
	 * 3. 다익스트라 알고리즘
	 */
	static int INF = 2147483647;
	static int[] dist;// 시작 정점에서 목적 정점까지의 거리
	static boolean[] visit;// 정점을 방문했나 안했나

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());// 정점의 개수
		int E = Integer.parseInt(st.nextToken());// 간선의 개수
		int K = Integer.parseInt(br.readLine());// 시작 정점의 번호

		dist = new int[V + 1];// 시작 정점으로부터 목적 정점까지의 최소 거리
		visit = new boolean[V + 1];// 방문 했나 안했나

		// 각 정점의 연결된 간선을 저장
		ArrayList<Node>[] list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = INF;// 모든 정점은 일단 무한
			list[i] = new ArrayList<Node>();
		}
		dist[K] = 0;// 시작정점과 시작정점의 거리는 0

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());// 간선의 시작
			int v = Integer.parseInt(st.nextToken());// 간선의 끝
			int w = Integer.parseInt(st.nextToken());// 가중치
			list[u].add(new Node(v, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();// 우선순위 큐
		pq.add(new Node(K, 0));// 시작 정점을 우선순위 큐에 넣음.

		while (!pq.isEmpty()) {
			Node n = pq.poll();// 큐에 들어있는 간선중 가장 가중치가 낮은 것 찾음.
			if (visit[n.end] == true) {
				continue;
			}
			visit[n.end] = true;
			for (Node k : list[n.end]) {
				if (visit[k.end] == false) {
					dist[k.end] = Math.min(dist[k.end], dist[n.end] + k.value);
					pq.add(new Node(k.end, dist[k.end]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}

class Node implements Comparable<Node> {
	int end;
	int value;

	Node(int end, int value) {
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
