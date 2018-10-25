package edu.cofc.csci230;

/**
 * 
 * Binary search that does not allow two (or more) binary nodes 
 * in the search tree to have the same element value.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable<AnyType>> {
	
	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;
	
	/**
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 * 
	 * @param root
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {
		
		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}
		
		this.root = new BinaryNode<AnyType>( rootElement ) ;
		
	} // end constructor
	
	/**
	 * If the BST does not have a root node, then the BST is empty. 
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		
		return ( root == null );
		
	} // end isEmpty() method
	
	/**
	 * Make the BST empty, i.e. a BST that has 
	 * no nodes (including a root node).
	 * 
	 */
	public void makeEmpty() {
		
		root = null;
		
	} // end makeEmpty() method
	
	/**
	 * Method that adds a new node with the specified element 
	 * value in the BST.
	 * 
	 * This method has one parameter:
	 *  1) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param element
	 */
	public void add( AnyType element ) throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * 
		 */
		if(root==null){
			BinaryNode<AnyType> newNode = new BinaryNode<AnyType>(element);
			root=newNode;
		}

		else {
			add(root, element);
		}
		
		
	} // end add() method
	
	/**
	 * Private recursive method that adds a new node (with the 
	 * specified element value) in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 * 
	 * If the BST has an existing node with the same element 
	 * value, throw an duplicate element exception.
	 * 
	 * @param node
	 * @param element
	 */
	private void add( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		int compareVar= node.getElement().compareTo(element);
		if(compareVar>0){
			if(node.getLeft()==null) {
				BinaryNode<AnyType> newNode = new BinaryNode<AnyType>(element);
				node.setLeft(newNode);
				newNode.setParent(node);
			}
			else
				add(node.getLeft(),element);
		}
		else if(compareVar<0){
			if(node.getRight()==null) {
				BinaryNode<AnyType> newNode = new BinaryNode<AnyType>(element);
				node.setRight(newNode);
				newNode.setParent(node);
			}
			else
				add(node.getRight(),element);
		}
		else{
			throw new DuplicateElementException();
		}


		
		
		
	} // end add() overloaded method
	
	/**
	 * Method that determines if a node with the specified element value 
	 * exists in the BST. 
	 * 
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @param element
	 * @return
	 */
	public boolean hasElement( AnyType element ) throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return hasElement( root, element );
		
	} // end hasElement() method
	
	/**
	 * Private recursive method that determines if the element is 
	 * currently stored in the BST.
	 * 
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *  
	 *  Hint: use the compareTo() method
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean hasElement( BinaryNode<AnyType> node, AnyType element ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		boolean has=false;
		if(node.getElement().equals(element))
			has=true;
		int compareVar= node.getElement().compareTo(element);
		if(compareVar>0){
			if(node.getLeft()==null) {
				has=false;
			}
			else
				return hasElement(node.getLeft(),element);
		}
		else if(compareVar<0){
			if(node.getRight()==null) {
				has = false;
			}
			else
				return hasElement(node.getRight(),element);
		}
		return has;
		
		
	} // end hasElement() overloaded method
	
	/**
	 * Find the node with the minimum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMin() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMin( root ).getElement();
		
	} // end findMin() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		if(node.getLeft()!=null)
			return findMin(node.getLeft());
		else
			return node;
		
		
		
	} // end findMin() method
	
	/**
	 * Find the node with the maximum element value in the BST.
	 * 
	 * This method has no parameters.
	 * 
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 * 
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMax() throws EmptyBSTException {
		
		if ( isEmpty() )
			throw new EmptyBSTException();
		
		return findMax( root ).getElement();
		
	} // end findMax() method
	
	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 * 
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 * 
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> node ) {
		
		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 * 
		 * Note: Your solution must use recursion
		 * 
		 */
		if(node.getRight()!=null)
			return findMax(node.getRight());
		else
			return node;

		
		
		
	} // end findMax() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
		 * ------------------------------------
		 * TODO: You put your test cases here
		 * 
		 * 
		 */
		try {
			BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(12);
		tree.add(5);
		tree.add(9);
		tree.add(45);
		tree.add(0);
		tree.add(-1);
		tree.add(-77);
		//System.out.println(tree);
		System.out.println(tree.hasElement(-2));
		System.out.println(tree.findMin());
		//tree.add(0);
		}
		catch(Exception e){
			System.out.println("there is an exception");
		}
		
		
	} // end main method
	

} // end BinarySearchTree class
