/**
Daniel Santamaria, Hope Markley
CS2600
2/20/21 
 */

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFUALT_CAPACITY = 25;
    private int numberOfEntries;

    //private boolean integrityOK;
    private int MAX_CAPACITY = 30;

    public ResizableArrayBag() 
    {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[DEFUALT_CAPACITY];
        bag = tempBag;
    }
    
    public ResizableArrayBag(int desiredCapacity)
    {
        if(desiredCapacity <= MAX_CAPACITY)
        {
            numberOfEntries = 0;
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[])new Object[desiredCapacity];
            bag = tempBag;
        }
        else
            throw new IllegalStateException("Attempt to create a bag"
            + "whose capacity exceeds allowed maximum.");
    }

    public void checkIntegrity()
    {
        //if(!integrityOK)
            //throw new SecurityException("Array object is corrupt.");
    }
    
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    
    public boolean isEmpty()
	{
        return numberOfEntries==0;
    }
    
    public boolean isFull()
    {
        return numberOfEntries == bag.length;
    }

    public boolean add(T newEntry)
	{
        checkIntegrity();
        boolean result = true;
        if (isFull())
        {
            doubleCapacity();
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag"
            + "whose capacity exceeds allowed"
            + " maximum of "+ MAX_CAPACITY);
    }

    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    public T remove()
	{
        checkIntegrity();
        T result = removeEntry(numberOfEntries-1);
        return result;
    }

    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);

        return anEntry.equals(result);
    }

    private int getIndexOf(T anEntry)
    {
        int where =-1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numberOfEntries))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    private T removeEntry(int givenIndex) 
    {
        T result = null;
        
        if(!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];
            bag[givenIndex] = bag[numberOfEntries-1];
            bag[numberOfEntries-1] = null;
            numberOfEntries--;  
        }

        return result;
    }

    public void clear()
	{
        while(!isEmpty())
            remove();
    }

    public int getFrequencyOf(T anEntry)
	{
        checkIntegrity();
        int counter = 0;

        for(int index = 0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    public boolean contains(T anEntry)
	{
        checkIntegrity();
        return getIndexOf(anEntry) > -1;

    }

    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        for(int index = 0; index< numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    public T bagContent(int index)
    {
        return bag[index];
    }

    public BagInterface<T> union(BagInterface<T> bag2)
    {
        checkIntegrity();
        BagInterface<T> eveything = new ResizableArrayBag<T>();

        for (int index = 0; index < this.getCurrentSize(); index++) 
        {
            eveything.add(bag [index]);
        }
        for (int index = 0; index < bag2.getCurrentSize(); index++) 
        {
            eveything.add(bag2.bagContent(index));
        }
        return eveything;
    } 

    public BagInterface<T> intersection(BagInterface<T> bag2)
    {
        checkIntegrity();
        BagInterface<T> commonItems = new ResizableArrayBag<>();

        if(this.getCurrentSize() > bag2.getCurrentSize())
        {
            for (int index = 0; index < this.getCurrentSize(); index++) 
            {
                if(bag2.contains(bag [index]))
                    commonItems.add(bag [index]);    
            }
        }
        else
        {
            for (int index = 0; index < bag2.getCurrentSize(); index++) 
            {
                if(this.contains(bag [index]))
                    commonItems.add(bag2.bagContent(index));    
            }
        }

        return commonItems;
    }

    public BagInterface<T> difference(BagInterface<T> bag2)
    {
        checkIntegrity();
        BagInterface<T> leftOver = new ResizableArrayBag<>();

        for (int index = 0; index < this.getCurrentSize(); index++) 
        {
            if(!bag2.contains(bag [index]))
                leftOver.add(bag [index]);    
        }
        return leftOver;
    }
    
}
