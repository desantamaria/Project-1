/**
@author Daniel Santamaria
@author Hope Markley
CS2400
2/22/21 
 */
public class ArrayBagTest
{
    public static void main(String[] args) 
	{
        System.out.println("");

        // Adding to an initially empty bag with sufficient capacity
        System.out.println("Testing an initially empty bag 1 with " +
                            " sufficient capacity:");
		BagInterface<String> aBag = new ResizeableArrayBag<>(7);
		String[] contentsOfBag1 = {"A", "B", "B", "C", "D", "D", "D"};
		testAdd(aBag, contentsOfBag1);

        // Filling an initially empty bag to capacity
        System.out.println("\nTesting an initially empty bag 2 that " +
                            " will be filled to capacity:");
		BagInterface<String> bBag = new ResizeableArrayBag<>(6);
        String[] contentsOfBag2 = {"A", "B", "B", "B", "D", "D"};
        testAdd(bBag, contentsOfBag2);

        System.out.println("");

        //Testing the union method
        //note: will be reusing the previously created bag (aBag) for this test, as it is not needed to create new ones.
        testUnion(aBag, contentsOfBag1, bBag, contentsOfBag2);
        System.out.println("");

        testUnion(bBag, contentsOfBag2, aBag, contentsOfBag1);
        System.out.println("");

        
        //Testing the intersection method
        //note: same as before -- feel free to assign new values to these bags, however redundant that may be.
        testIntersection(aBag, contentsOfBag1, bBag, contentsOfBag2);
        System.out.println("");

        testIntersection(bBag, contentsOfBag2, aBag, contentsOfBag1);
        System.out.println("");
        
        
        //Testing the difference method
        //note: same as before -- feel free to assign new values to these bags, however redundant that may be.
        testDifference(aBag, contentsOfBag1, bBag, contentsOfBag2);
        System.out.println("");

        testDifference(bBag, contentsOfBag2, aBag, contentsOfBag1);
        System.out.println("");

	} // end main
	
    // Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding the following strings to the bag: ");
		for (int index = 0; index < content.length; index++)
		{
			if (aBag.add(content[index]))
                System.out.print(content[index] + " ");
            else
                System.out.print("\nUnable to add " + content[index] +
                                " to the bag.");
		} // end for
        System.out.println();
      
		displayBag(aBag);
	} // end testAdd

    private static void testUnion(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Unifying the following bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe union of the bags: ");  
        displayBag(firstBag.union(secBag)); //display the union of the two bags

        System.out.println("");
    }

    private static void testIntersection(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Intersecting the following bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe intersection of the bags: ");
        displayBag(firstBag.intersection(secBag));

        System.out.println("");
    }

    private static void testDifference(BagInterface<String> firstBag, String[] firstContent, BagInterface<String> secBag, String[] secContent){
        System.out.print("Finding the difference between the following bags:\nBag 1: ");
        //printing first bag
        displayBag(firstBag);

        //printing second bag
        System.out.print("\nBag 2: ");
        displayBag(secBag);

        System.out.print("\nThe difference of the second bag from the first: ");
        displayBag(firstBag.difference(secBag));

        System.out.println("");
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
	}
}