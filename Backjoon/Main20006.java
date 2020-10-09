package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main20006 {

	/*
	 * [백준] 랭킹전 대기열
	 * 
	 * 1. 방을 구분
	 * 
	 * 2. p <=300, m <=300
	 * 
	 * 3. 구현
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Point>[] list = new ArrayList[p];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Point>();
		}
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			for (int j = 0; j < list.length; j++) {
				if(list[j].size() == m)continue;
				if(list[j].size() == 0) {
					list[j].add(new Point(level,name));
					break;
				}else {
					if(Math.abs(list[j].get(0).level- level) <= 10 ) {
						list[j].add(new Point(level,name));
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i], new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o1.name.compareTo(o2.name);
				}
			});
			if(list[i].size()==0)continue;
			if(list[i].size() == m) {
				System.out.println("Started!");
			}else {
				System.out.println("Waiting!");
			}
			for (int j = 0; j < list[i].size(); j++) {
				System.out.println(list[i].get(j).level + " " + list[i].get(j).name);
			}
		}
	}
	static class Point{
		int level;
		String name;
		public Point(int level, String name) {
			super();
			this.level = level;
			this.name = name;
		}
	}
}
