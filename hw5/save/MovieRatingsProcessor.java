/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.ArrayList;

public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		List<String> list = new ArrayList<String>();

		if(movieRatings == null){
			return list;
		}


		for(String movie: movieRatings.keySet()){
			list.add(movie);
		}



		/* IMPLEMENT THIS METHOD! */
		
		return list; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		List<String> list = new ArrayList<String>();

		for(String title: movieRatings.keySet()){

			PriorityQueue<Integer> queue = movieRatings.get(title);

			int min = queue.peek();

			if(min > rating){
				list.add(title);
			}
			
		}

		/* IMPLEMENT THIS METHOD! */
		
		return list; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}
}
