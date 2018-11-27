/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		

		if(allUsersRatings == null || allUsersRatings.isEmpty()){
			return new TreeMap<String, PriorityQueue<Integer>>();
		}

		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<String, PriorityQueue<Integer>>();

		//PriorityQueue<Integer> queue = new PriorityQueue();

		for(UserMovieRating rating: allUsersRatings){

			if(rating == null || rating.getMovie() == null || rating.getMovie().isEmpty() || rating.getUserRating() < 0){
				continue;
			}

			String movie = rating.getMovie().toLowerCase();

			int ratingVal = rating.getUserRating();

			PriorityQueue<Integer> pQueue = null;

			if(map.keySet().contains(movie)){
				pQueue = map.get(movie);
			}else{
				pQueue = new PriorityQueue<Integer>();
			}

			pQueue.add(ratingVal);

			map.put(movie, pQueue);
		}



		//If the input List is null or empty, parseMovieRatings should return an empty TreeMap

		//If the input List contains any null UserMovieRatings object, or a UserMovieRatings object whose movie title is null or an empty string, 
		// or a UserMovieRatings object whose rating is negative, parseMovieRatings should ignore that UserMovieRatings object

		//The movie titles should be considered case-insensitive, i.e. if two UserMovieRatings objects have the same title that differ only in case 
		//(upper or lower), they should be considered the same movie. The movie titles stored in the TreeMap must use lowercase letters.

		/* IMPLEMENT THIS METHOD! */
		
		return map; // this line is here only so this code will compile if you don't modify it
	}

}
