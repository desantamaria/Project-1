

public class ArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private static final int DEFUALT_CAPACITY = 25;
    private int numOfEntries;

    private boolean integrityOK;
    private int MAX_CAPACITY = 30;

    public ArrayBag(int desiredCapacity)
    {
        if(desiredCapacity <= MAX_CAPACITY)
        {
            numOfEntries = 0;
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
        if(!integrityOK)
            throw new SecurityException("Array object is corrupt.");
    }
    
    public int getCurrentSize()
    {
        return numOfEntries;
    }
    public boolean isEmpty()
	{
        return numOfEntries==0;
    }
    
    public boolean isFull()
    {
        return numOfEntries == bag.length;
    }

    public boolean add(T newEntry)
	{
        checkIntegrity();
        boolean result = true;
        if (isFull())
        {
            result = false;
        }
        else
        {
            bag[numOfEntries] = newEntry;
            numOfEntries++;
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

    //Slide 47

    public T remove()
	{
        checkIntegrity();
        T result = removeEntry(numOfEntries-1);
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

        while(!found && (index < numOfEntries))
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
            bag[givenIndex] = bag[numOfEntries-1];
            bag[numOfEntries-1] = null;
            numOfEntries--;  
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

        for(int index = 0; index < numOfEntries; index++)
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
        T[] result = (T[])new Object[numOfEntries];
        for(int index = 0; index< numOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

}
