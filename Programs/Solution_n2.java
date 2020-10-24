package Programs;

import java.util.Scanner;

class Solution_nhn2 {
  private static void solution(int day, int width, int[][] blocks) {
	  
	  int[] build = new int[width];
	  int[] left, right;
	  int ans = 0;
	  
	  for (int d = 0; d < day; d++) {
		  left = new int[width];
		  right = new int[width];
		for (int i = 0; i < width; i++) {
			build[i] += blocks[d][i];
		}
		
		for (int i = 0; i < width; i++) {
			for (int j = i+1; j < width; j++) {
				if(build[i] > build[j]) {
					left[j] = Math.max(left[j],build[i]-build[j]);
				}else break;
			}
			for (int j = width-2-i; j >=0; j--) {
				if(build[width-1-i] > build[j]) {
					right[j] = Math.max(right[j], build[width-1 - i]-build[j]);
				}else break;
			}
		}
		
		for (int i = 0; i < width; i++) {
			if(right[i] !=0 && left[i] !=0) {
				ans += Math.min(left[i], right[i]);
				build[i] += Math.min(left[i], right[i]);
			}
		}
	}
	  System.out.println(ans);
  }
  
  private static class InputData {
    int day;
    int width;
    int[][] blocks;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      
      inputData.blocks = new int[inputData.day][inputData.width];
      for (int i = 0; i < inputData.day; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.width; j++) {
          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.day, inputData.width, inputData.blocks);
  }
}
