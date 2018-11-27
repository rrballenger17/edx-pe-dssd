/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.*;
import java.io.*;

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}



	//findBookTitlesByAuthor: for a given name, search through all of the books and return the titles of those books whose author name includes the input name.
	
	public List<String> findBookTitlesByAuthor(String name){

		List<String> titles = new ArrayList<String>();

		List<Book> list = dataTier.getAllBooks();

		for(Book b: list){

			if(b.getAuthor().contains(name)){
				titles.add(b.getTitle());
			}

		}

		return titles;


	}


	// findNumberOfBooksInYear: for a given year, search through all of the books and return the number of books published in that year


	public int findNumberOfBooksInYear(int year){


		List<Book> list = dataTier.getAllBooks();

		int count = 0;

		for(Book b: list){

			if(b.getPublicationYear()== year){
				
				count++;
			
			}

		}

		return count;


	}



	public static void main(String[] args){

		DataTier data = new DataTier("books.txt");

		LogicTier dt = new LogicTier(data);

		int count = dt.findNumberOfBooksInYear(2007);

		//for(String s: bks){
			System.out.println(count);
		//}
		
	}



}
