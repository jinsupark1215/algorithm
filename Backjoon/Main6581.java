package Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main6581 {

	/*
	 * 1. 틀에 맞게 출력
	 * 
	 * 2. 80자 넘어가면 개행
	 * 
	 * 3. br은 새줄, hr은 - 80개 -> 구현
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();

		String line;
		int wordNum = 0;
		while ((line = in.readLine()) != null) {
			String[] words = line.split(" |\t");
			for (int i = 0; i < words.length; ++i) {
				if (words[i].equals("<br>")) {
					sb.append("\n");
					wordNum = 0;
				} else if (words[i].equals("<hr>")) {
					if (wordNum != 0)
						sb.append("\n");
					sb.append("--------------------------------------------------------------------------------\n");
					wordNum = 0;
				} else if (wordNum + 1 + words[i].length() > 80) {
					sb.append("\n");
					sb.append(words[i]);
					wordNum = words[i].length();
				} else if (words[i].equals(""))
					;
				else {
					if (wordNum != 0)
						sb.append(" ");
					sb.append(words[i]);
					wordNum += words[i].length() + 1;
				}
			}

		}
		out.write(sb.toString());
		out.close();
		in.close();
		System.out.println("End!");
	}

}
