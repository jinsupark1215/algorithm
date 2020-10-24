package Programs;

import java.util.Scanner;

class Solution_nhn1 {
	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
		  int[] cnt = new int[numOfAllPlayers];
		  char[] currentState = new char[numOfAllPlayers-1];
		  
		  for(int player=0;player<numOfAllPlayers-1;player++) {
			  currentState[player]=(char) ('B'+player);
		  }
		  
		  //A부터 시작
		  int idx = 0;
		  cnt[0]=1;
		  char sulae = 'A';
		  
		  for(int game=0;game<numOfGames;game++) {
			 char target = currentState[(idx+(numOfMovesPerGame[game]%(numOfAllPlayers-1))+(numOfAllPlayers-1))%(numOfAllPlayers-1)];
			 
			 if(isQuickPlayer(namesOfQuickPlayers,target)) {
				 cnt[sulae-'A']+=1; 
				 idx = (idx+(numOfMovesPerGame[game]%(numOfAllPlayers-1))+(numOfAllPlayers-1))%(numOfAllPlayers-1);
			 }else { 
				 cnt[target-'A']+=1; 
				 idx = (idx+(numOfMovesPerGame[game]%(numOfAllPlayers-1))+(numOfAllPlayers-1))%(numOfAllPlayers-1);
				 currentState[idx]=sulae;
				 sulae = target;
			 }
		  }
		  for(int i=0;i<numOfAllPlayers-1;i++) {
			  System.out.println(currentState[i]+" "+cnt[currentState[i]-'A']);  
		  }
		  System.out.println(sulae+" "+cnt[sulae-'A']);
	  }
	  
	  private static boolean isQuickPlayer(char[] namesOfQuickPlayers, char sulae) {
		  for(int i=0;i<namesOfQuickPlayers.length;i++) {
			  if(namesOfQuickPlayers[i]==sulae) {
				  return true;
			  }
		  }
		  return false;
	  }

		  private static class InputData {
		    int numOfAllPlayers;
		    int numOfQuickPlayers;
		    char[] namesOfQuickPlayers;
		    int numOfGames;
		    int[] numOfMovesPerGame;
		  }

		  private static InputData processStdin() {
		    InputData inputData = new InputData();

		    try (Scanner scanner = new Scanner(System.in)) {
		      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

		      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
		      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
		      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

		      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
		      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
		      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
		      for(int i = 0; i < inputData.numOfGames ; i++){
		        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
		      }
		    } catch (Exception e) {
		      throw e;
		    }

		    return inputData;
		  }

		  public static void main(String[] args) throws Exception {
		    InputData inputData = processStdin();

		    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
		  }
}