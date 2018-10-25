package edu.cofc.csci230;

import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for 
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 * 
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment 
 * you may assume the are negligible.
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class SemiConstantTimeQueue<AnyType extends Comparable<AnyType>> implements Queue<AnyType> {
	
	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation (*** not considering capacity 
         * resize operations ***)
         * 
         */
		if(t==null)
			throw new NullPointerException();
		list.add(t);
		
		
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 * 
	 * Hint: shift operations will make this a linear time
	 * operation.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a linear 
         * time O(n) operation. See hint above.
         * 
         *
         */
		if(list.size()==0)
			throw new NoSuchElementException();
		return list.remove(0);
		
		
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
		if(list.size()==0)
			return null;
		return list.get(0);
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
		/*SemiConstantTimeQueue<Integer> list = new SemiConstantTimeQueue<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
			System.out.println(i);
		}
		int x;
		for(int i=0;i<10;i++){
			x=list.remove();
			System.out.println(x);
		}
		//list.add(null);
		System.out.println(list.peek());*/
		/////////////////////////////////////////
		//////////////// Queue //////////////////
		/////////////////////////////////////////

		int points = 0;
		boolean passed;

		java.util.concurrent.ArrayBlockingQueue<Integer> javaQueue = new java.util.concurrent.ArrayBlockingQueue<Integer>(100);
		SemiConstantTimeQueue<Integer> queue = new SemiConstantTimeQueue<Integer>();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("SemiConstantTimeQueue.java");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("----------------------------------");
		System.out.println("Test Case_1:");

		try{
			queue.add(null);
			System.out.println("[Failed]");
		} catch (NullPointerException e){
			System.out.println("[Passed]");
			points += 10;
		} catch (Exception e) {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_2:");

		try{
			queue.remove();
			System.out.println("[Failed]");
		} catch (NoSuchElementException e){
			System.out.println("[Passed]");
			points += 10;
		} catch (Exception e) {
			System.out.println("[Failed]");
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_3:");

		try{
			for(int i = 10; i >= 0; i--){
				javaQueue.add(i);
				queue.add(i);
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
			if (!javaQueue.peek().equals( queue.peek() ) ){
				passed = false;
			}

			if (!javaQueue.remove().equals( queue.remove())){
				passed = false;
			}

			if (!javaQueue.peek().equals( queue.peek() )){
				passed = false;
			}

		} catch (Exception e){
			passed =false;
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
			if (javaQueue.remove().equals( queue.remove() ) &&
					javaQueue.remove().equals( queue.remove() ) &&
					javaQueue.remove().equals( queue.remove() ) &&
					javaQueue.remove().equals( queue.remove() ) ){

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
			queue.add(null);
			System.out.println("[Failed]");
		} catch (Exception e){
			System.out.println("[Passed]");
			points += 10;
		}



		System.out.println("----------------------------------");
		System.out.println("Test Case_7:");

		java.util.concurrent.ArrayBlockingQueue<Integer> javaQueue2 = new java.util.concurrent.ArrayBlockingQueue<Integer>(100);
		SemiConstantTimeQueue<Integer> queue2 = new SemiConstantTimeQueue<Integer>();

		passed = true;

		try{
			for(int i = 20; i >= 5; i--){
				javaQueue2.add(i);
				queue2.add(i);
			}

			if (!javaQueue2.remove().equals( queue2.remove() ) ||
					!javaQueue2.remove().equals( queue2.remove() ) ){
				passed = false;
			}

			for(int i = 6; i <= 8; i++){
				javaQueue2.add(i);
				queue2.add(i);
			}

			if (!javaQueue2.remove().equals( queue2.remove() ) ||
					!javaQueue2.remove().equals( queue2.remove() ) ||
					!javaQueue2.remove().equals( queue2.remove() ) ||
					!javaQueue2.remove().equals( queue2.remove() ) ||
					!javaQueue2.remove().equals( queue2.remove() ) ){
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
		System.out.println("SemiConstantTimeQueue Compiles         10                 10  ");
		System.out.println("SemiConstantTimeQueue Meets...");
		System.out.println("   Time Complexity                     15                     ");
		System.out.println("Thorough test cases                     5                     ");
		System.out.println("Instructor Test Cases                  70                 " + points);
		System.out.println("   (7 @ 10pts each)");
		System.out.println("                                                  Total points: " + (points+10));
		System.out.println("-------------------------------------------------------------------");






	} // end main() method

} // end SemiConstantTimeQueue class definition

