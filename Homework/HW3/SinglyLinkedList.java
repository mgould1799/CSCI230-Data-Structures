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
        //Node headTemp=headNode;
        Node addNode= t;
        Node temp=headNode;
        if(headNode==null)
        {
            headNode=addNode;
        }
        else if(index>size){
            throw new IndexOutOfBoundsException();
        }
        else
        {
            for(int i=0;i<index-2;i++)
            {
                temp=temp.getNextNode();
            }
            addNode.setNextNode(temp.getNextNode());
            temp.setNextNode(addNode);
            //temp.setNextNode(cerNode);
            //cerNode.setNextNode(temp.getNextNode());
            size++;
        }
            
       
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

        Node setNode= t;
        Node temp=headNode;
        //int track=0;
        if(headNode==null)
        {
            headNode=setNode;
        }
        else if(index>size) {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            for(int i=0;i<index-2;i++)
            {
                temp=temp.getNextNode();
            }

            setNode.setNextNode(temp.getNextNode().getNextNode());
            temp.setNextNode(setNode);

            //temp.setNextNode(cerNode);
            //cerNode.setNextNode(temp.getNextNode());
            //size++;
        }
        
     
        
        
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
        Node temp=headNode;
        //int track=0;
        
        
        if(index>size) {
        throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<index-2;i++)
        {
            temp=temp.getNextNode();
        }
        Node temp1= temp.getNextNode();
        temp.setNextNode(temp1.getNextNode());
        //temp.setNextNode(cerNode);
        //cerNode.setNextNode(temp.getNextNode());
        size--;
        //get the data back to the user?
        //int val= node.getNextNode().getData();
        //node.setNextNode(null);
        //size--;
        //node1.setNextNode(node2.getNextNode());
        //node2.setNextNode(null);
         
        return temp1;
         
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
        Node headTemp=headNode;
        Node temp=headTemp;
        //int track=0;
        if(index>size){
            throw new IndexOutOfBoundsException();
        }
        
            for(int i=0;i<index;i++)
            {
                temp=temp.getNextNode();
            }
            return temp;
        
         
        
         
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
        headNode=null;
        size=0;
            
        

         
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

       /* SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(1);
        list.size();
        Integer val= list.get(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        try {

            for (int i = 0; i < list.size(); i++)
                System.out.println("orginal list " + list.get(i));
            System.out.println("list size " + list.size());
            list.remove(2);
            System.out.println("remove index 2");
            for (int i = 0; i < list.size(); i++)
                System.out.println("remove list " + list.get(i));
            System.out.println("list size " + list.size());
            System.out.println("put 66 in position 4");
            list.set(4, 66);
            for (int i = 0; i < list.size(); i++)
                System.out.println("set list " + list.get(i));
            System.out.println("list size " + list.size());
            System.out.println("add 7777 at position 3");
            list.add(3, 7777);
            for (int i = 0; i < list.size(); i++)
                System.out.println("add list " + list.get(i));
            System.out.println("size of list " + list.size());
            //list.set(8, 33);
            list.clear();
            System.out.println("clear list");
            for (int i = 0; i < list.size(); i++)
                System.out.println("clear list " + list.get(i));
            System.out.println(list.isEmpty());
        }
        catch(Exception e) {
        System.out.println("Out of bounds");
        }*/
        int points = 0;
        ArrayList<Integer> testList = new ArrayList<Integer>();
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
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
        System.out.println("---------------------------------------------------------------");




} // end main() method
  
} // end SinglyLinkedList class definition