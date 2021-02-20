/**
Daniel Santamaria, Hope Markley
CS2600
2/19/21 
 */
public class LinkedBagTest
{
    public static void main(String[] args) 
	{
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        testIsEmpty(aBag, true);
		displayBag(aBag);
      
        String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
	} // end main
   
    
    private static void testIsEmpty(BagInterface<String> bag, boolean empty)
    {
        System.out.print("\nTesting isEmpty with ");
        if (empty)
            System.out.println("an empty bag:");
        else
            System.out.println("a bag that is not empty:");
      
        System.out.print("isEmpty finds the bag ");
        if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
	} // end testIsEmpty
   
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