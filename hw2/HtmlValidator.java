import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {


		Stack<HtmlTag> stack = new Stack<HtmlTag>();

		while(!tags.isEmpty()){

			HtmlTag tag = tags.remove();


			if(tag.isSelfClosing()){
				continue;
			}

			if(tag.isOpenTag()){
				stack.push(tag);
				continue;
			}

			// if stack is empty to-do

			if(stack.isEmpty()){
				return null;
			}

			HtmlTag stackTag = stack.pop();

			if(!tag.matches(stackTag)){
				stack.push(stackTag);
				return stack;

			}
		}






		/* IMPLEMENT THIS METHOD! */
		
		return stack; // this line is here only so this code will compile if you don't modify it
	}
	

}

