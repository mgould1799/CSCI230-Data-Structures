package edu.cofc.csci230;

import java.util.EmptyStackException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable<AnyType>> implements Stack<AnyType> {
	
	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();

	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
		list.add(0,t);
		
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
		if(list.size()==0)
			throw new EmptyStackException();
		return list.remove(0);
		
		
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
		if(list.size()==0)
			throw new EmptyStackException();
		return list.get(0);
		
	} // end peek() method
	
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
		/*ConstantTimeStack<Integer> list = new ConstantTimeStack<Integer>();
		for(int i=0;i<10;i++) {
			list.push(i);
			System.out.println(i);
		}
		int x;
		for(int i=0;i<10;i++){
			x=list.pop();
			System.out.println(x);
		}
		//list.pop();
		//list.peek();
		//list.push(null);*/

		/////////////////////////////////////////
		//////////////// Stack //////////////////
		/////////////////////////////////////////

		int points = 0;
		boolean passed;

		java.util.Stack<Integer> javaStack = new java.util.Stack<Integer>();
		ConstantTimeStack<Integer> stack = new ConstantTimeStack<Integer>();

		System.out.println("-------------------------------------------------------------------");
		System.out.println("ConstantTimeStack.java");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("----------------------------------");
		System.out.println("Test Case_1:");

		try{
			stack.pop();
			System.out.println("[Failed]");
		} catch (EmptyStackException e){
			System.out.println("[Passed]");
			points += 10;
		} catch (Exception e) {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_2:");

		try{
			stack.peek();
			System.out.println("[Failed]");
		} catch (EmptyStackException e){
			System.out.println("[Passed]");
			points += 10;
		} catch (Exception e) {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_3:");

		try{
			for(int i = 10; i > 5; i--){
				javaStack.push(i);
				stack.push(new Integer(i));
			}
			System.out.println("[Passed]");
			points += 10;
		} catch (Exception e){
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_4:");

		passed = true;

		try {
			if (!javaStack.peek().equals( stack.peek() ) ){
				passed = false;
			}

			if (!javaStack.pop().equals( stack.pop() ) ) {
				passed = false;
			}

			if (!javaStack.peek().equals( stack.peek() ) ){
				passed = false;
			}

		} catch (Exception e){
			passed = false;
		}

		if (passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_5:");

		try {
			if (javaStack.pop().equals( stack.pop() ) &&
					javaStack.pop().equals( stack.pop() ) &&
					javaStack.pop().equals( stack.pop() ) &&
					javaStack.pop().equals( stack.pop() ) ){

				System.out.println("[Passed]");
				points += 10;
			} else {
				System.out.println("[Failed]");
			}
		} catch (Exception e){
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_6:");

		try{
			stack.pop();
			System.out.println("[Failed]");
		} catch (Exception e){
			System.out.println("[Passed]");
			points += 10;
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_7:");

		java.util.Stack<Integer> javaStack2 = new java.util.Stack<Integer>();
		ConstantTimeStack<Integer> stack2 = new ConstantTimeStack<Integer>();

		passed = true;

		try{
			for(int i = 20; i >= 5; i--){
				javaStack2.push(i);
				stack2.push(new Integer(i));
			}

			if (!javaStack2.pop().equals( stack2.pop() ) ||
					!javaStack2.pop().equals( stack2.pop() ) ){
				passed = false;
			}

			for(int i = 6; i <= 8; i++){
				javaStack2.push(i);
				stack2.push(new Integer(i));
			}

			if (!javaStack2.pop().equals( stack2.pop() ) ||
					!javaStack2.pop().equals( stack2.pop() ) ||
					!javaStack2.pop().equals( stack2.pop() ) ||
					!javaStack2.pop().equals( stack2.pop() ) ||
					!javaStack2.pop().equals( stack2.pop() ) ){
				passed = false;
			}

		} catch (Exception e){
			passed = false;
		}

		if (passed){
			System.out.println("[Passed]");
			points += 10;
		} else {
			System.out.println("[Failed]");
		}


		System.out.println("----------------------------------");
		System.out.println("----------------------------------");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("                                 Points Possible    Points Received");
		System.out.println("ConstantTimeStack Compiles             10                 10  ");
		System.out.println("ConstantTimeStack Meets...");
		System.out.println("   Time Complexity                     15                     ");
		System.out.println("Thorough test cases                     5                     ");
		System.out.println("Instructor Test Cases                  70                 " + points);
		System.out.println("   (7 @ 10pts each)");
		System.out.println("                                                  Total points: " + (points+10));
		System.out.println("-------------------------------------------------------------------");



	} // end main method

} // end ConstantTimeStack class definition
