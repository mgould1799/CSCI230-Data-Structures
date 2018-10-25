package edu.cofc.csci230;
  
 
/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        addNode( new Node<AnyType>(t) );
         
    } // end add() method
    
    /**
     * implementation for public add(AnyType t) method
     * 
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        
        if ( isEmpty() ) headNode = t;
        else getNode( size-1 ).setNextNode( t );
         
        size++;
         
    } // end addNote() method
 
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
    	addNode( index, new Node<AnyType>(t) );
         
    } // end add() method
    
    /*
     * 
     * Implementation for public add(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
     
        
        
    } // end addNode() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        setNode( index, new Node<AnyType>(t) );
         
    } // end set() method
    
    /**
     * 
     * Implementation for public set( int index, AnyType t ) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t ) throws IndexOutOfBoundsException {
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
     
        
    	
    } // end setNode() method

 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
    	
    	return removeNode( index ).getData();
    	
    } // end remove() method
    
    /**
     *
     * Implementation for public remove( int index ) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
        
         
    } // end removeNode() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {
    	
    	return getNode( index ).getData();
    	
    } // end get() method
    
    /**
     *
     * Implementation for public get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
        
         
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 ) ? true : false;
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */

         
    } // end clear method
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
        /**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
         
         
    } // end main() method
  
} // end SinglyLinkedList class definition