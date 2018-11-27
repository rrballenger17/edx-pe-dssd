

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {




	public static int minDistance(Graph graph, String src, String dest) {


		Map<Node, Integer> marked = new HashMap<Node, Integer>();


		if(graph == null || src == null || dest == null){
			return -1;
		}

		Node start = graph.getNode(src);
		Node end = graph.getNode(dest);

		if (!graph.containsNode(start) || !graph.containsNode(end)) {
				return -1;
		}

		if (start.getElement().equals(dest)) {
			return 0;
		}

		Queue<Node> toExplore = new LinkedList<Node>();
		
		marked.put(start, 0);
		
		toExplore.add(start);
		
		while (!toExplore.isEmpty()) {

			Node current = toExplore.remove();

			for (Node neighbor : graph.getNodeNeighbors(current)) {
				

				//if (!marked.contains(neighbor)) {
				
				//	if (neighbor.getElement().equals(elementToFind)) {
				//		return true;
				//	}

					int newDistance = marked.get(current)+1;

					if(marked.keySet().contains(neighbor)){

						if(newDistance < marked.get(neighbor)){
							marked.put(neighbor, newDistance);

							toExplore.add(neighbor);

						}
					}else{
						marked.put(neighbor, newDistance);

						toExplore.add(neighbor);

					}

					//marked.put(neighbor,   );


				//}
			}
		}
		//return false;



		if(!marked.keySet().contains(end)){
			return -1;
		}


		/* IMPLEMENT THIS METHOD! */
		
		return marked.get(end); // this line is here only so this code will compile if you don't modify it
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		Map<Node, Integer> marked = new HashMap<Node, Integer>();

		if(graph == null || src == null || distance <= 0){
			return null;
		}

		Node start = graph.getNode(src);
		//Node end = graph.getNode(dest);

		if (!graph.containsNode(start) ){//|| !graph.containsNode(end)) {
				return null;
		}

//		if (start.getElement().equals(dest)) {
//			return 0;
//		}

		Queue<Node> toExplore = new LinkedList<Node>();
		
		marked.put(start, 0);
		
		toExplore.add(start);
		
		while (!toExplore.isEmpty()) {

			Node current = toExplore.remove();

			for (Node neighbor : graph.getNodeNeighbors(current)) {
				

				//if (!marked.contains(neighbor)) {
				
				//	if (neighbor.getElement().equals(elementToFind)) {
				//		return true;
				//	}

					int newDistance = marked.get(current)+1;

					if(newDistance > distance){
						continue;
					}

					if(marked.keySet().contains(neighbor)){

						if(newDistance < marked.get(neighbor)){
							marked.put(neighbor, newDistance);

							toExplore.add(neighbor);

						}
					}else{
						marked.put(neighbor, newDistance);

						toExplore.add(neighbor);

					}

					//marked.put(neighbor,   );


				//}
			}
		}
		//return false;



		//if(!marked.keySet().contains(end)){
		//	return -1;
		//}

		Set<String> results = new HashSet<String>();

		for(Node key: marked.keySet()){

			if(marked.get(key) <= distance){
				results.add(key.toString());
			}

		}

		results.remove(src);


		/* IMPLEMENT THIS METHOD! */
		
		//return marked.get(end); // this line is here only so this code will compile if you don't modify it






		
		return results; // this line is here only so this code will compile if you don't modify it



	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		if(g == null || values == null){
			return false;
		}

		if(values.size() == 0){
			return false;
		}

		if(values.size() == 1){

			Node one = g.getNode(values.get(0));

			Set<Node> all = g.getAllNodes();

			if(all.size() > 1){
				return false;
			}

			if(!all.contains(one)){
				return false;
			}
		}

		Set<Node> visited = new HashSet<Node>();

		for(int i=0; i<values.size()-1; i++){
			
			String one = values.get(i);
			String two = values.get(i == values.size()-1? 0: i+1);

			Node oneN = g.getNode(one);
			Node twoN = g.getNode(two);

			Set<Node> neighs = g.getNodeNeighbors(oneN);

			if(!neighs.contains(twoN)){
				return false;
			} 

			if(visited.contains(twoN)){
				return false;
			}

			visited.add(twoN);
		}

		// String lastString = values.get(values.size() - 1 );
		// Node lastNode = g.getNode(lastString);
		// visited.add(lastNode);

		// String firstString = values.get(0);
		// Node firstNode = g.getNode(firstString);
		// visited.add(firstNode);

		// Set<Node> neighs = g.getNodeNeighbors(lastNode);

		// if(!neighs.contains(firstNode)){
		// 	return false;
		// }

		Set<Node> nodes = g.getAllNodes();

		for(Node n: nodes){
			if(!visited.contains(n)){
				return false;
			}

		}



		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
