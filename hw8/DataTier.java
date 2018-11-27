/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.*;
import java.io.*;

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}


	//getAllBooks: read the data file containing information about the books, create Book objects for each, and then return the Book objects.

	public List<Book> getAllBooks(){


		List<Book> books = new ArrayList<Book>();

		BufferedReader br;
		try  {

			FileReader fr= new FileReader(fileName);
			br = new BufferedReader(fr);

    		String line;
    		
    		while ((line = br.readLine()) != null) {

				// int lastQuote = line.lastIndexOf( '"' );
				// String titleAndAuthor = line.substring(0, lastQuote);
				// int firstQuote = titleAndAuthor.lastIndexOf('"');
				// String title = titleAndAuthor.substring(0, firstQuote);
				// String author = titleAndAuthor.substring(firstQuote + 1);
				// String yearStr = line.substring(lastQuote + 1);
				// int year = Integer.parseInt(yearStr.replaceAll("\"", "").replaceAll("\\s+",""));
				// books.add(new Book(title, author, year));
       			// process the line.

    			String[] pieces = line.split("\t");

    			if(pieces.length != 3){
    				continue;
    			}

    			String intStr = pieces[2];

    			intStr= intStr.replaceAll("\"", "");
    			intStr = intStr.replaceAll("\\s+","");

    			books.add( new Book(pieces[0], pieces[1],Integer.parseInt(intStr) ) );


    		}




    		
		}catch(FileNotFoundException e){


		}catch( IOException e){

		}


		//for(Book b: books){

		//	System.out.println(b.toString());


		//}

		return books;





	}



	public static void main(String[] args){

		DataTier dt = new DataTier("books.txt");

		List<Book> bks = dt.getAllBooks();

		//for(Book b: bks){
	//		System.out.println(b.toString());

	//	}
		
	}



	

}
