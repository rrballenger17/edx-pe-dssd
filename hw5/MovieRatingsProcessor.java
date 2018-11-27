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



		if(movieRatings == null){
			return list;
		}


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
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();

		if(movieRatings == null){
			return map;
		}

		List<String> toRemove = new ArrayList<String>();

		for(String title: movieRatings.keySet()){

			PriorityQueue<Integer> pq = movieRatings.get(title);

			int count = 0;

			while(!pq.isEmpty() && pq.peek() < rating ){
				pq.remove();
				count++;
			}

			if(pq.isEmpty()){
				toRemove.add(title);
			}


			if(count > 0){
				map.put(title, count);
			}

		}

		for(String title: toRemove){
			movieRatings.remove(title);
		}


		/* IMPLEMENT THIS METHOD! */
		
		return map; // this line is here only so this code will compile if you don't modify it
	}



}





