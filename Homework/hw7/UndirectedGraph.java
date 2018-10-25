package edu.cofc.csci230;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Undirected and unweighted graph data structure.
 * 
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class UndirectedGraph<AnyType extends Comparable<AnyType>> {
	
	/**
	 * Adjacency list data structure. Used in conjunction with
	 * adjacent_vertex_list in each Vertex class.
	 * 
	 * Note: Each vertex in the adjacency list must be unique, 
	 * i.e. the list cannot contain two vertices that have the 
	 * same value.
	 */
	private List<Vertex<AnyType>> vertex_adjacency_list = null;
	
	/**
	 * 
	 */
	public UndirectedGraph() {
		
		vertex_adjacency_list = new ArrayList<Vertex<AnyType>>();
		
	} // end constructor
	
	/**
	 * Add an edge between two vertices
	 * 
	 * @param vertex_value_A
	 * @param vertex_value_B
	 * @return
	 * @throws VertexException
	 */
	public Boolean addEdge( AnyType vertex_value_A, AnyType vertex_value_B ) throws VertexException {
		
		// ------------------------------------
		// Basic steps:
		// ------------------------------------
		// 1) For Vertex A and B, check to see if the vertex exits in the 
		//    vertex_list. If not, then add new vertex (with given value) 
		//    to the vertex_adjacency_list.
		// 2) In Vertex class, check if Vertex B is in Vertex A's 
		//    adjacent_vertex_list and vice versa (i.e. an edge exists). If 
		//    edge already exists, then return false, otherwise goto step 3.
		// 3) Add Vertex B to Vertex A's adjacent_vertex_list and vice versa.
		//    Lastly, return true indicating the edge was successfully added.
		
		// ----------------------------
		// TODO: Add your code here
		// ----------------------------
		Vertex<AnyType> a= null;
		Vertex<AnyType> b= null;
		for(int i=0;i<vertex_adjacency_list.size();i++){
			if(vertex_adjacency_list.get(i).getValue().equals(vertex_value_A))
				a=vertex_adjacency_list.get(i);
			if(vertex_adjacency_list.get(i).getValue().equals(vertex_value_B))
				b=vertex_adjacency_list.get(i);
		}
		if(a==null) {
			a = new Vertex<AnyType>(vertex_value_A);
			vertex_adjacency_list.add(a);
		}
		if(b==null) {
			b = new Vertex<AnyType>(vertex_value_B);
			vertex_adjacency_list.add(b);
		}
		if(a.hasAdjacentVertex(b))
			return false;
		if(b.hasAdjacentVertex(a))
			return false;
		a.addAdjacentVertex(b);
		b.addAdjacentVertex(a);


			
		return true;
	
	} // end addEdge() method
	
	
	/**
	 * 
	 * Remove the edge that connects two vertices
	 * 
	 * 
	 * @param vertex_value_A
	 * @param vertex_value_B
	 * @return
	 * @throws VertexException
	 */
	public Boolean removeEdge( AnyType vertex_value_A, AnyType vertex_value_B ) throws VertexException {
		
		// ------------------------------------
		// Basic steps:
		// ------------------------------------
		// 1) For each vertex, check to see if the vertex exists in 
		//    the vertex_list. If not, return false indicated the edge 
		//    does not exist. Otherwise goto step 2.
		// 2) In Vertex class, check to see if Vertex B is in Vertex A's
		//    adjacent_vertex_list and vice versa (i.e. an edge exists). 
		//    If the edge does not exist return false, otherwise goto 
		//    step 3.
		// 3) In the Vertex class, remove Vertex B from Vertex A's 
		//    adjacent_vertex_list and vice versa, and then goto step 4. 
		//    Does not exist and return false, otherwise proceed to step 4.
		// 4) If number of adjacent vertices for Vertex A is zero, then 
		//    remove from the vertex_list. Likewise, if the number of adjacent
		//    vertices for Vertex B is zero, then remove from vertex_list.
		//    Lastly, return true indicating the edge was successfully
		//    removed.
		
		// ----------------------------
		// TODO: Add your code here
		// ----------------------------
		Vertex<AnyType> a= null;
		Vertex<AnyType> b= null;
		int aPos=0;
		int bPos=0;
		for(int i=0;i<vertex_adjacency_list.size();i++){
			if(vertex_adjacency_list.get(i).getValue().equals(vertex_value_A)) {
				a = vertex_adjacency_list.get(i);
				aPos=i;
			}
			if(vertex_adjacency_list.get(i).getValue().equals(vertex_value_B)) {
				b = vertex_adjacency_list.get(i);
				bPos=i;
			}
		}
		if(a==null) {
			return false;
		}
		if(b==null) {
			return false;
		}
		if(a.hasAdjacentVertex(b)==false)
			return false;
		if(b.hasAdjacentVertex(a)==false)
			return false;
		a.removeAdjacentVertex(b);
		b.removeAdjacentVertex(a);
		if(a.numberOfAdjacentVertices()==0)
			vertex_adjacency_list.remove(aPos);
		if(b.numberOfAdjacentVertices()==0)
			vertex_adjacency_list.remove(bPos);
		
			
		return true;
		
	} // end removeEdge() method
	
	/**
	 * 
	 * Depth first search (DFS) using stack data structure.
	 * Specifically, the ConstantTimeStack class.
	 * 
	 * Must be an iterative solution.
	 * 
	 * Return a String that shows when each vertex was 
	 * visited during the DFS. String format: 
	 * <Vertex Value>:<Visited Count>\n
	 * 
	 * Notes: 
	 *  (1) Don't forget to mark each vertex as not visited
	 *      before the search begins.
	 *  (2) If the start_vertex value does not exist in the 
	 *      undirected graph throw a new VertexException.
	 *  (3) Vertex must be pushed onto the Stack in the same
	 *      order they were added to the adjacent_vertex_list 
	 *  (4) See assignment for DFS String format example.
	 * 
	 * @param start_vertex
	 * @return
	 * @throws VertexException
	 */
	public String depthFirstSearch( AnyType start_vertex ) throws VertexException {
		
		StringBuffer buffer = new StringBuffer();
		
		// ----------------------------
		// TODO: Add your code here
		// ----------------------------
		ConstantTimeStack<Vertex<AnyType>> stack = new ConstantTimeStack<Vertex<AnyType>>();
		Vertex start=null;
		boolean has=false;
		for(int i=0;i<vertex_adjacency_list.size();i++) {
			if(vertex_adjacency_list.get(i).getValue().equals(start_vertex)) {
				start = vertex_adjacency_list.get(i);
				has=true;
			}
			vertex_adjacency_list.get(i).setVisited(-1);
		}
		if(has==false)
			throw new VertexException("Vertex Exception");
		stack.push(start);
		start.setVisited(1);
		//buffer.append(start);
			boolean run = true;
			while (run) {
				try {
					Vertex<AnyType> top = stack.pop();
					buffer.append(top);
					buffer.append(" ");
					for (int i = 0; i < top.numberOfAdjacentVertices(); i++) {
						Vertex<AnyType> v= top.getAdjacentVertex(i);
						if (v.hasBeenVisited()==false&&v!=null) {
							stack.push(v);
							v.setVisited(1);
							//buffer.append(top.getAdjacentVertex(i));
						}
					}

				} catch (Exception e) {
					run = false;
				}
			}


		return buffer.toString();
		
	} // end depthFirstSearch() method
	
	/**
	 * 
	 * Breadth first search (BFS) using queue data structure.
	 * Specifically, the SemiConstantTimeQueue class
	 * 
	 * Must be an iterative solution.
	 * 
	 * Return a String that shows when each vertex was 
	 * visited during the BFS. String format: 
	 * <Vertex Value>:<Visited Count>\n 
	 * 
	 * Notes: 
	 *  (1) Don't forget to mark each vertex as not visited
	 *      before the search begins.
	 *  (2) If the start_vertex value does not exist throw a
	 *      new VertexException.
	 *  (4) Vertex must be added to the Queue in the same
	 *      order they were added to the adjacent_vertex_list 
	 *  (3) See assignment for BFS String format.
	 * 
	 * @param start_vertex
	 * @return
	 * @throws VertexException
	 */
	public String breadthFirstSearch( AnyType start_vertex )  throws VertexException {
		
		StringBuffer buffer = new StringBuffer();
		
		// ----------------------------
		// TODO: Add your code here
		// ----------------------------
		SemiConstantTimeQueue<Vertex<AnyType>> q = new SemiConstantTimeQueue<Vertex<AnyType>>();
		Vertex start=null;
		boolean has=false;
		for(int i=0;i<vertex_adjacency_list.size();i++) {
			if(vertex_adjacency_list.get(i).getValue().equals(start_vertex)) {
				start = vertex_adjacency_list.get(i);
				has=true;
			}
			vertex_adjacency_list.get(i).setVisited(-1);
		}
		if(has==false)
			throw new VertexException("error");
		q.add(start);
		start.setVisited(1);
		//buffer.append(start);
		boolean run=true;
		while(run){
			try{
				Vertex<AnyType> top= q.remove();
				buffer.append(top);
				buffer.append(" ");
				for(int i=0;i< top.numberOfAdjacentVertices();i++){
					Vertex<AnyType> v= top.getAdjacentVertex(i);
					if(v.hasBeenVisited()==false&&v!=null) {
						q.add(v);
						v.setVisited(1);
						//buffer.append(v);

					}
				}

			}
			catch(Exception e) {
				run = false;
			}
		}
		
		
		return buffer.toString();
		
	} // end breadthFirstSearch() method
	
	/**
	 * 
	 */
	public void clear() {
		
		vertex_adjacency_list.clear();
		
	} // end clear()
	
	
	/**
	 * 
	 * For debugging purposes only
	 * 
	 */
	public void printAdjacencyList() {
		
		for ( int i=0; i<vertex_adjacency_list.size(); i++ ) {
			
			vertex_adjacency_list.get( i ).printVertex();
			
		}
		
	} // end printGraph() method
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		// -----------------------------------------
		// TODO: Put test cases here
		// -----------------------------------------
		/*UndirectedGraph<Integer> graph = new UndirectedGraph<Integer>();
		graph.addEdge( 1, 2 );
		graph.addEdge( 1, 3 );
		graph.addEdge( 1, 4 );
		graph.addEdge( 2, 3 );
		graph.addEdge( 2, 5 );
		graph.addEdge( 2, 6 );
		graph.addEdge( 2, 4 );
		graph.printAdjacencyList();
		//graph.removeEdge(2,4);
		//graph.removeEdge(1,4);
		//System.out.println("remove edge 2 to 4 and 1 to 4");
		//graph.printAdjacencyList();
		System.out.printf( "\nDFS\n%s", graph.depthFirstSearch( 1 ) );
		System.out.printf( "\nBFS\n%s", graph.breadthFirstSearch( 1 ) );


		UndirectedGraph<Integer> g2 = new UndirectedGraph<Integer>();
		g2.addEdge(40,10);
		g2.addEdge(40,20);
		g2.addEdge(10,30);
		g2.addEdge(20,10);
		g2.addEdge(20,10);
		g2.addEdge(20,30);
		g2.addEdge(20,60);
		g2.addEdge(20,50);
		g2.addEdge(60,70);
		g2.addEdge(50,70);
		System.out.printf( "\nDFS\n%s ", g2.depthFirstSearch( 40 ) );
		System.out.printf( "\nBFS\n%s ", g2.breadthFirstSearch( 40 ) );

		UndirectedGraph<Integer> w = new UndirectedGraph<Integer>();
		w.addEdge(6,1);
		w.addEdge(6,2);
		w.addEdge(6,3);
		w.addEdge(6,4);
		w.addEdge(6,5);
		w.addEdge(1,2);
		w.addEdge(2,3);
		w.addEdge(3,4);
		w.addEdge(4,5);
		w.addEdge(5,1);

		System.out.printf( "\nDFS starting at 6\n%s ", w.depthFirstSearch( 6) );
		System.out.printf( "\nDFS starting at 1\n%s ", w.depthFirstSearch( 1) );
		System.out.printf( "\nBFS starting at 6\n%s ", w.breadthFirstSearch( 6 ) );
		System.out.printf( "\nBFS starting at 1\n%s ", w.breadthFirstSearch( 1 ) );*/

		float points = 0;
		boolean passed = false;

		UndirectedGraph<Integer> graph = new UndirectedGraph<Integer>();


		//Test addEdge Boolean
		System.out.println("----------------------------");
		System.out.println("Test Case 1: AddEdge - Test Boolean Return");
		try {
			passed = graph.addEdge(1, 4);
		}catch(Exception e) {

			passed = false;
		}
		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 1!");
		}

		//Test addEdge String result
		System.out.println("----------------------------");
		System.out.println("Test Case 2: AddEdge - Test String Return");
		String testAddString = "Vertex (1):  [ 47]Vertex (4):  [ 12358]Vertex (7):  [ 16]Vertex (2):  [ 43]Vertex (3):  [ 24]Vertex (5):  [ 46]Vertex (8):  [ 4]Vertex (6):  [ 57]";
		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);

			if (graph.printAdjacencyList().compareTo(testAddString) == 0)
				passed = true;

		}catch(Exception e) {
			passed = false;
		}
		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 2!");
		}

		//Test removeEdge Boolean
		System.out.println("----------------------------");
		System.out.println("Test Case 3: RemoveEdge - Test Boolean Return");
		graph.clear();

		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);

			passed = graph.removeEdge(1, 4);
		}catch(Exception e) {

			passed = false;
		}
		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 3!");
		}

		//Test removeEdge String result
		System.out.println("----------------------------");
		System.out.println("Test Case 4: RemoveEdge - Test String Return");
		String testRemoveString = "Vertex (1):  [ 4]Vertex (4):  [ 1235]Vertex (7):  [ 6]Vertex (2):  [ 43]Vertex (3):  [ 24]Vertex (5):  [ 46]Vertex (6):  [ 57]";
		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);

			graph.removeEdge(1, 7);
			graph.removeEdge(8, 4);

			if (graph.printAdjacencyList().compareTo(testRemoveString) == 0)
				passed = true;

		}catch(Exception e) {
			passed = false;
		}
		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 4!");
		}

		//BFS Test Exception
		System.out.println("----------------------------");
		System.out.println("Test Case 5: BFS - Test For Exceptions");
		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);

			graph.breadthFirstSearch(11);
		}catch(VertexException e) {
			passed = true;
		}catch(Exception e ) {
			passed = false;
		}


		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 5!");
		}

		//BSF Test string result
		System.out.println("----------------------------");
		System.out.println("Test Case 6: BFS - Test For Correct Search");
		String BFSTestString = "1:1\n" +
				"4:2\n" +
				"7:3\n" +
				"2:4\n" +
				"3:5\n" +
				"5:6\n" +
				"8:7\n" +
				"6:8\n";

		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);

			if(graph.breadthFirstSearch(1).compareTo(BFSTestString) == 0 )
				passed = true;
		}catch(Exception e ) {
			passed = false;
		}


		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 6!");
		}

		//DFS Test string result
		System.out.println("----------------------------");
		System.out.println("Test Case 7: DFS - Test For Correct Search");
		String DFSTestString = "1:1\n" +
				"4:5\n" +
				"7:2\n" +
				"2:8\n" +
				"3:7\n" +
				"5:4\n" +
				"8:6\n" +
				"6:3\n";
		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);


			if(graph.depthFirstSearch(1).compareTo(DFSTestString) == 0 )
				passed = true;
		}catch(Exception e ) {
			passed = false;
		}

		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 7!");
		}

		//DFS Test string result LARGE GRAPH
		System.out.println("----------------------------");
		System.out.println("Test Case 6: DFS - Test For Correct Search(Large Graph)");
		DFSTestString = "1:1\n" +
				"4:10\n" +
				"7:6\n" +
				"2:13\n" +
				"3:12\n" +
				"5:9\n" +
				"8:11\n" +
				"6:3\n" +
				"13:2\n" +
				"12:8\n" +
				"9:7\n" +
				"10:4\n" +
				"11:5\n";

		graph.clear();
		passed = false;
		try {
			graph.addEdge(1, 4);
			graph.addEdge(1, 7);
			graph.addEdge(2, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 8);
			graph.addEdge(5, 6);
			graph.addEdge(6, 7);
			graph.addEdge(1, 2);
			graph.addEdge(1, 13);
			graph.addEdge(13, 12);
			graph.addEdge(13, 6);
			graph.addEdge(12, 7);
			graph.addEdge(9, 7);
			graph.addEdge(6, 9);
			graph.addEdge(6, 10);
			graph.addEdge(10, 11);
			graph.addEdge(11, 7);

			if(graph.depthFirstSearch(1).compareTo(DFSTestString) == 0 )
				passed = true;
		}catch(Exception e ) {
			passed = false;
		}


		if (passed) {
			points += 10.00;
			System.out.println("PASSED TEST CASE 8!");
		}



		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("                     Points Possible    Points Received");
		System.out.println("Compiles                  10.00              10.00  ");
		System.out.println("Thorough test cases       10.00                    ");
		System.out.printf("Instructor Test Cases     80.00              %.2f\n", points);
		System.out.printf("                               Total points: %.2f\n", points);
		System.out.println("-------------------------------------------------------");






	} // end main() method

} // end UndirectedGraph class definition
