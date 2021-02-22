/**
@author Daniel Santamaria
@author Hope Markley
CS2400
2/22/21 
 */
public class LinkedBagTest
{
    public static void main(String[] args) 
	{
        
        //Testing the isEmpty() method.
        System.out.println("Creating an empty bag.");
        BagInterface<String> emptyBag = new LinkedBag<>();
        testIsEmpty(emptyBag, true);
		displayBag(emptyBag);
      
        String[] contentsOfBag = {"A"};
		testAdd(emptyBag, contentsOfBag);
		testIsEmpty(emptyBag, false);

        System.out.println("");

        // Adding to an initially empty bag with sufficient capacity
        System.out.println("Testing an initially empty bag with " +
                            " sufficient capacity:");
		BagInterface<String> aBag = new LinkedBag<>();
		String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
		testAdd(aBag, contentsOfBag1);

        // Filling an initially empty bag to capacity
        System.out.println("\nTesting an initially empty bag that " +
                            " will be filled to capacity:");
		aBag = new LinkedBag<>();
		String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D",
                                 "another string"};
		testAdd(aBag, contentsOfBag2);

        //Testing the union method
        System.out.println("\nTesting two bags whose contents will be combined into a new bag:");
        BagInterface<String> bBag = new LinkedBag<>();
        testAdd(bBag, contentsOfBag1);
        //note: will be reusing the previously created bag (aBag) for this test, as it is not needed to create new ones.
        
        testUnion(aBag, contentsOfBag2, bBag, contentsOfBag1);
        System.out.println("");

        testUnion(bBag, contentsOfBag1, aBag, contentsOfBag2);
        System.out.println("");

        
        //Testing the intersection method
        System.out.println("\nTesting the overlap of two bags:");
        //note: same as before -- feel free to assign new values to these bags, however redundant that may be.
        
        testIntersection(aBag, contentsOfBag2, bBag, contentsOfBag1);
        System.out.println("");

        testIntersection(bBag, contentsOfBag1, aBag, contentsOfBag2);
        System.out.println("");
        
        System.out.println(aBag.getFrequencyOf("A/"));

        
        //Testing the difference method
        System.out.println("\nTesting the difference of two bags:");
        //note: same as before -- feel free to assign new values to these bags, however redundant that may be.
        testDifference(aBag, contentsOfBag2, bBag, contentsOfBag1);
        System.out.println("");

        testDifference(bBag, contentsOfBag1, aBag, contentsOfBag2);
        System.out.println("");
                
	} // end main
   
    
    private static void testIsEmpty(BagInterface<String> bag, boolean empty)
    {
        System.out.print("\nTesting isEmpty with ");
        if (empty)
            System.out.println("an empty bag:");
        else
            System.out.println("a bag that is not empty:");
      
        System.out.print("isEmpty finds the bag ");
        if (empty && bag.isEmpty()){
			System.out.println("empty: OK.");
        } else if (empty){
			System.out.println("not empty, but it is: ERROR.");
        }else if (!empty && bag.isEmpty()){
			System.out.println("empty, but it is not empty: ERROR.");
        }else {
			System.out.println("not empty: OK.");   
        }   
	} // end testIsEmpty
    

    // Tests the method add.
    private static void testAdd(BagInterface<String> aBag, String[] content)
    {
        System.out.print("Adding the following strings to the bag: ");
        for (int index = 0; index < content.length; index++)
        {
            if (aBag.add(content[index])){
                System.out.print(content[index] + " ");
            }else{
                System.out.print("\nUnable to add " + content[index] +
                                    " to the bag.");
            }
        } // end for
        System.out.println();
      
        displayBag(aBag);
    } // end testAdd
   
    private static void testUnion(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Unifying the followling bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe union of the bags: ");  
        displayBag(firstBag.union(secBag)); //display the union of the two bags
    }

    private static void testIntersection(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Intersecting the followling bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe intersection of the bags: ");
        displayBag(firstBag.intersection(secBag));
    }

    private static void testDifference(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Finding the difference between the following bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe difference of the second bag from the first: ");
        displayBag(firstBag.intersection(secBag));


        System.out.print("\nNow finding the difference of the first bag from the second:\nBag 1: ");

        displayBag(secBag.intersection(firstBag));
    }

    // Tests the method toArray while displaying the bag.
    private static void displayBag(BagInterface<String> aBag)
    {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.print(bagArray[index] + " ");
        } // end for
      
        System.out.println();
    } // end displayBag
}