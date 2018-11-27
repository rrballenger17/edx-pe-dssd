/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */
import java.util.Scanner; 
import java.util.List;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}


	//showBookTitlesByAuthor: using the command-line (i.e., reading from System.in), ask the user to enter part or all of an author’s name, then display (using System.out) the titles of those books whose author name includes the input name.

	public void showBookTitlesByAuthor(){

		System.out.print("Author's name: ");

        Scanner sc = new Scanner(System.in); 
  
        // String input 
        String name = sc.nextLine(); 

        List<String> titles = logicTier.findBookTitlesByAuthor(name);

        for(String title: titles){

        	System.out.println(title);
        }
	}

	public void showNumberOfBooksInYear(){

		System.out.print("Year: ");

        Scanner sc = new Scanner(System.in); 
  
        // String input 
        String yearStr = sc.nextLine(); 


       	int count = logicTier.findNumberOfBooksInYear(Integer.parseInt(yearStr));

        //for(String title: titles){

        	System.out.println(count);
        //}

	}


	
	public void start() {
		
		/* IMPLEMENT THIS METHOD */
	}
	



	public static void main(String[] args){

		DataTier data = new DataTier("books.txt");

		LogicTier dt = new LogicTier(data);

		PresentationTier pt = new PresentationTier(dt);

		pt.showNumberOfBooksInYear();

		//int count = dt.findNumberOfBooksInYear(2007);

		//for(String s: bks){
		//	System.out.println(count);
		//}
		
	}

}
