package edu.cofc.csci230;

/**
 * Vertex Class Definition
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class Vertex<AnyType extends Comparable<AnyType>> implements Comparable<Vertex<AnyType>> {
	
	// -------------------------------------
	// Constants
	public static final int NOT_VISITED = -1;
	public static final int NOT_FOUND = -1;
	
	private AnyType value;
	
	// -------------------------------------
	// List to store adjacent vertices
	// -------------------------------------
	private List<Vertex<AnyType>> adjacent_vertex_list = new ArrayList<Vertex<AnyType>>();
	
	// ----------------------------------------
	// visited variable
	private int visited = NOT_VISITED;
	

	/**
	 * 
	 * @param data
	 */
	public Vertex( AnyType value ) {
		
		this.value = value;
		
	} // end constructor
	
	/**
	 * 
	 * @param value
	 */
	public void setValue( AnyType value ) {
		
		this.value = value;
		
	} // end setValue() method
	
	/**
	 * 
	 * @return
	 */
	public AnyType getValue() {
		
		return value;
		
	} // end getValue() method
	
	/**
	 * 
	 */
	public void clear() {
		
		adjacent_vertex_list.clear();
		
	} // end clear() method
	
	/**
	 * 
	 * @return
	 */
	public int numberOfAdjacentVertices() {
		
		return adjacent_vertex_list.size();
		
	} // end numberOfAdjacentVertices() method
	
	
	/**
	 * 
	 * @param vertex
	 * @throws VertexException
	 */
	public void addAdjacentVertex( Vertex<AnyType> vertex ) throws VertexException {
		
		if ( !hasAdjacentVertex( vertex ) ) {
			
			adjacent_vertex_list.add( vertex );
			
		} else {
			
			throw new VertexException( String.format("Vertex %s Exists\n", vertex ) );
			
		}

	} // end addAdjacentVertex() method
	
	
	/**
	 * 
	 * @param data
	 * @throws NodeException
	 */
	public void removeAdjacentVertex( Vertex<AnyType> vertex ) throws VertexException {
		
		if ( hasAdjacentVertex( vertex ) ) {
			
			adjacent_vertex_list.remove( getAdjacentVertexIndex( vertex ) );
			
		} else {
			
			throw new VertexException( String.format("Vertex %s is not adjacent\n", vertex ) );
			
		}

	} // end removeAdjacentVertex() method
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Vertex<AnyType> getAdjacentVertex( int index ) throws IndexOutOfBoundsException {
		
		return adjacent_vertex_list.get(index);
		
	} // end getAdjacentVertex() method
	
	/**
	 * 
	 * @param vertex
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Boolean hasAdjacentVertex( Vertex<AnyType> vertex )  throws IndexOutOfBoundsException  {
		
		Boolean found = true;
		
		for ( int i=0; i<adjacent_vertex_list.size(); i++ ) {
			
			if ( adjacent_vertex_list.get( i ).compareTo( vertex ) == 0 ) return found;
			
		}
		
		return !found;
		
	} // end hasAdjacentVertex() method
	
	
	/**
	 * 
	 * @param vertex
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public int getAdjacentVertexIndex( Vertex<AnyType> vertex )  throws IndexOutOfBoundsException {
		
		for ( int i=0; i<adjacent_vertex_list.size(); i++ ) {
			
			if ( adjacent_vertex_list.get( i ).compareTo( vertex ) == 0 ) return i;
			
		}
		
		return NOT_FOUND;
		
	} // end getAdjacentVertexIndex() method
	
	/**
	 * 
	 * @param visited
	 */
	public void setVisited( int visited ) {
		
		this.visited = visited;
		
	} // end setVisited() method
	
	/**
	 * 
	 * @return
	 */
	public int getVisited() {
		
		return visited;
		
	} // end getVisited();
	
	/**
	 * 
	 * @return
	 */
	public boolean hasBeenVisited() {
		
		return ( visited != NOT_VISITED ? true : false );
		
	} // end hasBeenVisited() method
	
	
	/**
	 * 
	 */
	public String toString() {
		
		return value.toString();
		
	} // end toString() method


	/**
	 * 
	 */
	public int compareTo(Vertex<AnyType> o) {
		
		return this.value.compareTo( o.getValue() );
		
	} // end compareTo() method
	
	
	/**
	 * 
	 * For debugging purposes only
	 * 
	 */
	public void printVertex() {
		
		System.out.printf("Vertex (%s): ", this );
		
		System.out.print( " [ ");
		
		for ( int i=0; i<adjacent_vertex_list.size(); i++ ) {
			
			System.out.printf("%s ", adjacent_vertex_list.get( i ) );
			
		}
		
		System.out.println( "]");
		
	} // end printSelf() method

} // end Vertex class definition

