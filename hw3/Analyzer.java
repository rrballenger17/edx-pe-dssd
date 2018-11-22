import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		if(filename == null){
			return new ArrayList<Sentence>();
		}


		List<Sentence> sentences = new ArrayList<Sentence>();

		// return empty if file cannot be opened 

		FileReader fr;
		
		try{
			fr = new FileReader(filename);
		}catch(FileNotFoundException e){
			return new ArrayList<Sentence>();
		}

		BufferedReader br = new BufferedReader(fr);

    	String line;
    	while (true) {
       		
       			// process the line.
    		try{
    			line = br.readLine();
    		}catch(IOException e){
    			break;
    		}

    		if(line == null){
    			break;
    		}

    		if(line.length() < 3){
    			continue;
    		}


    		//if(line.isEmpty()){
    		//	continue;
    		//}

    		String number;
    		String sentence;

    		if(line.charAt(1) == ' '){
    			number = line.substring(0, 1);
    			sentence = line.substring(2);
    		}else if(line.charAt(2) == ' '){
    			number = line.substring(0, 2);
    			sentence = line.substring(3);
    		}else{
    			continue;
    		}


    		Integer scoreInLine;
    		try{
    			scoreInLine = Integer.parseInt(number);
    		}catch(Exception e){
    			continue;
    		}

    		if(scoreInLine == null ){
    			continue;
    		}

    		if(scoreInLine < -2 || scoreInLine > 2){
    			continue;
    		}

    		Sentence sent = new Sentence(scoreInLine, sentence);
    		sentences.add(sent);


   		}

   		//for(Sentence sen: sentences){
   		//	System.out.println(sen.getScore());
   		//	System.out.println(sen.getText());
   		//}

		/* IMPLEMENT THIS METHOD! */
		
		return sentences; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		Set<Word> set = new HashSet<Word>();

		Map<String, Word> map = new HashMap<String, Word>();

		//Map<String, Integer> countMap = new HashMap<String, Integer>();


		if(sentences == null || sentences.isEmpty()){
			return new HashSet<Word>();
		}


		for(Sentence sentence: sentences){

			if(sentence == null){
				continue;
			}


			String text = sentence.getText();

			String[] tokens = text.split("\\s+");

			for(String token: tokens){

				if(token.length()== 0){
					continue;
				}

				token = token.toLowerCase();

				char firstChar = token.charAt(0);

				if(!Character.isLetter(firstChar)){
					continue;
				}

				Word word;
				if(map.keySet().contains(token)){
					word = map.get(token);
				}else{
					word = new Word(token);
				}

				word.increaseTotal(sentence.getScore());
				map.put(token, word);

				
			}

		}

		for(String key: map.keySet()){

			set.add(map.get(key));

		}



		/* IMPLEMENT THIS METHOD! */
		
		return set; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */

		if(words == null || words.isEmpty()){
			return new HashMap<String, Double>();
		}

		Map<String, Double> map = new HashMap<String, Double>();

		for(Word word: words){

			if(word == null){
				continue;
			}

			map.put(word.getText(), word.calculateScore());
		}

		
		return map; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {


		if(wordScores == null || wordScores.isEmpty()){
			return 0;
		}

		if(sentence == null || sentence.length() == 0){
			return 0;
		}


		int count = 0;
		double score = 0.0;

		String[] tokens = sentence.split("\\s+");

			for(String token: tokens){

				if(token.length()== 0){
					continue;
				}

				token = token.toLowerCase();


				char firstChar = token.charAt(0);

				if(!Character.isLetter(firstChar)){
					continue;
				}


				if(wordScores.keySet().contains(token)){
					score += wordScores.get(token);
				}

				count++;

			}


		if(count == 0){
			count++;
		}

		/* IMPLEMENT THIS METHOD! */
		
		return score/ (double) count; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
