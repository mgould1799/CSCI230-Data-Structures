import java.util.Scanner;
import java.util.*;
//import static java.util.Arrays;
/**
 * Meagan Gould
 * CSCI 230 Prof. Munsell
 * This class allows a user to interact with the program entering DNA strands. The program will correct incorrect matches
 * as well as stop running when AGTC are not in the dna strand or not the same length 
 */
public class DNA
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a lower strand of DNA");
        String lower=keyboard.next().toUpperCase(); //lower strand of dna
        System.out.println("Enter an upper strand of DNA");
        String upper=keyboard.next().toUpperCase(); //upper strand of dna 
        List<String> lowerArray = new ArrayList<String>(Arrays.asList(lower.split(""))); //array list of lower dna strand
        List<String> upperArray = new ArrayList<String>(Arrays.asList(upper.split(""))); //array list of upper dna strand
        
        //if statement for length of the upper and lower strands if they do not equal will go to else and terminate 
        if(lower.length()==upper.length())
        {
            boolean charIn=false; //boolean for if ATGC are in the strand
            boolean fine=true; //boolean for if AGTC match the correct strand
            for(int i=0;i<lower.length()&&charIn!=true;i++)
            {
                if(lower.charAt(i)!='A'&&lower.charAt(i)!='T'&&lower.charAt(i)!='G'&&lower.charAt(i)!='C')
                    charIn=true;
                else if(upper.charAt(i)!='A'&&upper.charAt(i)!='T'&&upper.charAt(i)!='G'&&upper.charAt(i)!='C')
                    charIn=true;
                
                
            }
            //if statement that will print if a letter other than agtc are in the strand
            if(charIn==true)
                System.out.println("The entered upper and lower stands must only contain combinations of A,G, C, or T … Exiting program");
            //loop to run through the upper array list and make sure the letters match the correct strand    
            for(int j=0;j<upperArray.size()&&charIn==false;j++)
            {
               //System.out.println(upperArray.get(j)+"\t");
               if(upperArray.get(j).equals("A"))
               {
                   if(lowerArray.get(j).equals("T"))
                   
                       fine=true;
                   else    
                   {
                       lowerArray.add(j,"t");
                       fine=false;
                    }
               
                }
               else if(upperArray.get(j).equals("T"))
               {
                   if(lowerArray.get(j).equals("A"))
                            fine=true;
                   else
                   {
                       lowerArray.add(j,"a");
                       fine=false;
                    }
         
                }
               else if(upperArray.get(j).equals("G"))
               {
                   if(lowerArray.get(j).equals("C"))
                        fine=true;
                   else
                   {
                       lowerArray.add(j,"c");
                       fine=false;
                    }
                }
               else if(upperArray.get(j).equals("C"))
               {
                   if(lowerArray.get(j).equals("G"))
                            fine=true;
                   else
                   {
                       lowerArray.add(j,"g");
                       fine=false;
                    }
                }
                //System.out.println(upperArray.get(j)+ " Upper Strand");
               // System.out.println(lowerArray.get(j)+ " Lower Strand");
        
    
            }
            //if statement that will print if everything is correct matching wise within the upper and lower strands
            if(fine==true&&charIn!=true)
            {
                System.out.print("The entered double-strand DNA pattern is correct … Exiting program");
                
            }
            //if statement for if the lower strand does not match the upper strand and will correct it 
            else if(fine==false)
            {
                String upperDisplay="";
                String lowerDisplay="";
                for(int m=0;m<upperArray.size();m++)
                {
                    upperDisplay+=upperArray.get(m);
                    lowerDisplay+=lowerArray.get(m);
                }
                System.out.println("The entered double-strand DNA pattern had base-pair errors that have been corrected: \t" + upperDisplay + " "+lowerDisplay);
                System.out.println(" .... Exiting the program");
            }
        }
    
        else
            System.out.println("The entered upper and lower strands do not have the same number of chemical bases ... Exiting program");
            
        }
}

