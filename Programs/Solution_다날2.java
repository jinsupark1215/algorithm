package Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_다날2 {

	public static void main(String[] args) {
		String[] orders = {"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"};
		System.out.println(solution(orders));
	}

	private static String[] solution(String[] orders) {
		List<String> answer = new ArrayList<String>();
		Map<String,Person> map = new HashMap<String,Person>();
		for(int i=0;i<orders.length;i++) {
			String[] temp = orders[i].split(" ");
			if(map.containsKey(temp[0])) {
				Set<String> tempSet = new HashSet<String>();
				tempSet = map.get(temp[0]).disMenu;
				for(int j=1;j<temp.length;j++) {
					tempSet.add(temp[j]);
				}
			}else {
				Set<String> tempSet = new HashSet<String>();
				for(int j=1;j<temp.length;j++) {
					tempSet.add(temp[j]);
				}
				map.put(temp[0],new Person(temp[0],tempSet));
			}
		}
		
		List<Person> list =  new ArrayList<Person>(map.values());
		Collections.sort(list);
		int size = list.get(0).disMenu.size();
		for(Person person : list) {
			if(size>person.disMenu.size()) break;
			answer.add(person.name);
		}
		Collections.sort(answer);
		String[] answerStr = new String[answer.size()];
		int cnt = 0;
		for(String str : answer) {
			answerStr[cnt]=str;
			cnt++;
		}
		return answerStr;

	}
	static class Person implements Comparable<Person>{
		String name;
		Set<String> disMenu;
		Person(String name, Set<String> dismenu){
			this.name = name; 
			this.disMenu = dismenu;
		}
		@Override
		public int compareTo(Person person2) {
			return person2.disMenu.size()-this.disMenu.size();
		}
	}

}
