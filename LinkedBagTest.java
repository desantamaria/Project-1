public class LinkedBagTest
{
    public static void main(String[] args) 
    {
        System.out.println("Creating an empty bag.");
        BagInterface<String> aBag = new LinkedBag<>();
        
        System.out.println(aBag.isEmpty());
        
    }
}