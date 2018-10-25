package edu.cofc.csci230;

/**
 * Utilities class that will sort (in increasing order)
 * the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort
 *	2. bubble sort
 *	3. insertion sort
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 */

//these sorts will not return a list must iterate through them again to make sure they are sorted
public class Utils {
	
	/**
	 * 
	 */
	private Utils() {
		
	} // end private constructor
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * --------------------------------------
		 * Implement insertion sort algorithm as
		 * described in class and as provided in 
		 * this coding assignment.
		 * 
		 */
		int n=list.size();
		for(int i=0;i<n;i++){
			int min=i;
			for(int j=i+1;j<n;j++){
				if(list.get(j).compareTo(list.get(min))<0)
					min=j;
			}
			list.swap(i,min);
		}
		
		
	} // end selectionSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * --------------------------------------
		 * Implement insertion sort algorithm as
		 * described in class and as provided in 
		 * this coding assignment.
		 * 
		 */
		for(int i=0;i<list.size()-1;i++){
			for(int j=0;j<list.size()-1-i;j++){
				int compareVar=list.get(j+1).compareTo(list.get(j));
				if(compareVar<0) {
					list.swap(j,j+1);
				}
			}
		}
		
		
	} // end bubbleSort() method
	
	/**
	 * 
	 * @param list
	 */
	public static <AnyType extends Comparable> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {
		
		/*
		 * TODO:
		 * --------------------------------------
		 * Implement insertion sort algorithm as
		 * described in class and as provided in 
		 * this coding assignment.
		 * 
		 */
		for(int i=0;i<list.size();i++){
			AnyType v=list.get(i);
			int j= i-1;
			while(j>=0&&list.get(j).compareTo(v)>0){
				list.swap(j+1,j);
				j=j-1;
			}
			list.set(j+1,v);
		}
		
		
		
		
	} // end insertionSort() method
	
} // end Utils class definition
