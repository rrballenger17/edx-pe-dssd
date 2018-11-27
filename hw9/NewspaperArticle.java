/*
 * SD2x Homework #9
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
import java.util.*;

public class NewspaperArticle extends Document{
	//private String title;
	//private String author;
	//private Date date;
//	private String city;
//	private String state;
//	private String postCode;

	private int startPage;
	private int endPage;
	private Set<String> editors;
	private String newspaper;
	
	public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors, String newspaper, Date date, String city, String state, String postCode) {
		super(title, author, date, new PublishingLocation(city, state, postCode));

		this.startPage = startPage;
		this.endPage = endPage;
		this.editors = editors;
		this.newspaper = newspaper;
		
		//this.date = date;
		//location = new PublishingLocation(city, state, postCode);
		//this.title = title;
		//this.author = author;
		//this.city = city;
		//this.state = state;
		//this.postCode  = postCode;

	}
	

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public Set<String> getEditors() {
		return editors;
	}
	
	public String getNewspaper() {
		return newspaper;
	}

	public int numPages(){
		return endPage - startPage + 1;
	}
	

	public boolean sameNewspaper(NewspaperArticle article) {
		return this.newspaper.equals(article.newspaper);
	}
	
	public int numEditors(){
		return editors.size();
	}
	
	public Set<String> commonEditors(NewspaperArticle article){
		Set<String> sameEditors = new HashSet<String>();
		for(String ed : article.editors){
			if(this.editors.contains(ed)){
				sameEditors.add(ed);
			}
		}
		return sameEditors;
	}
	

	

	
}
