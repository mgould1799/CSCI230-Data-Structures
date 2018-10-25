package edu.cofc.csci230;
import java.util.*;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Fall 2017
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable<AnyType>> implements List<AnyType> {
     
    // instance variables
    private AnyType[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
        
        array = (AnyType[]) new Comparable[ capacity ];
        
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
        if ( size >= capacity )
            grow();
        
        array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */


        if(index-1<size+1) {
            if (size >=capacity)
                grow();
            AnyType[] temp= (AnyType[]) new Comparable[ capacity ];
            size++;

                for (int pos1 = 0; pos1 < index; pos1++)
                    temp[pos1] = array[pos1];
                temp[index - 1] = t;
                for (int pos2 = index; pos2 < size + 1; pos2++)
                    temp[pos2] = array[pos2 - 1];

                array = temp;

        }
        else if(index-1==size+1)
        {
            if(size>=capacity)
                grow();
            array[index-1]=t;
        }
        else
            throw new IndexOutOfBoundsException();
        
        
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if(index<size)
            array[index-1]=t;
        else
            throw new IndexOutOfBoundsException();
         
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API) to perform left or right
         * shift operations
         * 
         */
         //need to check capacity to see if need to shrink
        AnyType[] temp = (AnyType[]) new Comparable[ capacity ];
        AnyType removedIndex=array[index-1];

        if(index<array.length) {
            //int x = 0;

          /* for(int i=0;i<size;i++) {
               if (i == index - 1) {
                   x++;
                   //System.out.println("x = "+ x);
               }
               temp[i] = array[x];

               if(x<x+1)
                   x++;

           }*/
          for(int i=index-1;i<size-1;i++) {
              array[i]=array[i+1];
          }


            // System.out.println("first loop");
           /* for (int i = 0; i < index - 1; i++) {
                temp[i] = array[i];
               // System.out.println(i);
            }
            //removedIndex = array[index - 1];
            //System.out.println("second loop");
            for (int j = index-2; j < capacity; j++) {
                temp[j] = array[j];
                //System.out.println(array[j]);
            }
            */

            //array = temp;
            size--;
            if (size < capacity / 2)
                shrink();
        }
        else
            throw new IndexOutOfBoundsException();
        return removedIndex;
         
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if(index<size) {
            AnyType getIndex = array[index];
            return getIndex;
        }
        else
            throw new IndexOutOfBoundsException();
        
         
         
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
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        size=0;
        capacity=INITIAL_CAPACITY;
        
         
         
    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        AnyType[] temp;
        if(size==capacity||size>capacity)
            capacity=capacity*2;
         temp= (AnyType[]) new Comparable[ capacity ];
         for(int i=0;i<array.length;i++)
             temp[i]=array[i];
         array=temp;
        
        
        
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        AnyType[] temp;
        if(capacity!=INITIAL_CAPACITY) {
            if (size < capacity / 2)
                capacity = capacity / 2;

            temp = (AnyType[]) new Comparable[capacity];
            for (int i = 0; i < capacity; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        else {
            capacity=INITIAL_CAPACITY;
            temp = (AnyType[]) new Comparable[capacity];
            for (int i = 0; i < capacity; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }


        
        
    } // end shrink() method
    
    
    /**
     * For debugging purposes :)
     * 
     * Note: this only works for integer values 
     * hence, the %d format specifier in the 
     * string format method. If you want a 
     * different specifier, like string %s, 
     * you can change.
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", array[i] ) );    
            }
            
            buffer.append( String.format( "%d ]", array[size-1] ) );
            
        } else {
            
            buffer.append( "] " );
        }
        
        return buffer.toString();
        
    } // end toString()
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         
        /**
         * -------------------------------------------
         * TODO: Put your test cases here
         * 
         */
       /* //do random numbers in for loop to test for adding and removing
        //do not go smaller than initial capacity
        ArrayList<Integer> list = new ArrayList<Integer>();
        /*for(int i=1;i<101;i++)
            list.add(i);
        //for(int i=0;i<list.size();i++)
          //  System.out.println(list.get(i));
        list.add(3,767676);
        System.out.println("add to index 3 767676 "+list.size());
        for(int i=0;i<list.size();i++)
           System.out.println(list.get(i));
        System.out.println("right before remove");
        list.remove(4);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
        list.remove(3);
        System.out.println("removed index 3 & 4 " +" size "+list.size());
        for(int i=0;i<list.size();i++)
           System.out.println(list.get(i));
        System.out.println("removing 80 through 90");
        for(int i=80;i<90;i++)
        {
            int x=list.remove(i);
            System.out.println("x= "+x);
        }
        for(int i=0;i<list.size();i++)
           System.out.println(list.get(i).toString());

        System.out.println("list size "+list.size());
        */
        /*
        for(int i=1;i<101;i++)
            list.add(i);
        System.out.println(Arrays.toString(list.array));
        list.remove(3);
        System.out.println(Arrays.toString(list.array));
        //list.remove(4);
        for(int i=1;i<10;i++)
            list.remove(80);
        System.out.println(Arrays.toString(list.array));
        */
	/*
        int points = 0;
        ArrayList<Integer> testList = new ArrayList<Integer>();
        //SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        boolean passed;

        System.out.println("----------------------------------");
        System.out.println("Test Case_1:");

        try {
            list.get(0);
            System.out.println("[Failed]");
        } catch (IndexOutOfBoundsException e){
            System.out.println("[Passed]");
            points += 10;
        }catch(Exception e){
            passed = false;
            System.out.println("[Failed]");

        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_2:");

        passed = true;

        try {

            for(int i = 0; i < 25; i++){
                testList.add(i, i);
                list.add( new Integer(i));
            }

        } catch( IndexOutOfBoundsException error ) {
            System.out.println( "Got IndexOutOfBoundsException when adding elements to list." );
            passed = false;
        }

        if ( passed ) {

            try{
                for (int i = 0; i < 25; i++){
                    if(testList.get(i).intValue() != list.get(i).intValue() )
                        passed = false;
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println( "Got IndexOutOfBoundsException when getting elements from list." );
                passed = false;
            }

        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        }
        else{
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_3:");

        try {

            list.clear();

            if(list.isEmpty()){
                System.out.println("[Passed]");
                points += 10;
            }
            else{
                System.out.println("[Failed]");
            }

        } catch( IndexOutOfBoundsException error ) {
            System.out.println( "Got IndexOutOfBoundsException when clearing the list." );
            System.out.println("[Failed]");
        } catch(Exception e){
            System.out.println("[Failed]");
        }

        testList.clear();


        System.out.println("----------------------------------");
        System.out.println("Test Case_4:");

        passed = true;

        try{
            for(int i = 0; i < 5; i++){
                testList.add(i, i);
                list.add(i, new Integer(i));
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println( "Got IndexOutOfBoundsException when adding elements to the list." );
            passed = false;
        }catch (Exception e){
            System.out.println( "Got Exception when adding elements to the list." );
            passed = false;
        }

        try{
            for (int i = 0; i < 5; i++){
                if(testList.get(i).intValue() != list.get(i).intValue() )
                    passed = false;
            }
        } catch (IndexOutOfBoundsException e){
            passed = false;
        }catch (Exception e){
            passed = false;
        }

        try{
            testList.add(3, 6);
            list.add(3, new Integer(6));
        } catch (IndexOutOfBoundsException e){
            System.out.println( "Got IndexOutOfBoundsException when adding element @ index to list." );
            passed = false;
        }catch (Exception e){
            passed = false;
        }

        try{
            if(testList.get(0).intValue() != list.get(0).intValue() ||
                    testList.get(3).intValue() != list.get(3).intValue() ||
                    testList.get(5).intValue() != list.get(5).intValue() ) {
                passed = false;
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println( "Got IndexOutOfBoundsException when getting elements from list." );
            passed = false;
        }catch (Exception e){
            passed = false;
        }

        if(passed) {
            System.out.println("[Passed]");
            points += 10;
        }
        else{
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_5:");

        passed = true;

        try{

            testList.clear();
            list.clear();

            testList.add( 10 );
            testList.add( 5 );
            testList.add( 15);
            testList.add( 7 );

            list.add( 10 );
            list.add( 5 );
            list.add( 15);
            list.add( 7 );

            testList.set(1, 10);
            list.set(1, new Integer(10));
        } catch (IndexOutOfBoundsException e){
            System.out.println( "Got IndexOutOfBoundsException when setting elements @ index in list." );
            passed = false;
        }catch (Exception e){
            passed = false;
        }

        try{
            if ( ( list.get(1).intValue() != testList.get(1).intValue() ) ||
                    ( list.get(2).intValue() != testList.get(2).intValue() ) ) {
                passed = false;
            }
        } catch (IndexOutOfBoundsException e){
            passed = false;
        }catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else{
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_6:");

        passed = true;

        try{

            testList.clear();
            list.clear();

            testList.add( 10 );
            testList.add( 5 );
            testList.add( 15);
            testList.add( 7 );

            list.add( 10 );
            list.add( 5 );
            list.add( 15);
            list.add( 7 );

            testList.remove(3);
            list.remove(3);
        } catch (IndexOutOfBoundsException e){
            passed = false;
        }catch (Exception e){
            System.out.println(e);
            passed = false;
        }

        try{
            list.get(5);
            System.out.println("[Failed]");
        } catch (IndexOutOfBoundsException e){
            if(passed){
                System.out.println("[Passed]");
                points += 10;
            } else{
                System.out.println("[Failed]");
            }
        }catch (Exception e){
            passed = false;
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_7:");

        if (list.size() == 3){
            System.out.println("[Passed]");
            points += 10;
        }
        else{
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("Test Case_8:");

        try {

            testList.clear();
            list.clear();

            if(list.size() != 0){
                System.out.println("[Failed]");
            } else{
                System.out.println("[Passed]");
                points += 10;
            }

        } catch( IndexOutOfBoundsException error ) {
            System.out.println("[Failed]");
        }

        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("---------------------------------------------------------------");
        System.out.println("                            Points Possible    Points Received");
        System.out.println("SinglyLinkedList Compiles         10                 10  ");
        System.out.println("SinglyLinkedList Runs              5                  5  ");
        System.out.println("Thorough test cases                5                    ");
        System.out.println("Instructor Test Cases             80                 " + points);
        System.out.println("    (8 @ 10pts each)");
        System.out.println("                                              Total points: " + (points+15));
        System.out.println(“———————————————————————————————“);*/
        int points = 0;
        boolean passed;

        ArrayList<String> list = new ArrayList<String>();

        String island_1 = "Curacao";
        String island_2 = "Aruba";
        String island_3 = "Cayman Brac";
        String island_4 = "Saint Thomas";
        String island_5 = "Saint Lucia";
        String island_6 = "BoraBora";
        String island_7 = "Fiji";
        String island_8 = "Tahiti";
        String island_9 = "Maui";
        String island_10 = "Kangaroo Island";
        String island_11 = "Turks and Caicos";
        String island_12 = "Maldives";
        String island_13 = "Bermuda";
        String island_14 = "Bonaire";
        String island_15 = "Roatan";



        System.out.println("----------------------------------");
        System.out.println("Test Case_1:");

        try{
            list.get(0);
            System.out.println("[Failed]");
        } catch (IndexOutOfBoundsException e){
            System.out.println("[Passed]");
            points += 10;
        } catch(Exception e){
            passed = false;
            System.out.println("[Failed]");

        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_2:");
        passed = true;

        try{
            list.add(0, island_1);
            list.add(island_2);
            list.add(island_3);
            list.add(island_4);
            list.add(4, island_5);
            list.add(0, island_6);
            list.add(island_7);
            list.add(2, island_8);
            list.add(7, island_9);
            list.add(5, island_10);

            if (!list.get(0).equals( "BoraBora" ) ||
                    !list.get(2).equals( "Tahiti" ) ||
                    !list.get(4).equals( "Cayman Brac" ) ||
                    !list.get(6).equals( "Saint Thomas" ) ||
                    !list.get(8).equals( "Maui" ) ){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_3:");
        passed = true;

        try{
            list.add(0, island_11);
            list.add(island_12);
            list.add(island_13);
            list.add(13,island_14);
            list.add(island_15);

            if (!list.get(0).equals( "Turks and Caicos" ) ||
                    !list.get(10).equals( "Fiji" ) ||
                    !list.get(12).equals( "Bermuda" ) ||
                    !list.get(14).equals( "Roatan" ) ){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_4:");
        passed = true;

        try {
            list.set(0, "Bahamas");
            list.set(6, "Jamaica");
            list.set(14, "Tonga");

            if ( !list.get(0).equals( "Bahamas" ) ||
                    !list.get(6).equals( "Jamaica" ) ||
                    !list.get(14).equals( "Tonga" ) ){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_5:");
        passed = true;

        try {
            list.remove(0);
            list.remove(0);
            list.remove(5);
            list.remove(10);
            list.remove(10);

            if ( !list.get(0).equals( "Curacao" ) ||
                    !list.get(2).equals( "Aruba") ||
                    !list.get(4).equals( "Jamaica" ) ||
                    !list.get(6).equals( "Maui" ) ||
                    !list.get(8).equals( "Maldives" ) ){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_6:");
        passed = true;

        try {
            list.remove(1);

            if ( !list.get(0).equals( "Curacao" ) ||
                    !list.get(2).equals( "Cayman Brac" ) ||
                    !list.get(4).equals( "Saint Lucia" ) ||
                    !list.get(6).equals( "Fiji") ||
                    !list.get(8).equals( "Bermuda" ) ){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_7:");
        passed = true;

        try{
            list.clear();

            if (list.size() != 0){
                passed = false;
            }
        } catch (Exception e){
            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("Test Case_8:");
        passed = true;

        try{
            for(int i = 0; i < 1000; i++){
                list.add(i, Integer.toString(i));
            }
        } catch (OutOfMemoryError e){
            passed = false;
        } catch (Exception error ) {

            passed = false;
        }

        if(passed){
            System.out.println("[Passed]");
            points += 10;
        } else {
            System.out.println("[Failed]");
        }



        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("                     Points Possible    Points Received");
        System.out.println("ArrayList Compiles         10                 10  ");
        System.out.println("ArrayList Runs              5                  5  ");
        System.out.println("Thorough test cases         5                    ");
        System.out.println("Instructor Test Cases      80                 " + points);
        System.out.println("   (8 @ 10pts each)");
        System.out.println("                                      Total points: " + (points+15));
        System.out.println("-------------------------------------------------------");





} // end main() method
  
} // end ArrayList class definition

