

import java.util.LinkedList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {

		if(list == null){
			return;
		}

		int index = 0;

		for(int i=0; i<list.size(); i++){
							index = i;


			if(list.get(i) > value){

				break;
			}

			if(i == list.size() - 1){
				index++;
			}

		}

		list.add(index, value);
		/* IMPLEMENT THIS METHOD! */

	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if(list == null || N <= 0){
			return;
		}


		LinkedList<String> list2 = new LinkedList<String>(list);

		Collections.sort(list2, Collections.reverseOrder());

		Set<String> largest = new HashSet<String>();

		int count = 0;
		while(largest.size() < N && count < list2.size()){

			largest.add(list2.get(count));

			count++;

		}

		list.removeAll(largest);





		/* IMPLEMENT THIS METHOD! */

	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		LinkedList<Integer> temp = two;
		two = one;
		one = temp;


		if(one == null || two == null){
			return false;
		}

		if(two.size() == 0 || one.size() == 0){
			return false;
		}


		int x = 0;

		for(int i=0; i<two.size(); i++){

			if(one.get(x) == two.get(i)){
				x++;
			}else{
				x = 0;
			}

			if(x == one.size()){
				return true;
			}


		}

		/* IMPLEMENT THIS METHOD! */
		
		return false; // this line is here only so this code will compile if you don't modify it
	}

	public static void main(String[] args){
		LinkedList<String> list = new LinkedList<String>();


		list.add("zoo");
		list.add("zoo");
		list.add("zoo");

		list.add("lungs");
		list.add("lungs");
		list.add("lungs");

		list.add("dogs");

		list.add("dogs");

		removeMaximumValues(list, 2);

		for(String l: list){
			System.out.println(l);
		}


	}
}
