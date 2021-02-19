/**
Daniel Santamaria
CS2600
2/9/21 
 */
public class ArrayBagTest
{
    public static void main(String[] args) 
	{
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new ResizeableArrayBag<>();
        System.out.println(aBag.isEmpty());
	}
}